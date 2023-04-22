/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import baseDeDatos.Estado;
import clasesDeJuego.Usuario;
import menus.MenuIniciarSesion;
import sistemas.ExcepcionMalaEntrada;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 *
 * Este controlador gestiona el inicio de sesión en la aplicación. En caso de
 * que no existan usuarios en la base de datos, se indica al usuario que debe
 * registrarse primero.
 */
public class ControladorInicioSesion {

    private MenuIniciarSesion menuIniciarSesion;
    private int modo; 
    private String nick;

    public ControladorInicioSesion() {
        this.menuIniciarSesion = new MenuIniciarSesion();
        this.modo = 0;
    }

    public void iniciarControlador() {
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        if (almacen.obtenerNumUsuarios() != 0) {
            boolean salir = false;
            while (!salir) {
                try {
                    salir = hacerPeticion();
                    if (!salir) {
                        this.modo++;
                    }
                } catch (ExcepcionMalaEntrada e) {
                    e.printStackTrace();
                    System.out.println(e);
                    
                    this.menuIniciarSesion.mostrarMensajeError(this.modo);
                }
            }
        } else {
            this.menuIniciarSesion.mostrarMensajeError(2);
        }

    }

    private boolean validarEntrada(String opcion){
        if (this.modo == 0) {
            return nickExistente(opcion) || opcion.equalsIgnoreCase("salir");
        }
        return comprobarContrasenia(opcion);
    }

    /**
     * En función del modo del controlador, se realizan unas acciones u otras
     * relacionadas con la creación de un usuario.
     *
     * @param opcion
     * @return
     */
    private boolean procesarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        if (this.modo == 0) {
            this.nick = opcion;
            return false;
        }
        iniciarSesion();
        return true;
    }

    /**
     * Comprueba que el nick introducido existe en la base de datos
     *
     * @param nick
     * @return verdadero si existe un usuario en la base de datos con ese nick.
     * Falso en otro caso.
     */
    private boolean nickExistente(String nick) {
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        return almacen.existeUsuario(nick);
    }

    /**
     * Comprueba si la contraseña cumple la longitud establecida y si la
     * contraseña coincide con el usuario elegido.
     *
     * @param contrasenia
     * @return Verdadero si la contraseña cumple la longitud determinada y si
     * coincide con la del usuario introducido. Falso en otro caso.
     */
    private boolean comprobarContrasenia(String contrasenia) {
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        Usuario usuario = almacen.obtenerUsuario(this.nick);
        boolean valido = contrasenia.equalsIgnoreCase("salir") || usuario.compararContrasenia(contrasenia); //(contrasenia.length() >= 8 && contrasenia.length() <= 12) && usuario.compararContrasenia(contrasenia);
        return valido;
    }

    /**
     * Pide al usuario un dato por teclado y comprueba si es válido. La petición
     * y la comprobación van sincronizadas en función del modo
     *
     * @return Verdadero si se ha decidido salir o si después de procesar la
     * entrada hay que salir. Falso en otro caso
     * @throws RuntimeException indica que el dato introducido no es válido
     */
    private boolean hacerPeticion() throws ExcepcionMalaEntrada {
        boolean salir = false;
        String opcion = this.menuIniciarSesion.mostrarMensaje(this.modo);
        boolean valido = validarEntrada(opcion);

        if (valido) {
            salir = procesarEntrada(opcion);
        } else {
            throw new ExcepcionMalaEntrada();
        }

        return salir;
    }

    private void iniciarSesion() {
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        Usuario usuario = almacen.obtenerUsuario(this.nick);
        Estado.ponerUsuarioActivo(usuario);
        boolean esAdmin = usuario.esAdministrador();
        if (esAdmin) {
            ControladorAdmin controladorAdmin = new ControladorAdmin();
            controladorAdmin.iniciarControlador();
        } else {
            ControladorJugador controladorJugador = new ControladorJugador();
            controladorJugador.iniciarControlador();
        }
    }

}
