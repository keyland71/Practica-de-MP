/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import menus.MenuAdmin;
import menus.MenuBorrarCuenta;
import practicamp.Juego;

/**
 * @authos marcos
 * @author lucia
 */
public class ControladorAdmin {

    private MenuAdmin menuAdministrador;
    private MenuBorrarCuenta menuBorrarCuenta;
    private int modo; //0 selección, 

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
        Juego.estado.ponerUsuarioActivo(null);
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
            case "1" -> { // Editar personaje
                ControladorSeleccionarPersonaje cSelPj = new ControladorSeleccionarPersonaje();
                cSelPj.iniciarControlador();
            }
            case "2" -> { // Validar Desafio
                ControladorSeleccionarDesafio cSelDes = new ControladorSeleccionarDesafio();
                cSelDes.iniciarControlador();
            }
            case "3" -> { // Banear usuarios
                ControladorBaneos cBan = new ControladorBaneos(false);
                cBan.iniciarControlador();
            }
            case "4" -> { //Desbanear Usuarios
                ControladorBaneos cBan = new ControladorBaneos(true);
                cBan.iniciarControlador();
            }
            case "5" -> { //Darse de baja/borrar cuenta
                return darseDeBaja();
            }
            case "6" -> { //salir
                String optSalir = this.menuAdministrador.mostrarMensaje(2);
                this.modo = 1;
                boolean valido = validarEntrada(optSalir);
                if (valido) {
                    return optSalir.equals("si");
                }
            }
        }
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
            AlmacenUsuarios almacen = Juego.estado.obtenerAlmacenUsuarios();
            almacen.borrarUsuario(Juego.estado.obtenerUsuarioActivo());
            this.menuBorrarCuenta.mostrarMensaje(i); //borrado correctamente
            return true;
        } else {
            return false;
        }
    }

}
