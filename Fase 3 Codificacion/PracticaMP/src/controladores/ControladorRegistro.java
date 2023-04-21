/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import baseDeDatos.Estado;
import clasesDeJuego.Usuario;
import menus.MenuRegistro;
import sistemas.FabricaUsuarios;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 *
 * Este controlador gestiona el registro de usuarios en la aplicación. Para
 * ello, hace uso de la fábrica de usuarios, con la que, en función de los datos
 * introducidos por el usuario, serán creados jugadores y usuarios.
 */
public class ControladorRegistro {

    private MenuRegistro menuRegistro;
    private FabricaUsuarios fabricaUsuarios;
    private int modo; ////0 nick, 1 nombre, 2 contraseña, 3 tipo

    public ControladorRegistro() {
        this.menuRegistro = new MenuRegistro();
        this.fabricaUsuarios = new FabricaUsuarios();
        this.modo = 0;
    }

    /**
     * Hace peticiones en bucle hasta que se decide salir del menú o, por otro
     * lado, se termina de registrar a un usuario.
     */
    public void iniciarControlador() {
        boolean salir = false;
        while (!salir) {
            try {
                salir = hacerPeticion();
                if (!salir) {
                    this.modo++;
                }
            } catch (RuntimeException e) {
                System.out.println(e);
                this.menuRegistro.mostrarMensajeError(this.modo);
            }
        }
    }

    /**
     * En función del modo del controlador, comprueba si el dato introducido por el usuario es correcto.
     * @param opcion dato introducido por el usuario
     * @return 
     */
    private boolean validarEntrada(String opcion) { //0 nick, 1 nombre, 2 contraseña, 3 tipo
        switch (this.modo) {
            case 0 -> {
                return nickUnico(opcion);
            }
            case 1 -> {
                return opcion.length() > 0;
            }
            case 2 -> {
                return opcion.length() >= 8 && opcion.length() <= 12 || opcion.equalsIgnoreCase("salir");
            }
            default -> { //case 3 
                return opcion.equalsIgnoreCase("admin") || opcion.equalsIgnoreCase("jugador") || opcion.equalsIgnoreCase("salir");
            }
        }
    }

    /**
     * En función del modo del controlador, se realizan unas acciones u otras relacionadas con la creación de un usuario.
     * @param opcion
     * @return 
     */
    private boolean procesarEntrada(String opcion){ //0 nick, 1 nombre, 2 contraseña, 3 tipo
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        switch (this.modo) {
            case 0 -> {
                this.fabricaUsuarios.ponerNick(opcion);
            }
            case 1 -> {
                this.fabricaUsuarios.ponerNombre(opcion);//this.fabricaUsuarios.ponerContrasenia(opcion);
            }
            case 2 -> {
                this.fabricaUsuarios.ponerContrasenia(opcion);//this.fabricaUsuarios.ponerNombre(opcion);
            }
            default -> { //case 3
                registrarUsuario(opcion);
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba que el nick introducido es único
     *
     * @param nick
     * @return verdadero si no existe un usuario en la base de datos con ese
     * nick. Falso en otro caso.
     */
    private boolean nickUnico(String nick) {
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        return !almacen.existeUsuario(nick);
    }

    /**
     * Pide al usuario un dato por teclado y comprueba si es válido. La petición
     * y la comprobación van sincronizadas en función del modo
     *
     * @return Verdadero si se ha decidido salir o si después de procesar la
     * entrada hay que salir. Falso en otro caso
     * @throws RuntimeException indica que el dato introducido no es válido
     */
    private boolean hacerPeticion() throws RuntimeException {
        boolean salir = false;
        String opcion = this.menuRegistro.mostrarMensaje(this.modo); //0 nick, 1 nombre, 2 contraseña, 3 tipo
        boolean valido = validarEntrada(opcion);

        if (valido) {
            salir = procesarEntrada(opcion);
        } else {
            throw new RuntimeException();
        }

        return salir;
    }

    private void registrarUsuario(String opcion) {
        Usuario u;
        if (opcion.equalsIgnoreCase("admin")) {
            u = this.fabricaUsuarios.crearAdministrador();
        } else {
            u = this.fabricaUsuarios.crearJugador();
        }
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        almacen.aniadirUsuario(u);
    }

}
