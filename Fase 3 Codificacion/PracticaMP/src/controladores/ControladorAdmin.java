/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import java.util.Arrays;
import java.util.HashSet;
import menus.MenuAdmin;
import menus.MenuBorrarCuenta;
import practicamp.Juego;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class ControladorAdmin {

    private MenuAdmin menuAdministrador;
    private MenuBorrarCuenta menuBorrarCuenta;
    private int modo; //0 selección, 
    private HashSet opcionesDisponibles;

    public ControladorAdmin() {
        this.menuAdministrador = new MenuAdmin();
        this.menuBorrarCuenta = new MenuBorrarCuenta();
        this.modo = 0;
        this.opcionesDisponibles = new HashSet(Arrays.asList("1", "2", "3", "4", "5", "6"));
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
                return this.opcionesDisponibles.contains(opcion) || opcion.equalsIgnoreCase("salir");
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
                ControladorSeleccionarPersonaje cSelPj = new ControladorSeleccionarPersonaje();
                cSelPj.iniciarControlador();
            }
            case "2" -> {
                ControladorSeleccionarDesafio cSelDes = new ControladorSeleccionarDesafio();
                cSelDes.iniciarControlador();
            }
            case "3" -> {
                ControladorBaneos cBan = new ControladorBaneos(false);
                cBan.iniciarControlador();
            }
            case "4" -> {
                ControladorBaneos cBan = new ControladorBaneos(true);
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
                }
            }
        }
        return false;
    }

    private boolean darseDeBaja() {
        boolean valido;
        int i = 0;
        String opcion;
        do {
            this.modo = 1;
            opcion = this.menuBorrarCuenta.mostrarMensaje(i);
            valido = validarEntrada(opcion);
            if (!valido) {
                this.menuBorrarCuenta.mostrarMensajeError();
            } else if (opcion.equalsIgnoreCase("no")) {
                break;
            } else {
                i++;
            }
        } while (!valido || i != 2);
        if (opcion.equalsIgnoreCase("si") && i == 2) {
            AlmacenUsuarios almacen = Juego.estado.obtenerAlmacenUsuarios();
            almacen.borrarUsuario(Juego.estado.obtenerUsuarioActivo());
            this.menuBorrarCuenta.mostrarMensaje(i);
            return true;
        } else {
            return false;
        }
    }

}
