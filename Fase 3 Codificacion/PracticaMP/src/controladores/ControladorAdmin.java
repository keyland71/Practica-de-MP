/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import baseDeDatos.Estado;
import menus.MenuAdmin;
import menus.MenuBorrarCuenta;

/**
 * @authos marcos
 * @author lucia
 */
public class ControladorAdmin {

    private MenuAdmin menuAdministrador;
    private MenuBorrarCuenta menuBorrarCuenta;
    //private 
    private int modo; //0 selección, 
    //creo que sólo tendría un modo. Delega todas las opciones, la única vez que introduces un input en este menú es para decidir qué opcion coges
    //el procesamiento desde ahí es cosa del respectivo controlador. (menos posiblemente en el caso de darse de baja o salir) (ángel)

    public ControladorAdmin() {
        this.menuAdministrador = new MenuAdmin();
        this.menuBorrarCuenta = new MenuBorrarCuenta();
        this.modo = 0;
    }

    public void iniciarControlador() {
        boolean salir = false;
        while (!salir) {
            this.modo = 0;
            String opcion = this.menuAdministrador.mostrarMensaje(0);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuAdministrador.mostrarMensajeError(0);
            }
        }
        Estado.ponerUsuarioActivo(null);
    }

    private boolean validarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> {
                return opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("5") || opcion.equals("6") || opcion.equalsIgnoreCase("salir");
            }
            case 1 -> {
                return opcion.equals("si") || opcion.equals("no");
            }
        }
        return false;
    }

    private boolean procesarEntrada(String opcion) {
        switch (opcion) {
            case "1" -> {
                //se llama a controlador editar personajes; 
                //ControladorCambiarEquipo cCaEq = new ControladorCambiarEquipo(); //editar personajes es privado, por lo que habría que llamarlo desde su constructor
                //cCaEq.iniciarControlador();
            }
            case "2" -> {
                //se llama a controlador de validar desafio;
                ControladorSeleccionarDesafio cSelDes = new ControladorSeleccionarDesafio(); //lo mismo que arriba
                cSelDes.iniciarControlador();
            }
            case "3" -> { //banear
                //se llama a controlador de baneos
                ControladorBaneos cBan = new ControladorBaneos(false); //lo mismo que arriba
                cBan.iniciarControlador();
            }
            case "4" -> { //desbanear
                //se llama a controlador de baneos
                ControladorBaneos cBan = new ControladorBaneos(true); //lo mismo que arriba
                cBan.iniciarControlador();
            }
            case "5" -> {
                return darseDeBaja();
            }
            case "6" -> {
                String optSalir = this.menuAdministrador.mostrarMensaje(2);
                this.modo = 1;
                boolean valido = validarEntrada(optSalir);
                if (valido) {
                    return optSalir.equals("si");
                } //end if
            } //end case 5
        } // end switch 1
        return false;
    }

    private boolean darseDeBaja() {
        //pregunta 2 veces si quieres borrar la cuenta. 
        //Si en alguna dices que no, sale inmediatamente. 
        //Si en ambas dices que sí, borra la cuenta.
        boolean valido;
        int i = 0;
        String opcion;
        do {
            this.modo = 1; //el modo es para que de por valido "si" y "no"
            opcion = this.menuBorrarCuenta.mostrarMensaje(i); //seguro que lo quieres borrar?
            valido = validarEntrada(opcion);
            if (!valido) {
                this.menuBorrarCuenta.mostrarMensajeError();
            } else if (opcion.equalsIgnoreCase("no")) {
                break;
            } else { //opcion == si
                i++;
            }
        } while (!valido || i != 2); //se mantiene aquí hasta que reciba 2 veces un input valido
        if (opcion.equalsIgnoreCase("si") && i == 2) {
            AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
            almacen.borrarUsuario(Estado.obtenerUsuarioActivo());
            this.menuBorrarCuenta.mostrarMensaje(i); //borrado correctamente
            return true;
        } else {
            return false;
        }
    }

}
