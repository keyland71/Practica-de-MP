/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenDesafios;
import baseDeDatos.AlmacenPersonajes;
import baseDeDatos.AlmacenUsuarios;
import clasesDeJuego.Combate;
import clasesDeJuego.Desafio;
import clasesDeJuego.Jugador;
import clasesDeJuego.Personaje;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import menus.MenuBorrarCuenta;
import menus.MenuBorrarPersonaje;
import menus.MenuJugador;
import menus.MenuOro;
import menus.MenuRanking;
import practicamp.Juego;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class ControladorJugador {

    private MenuJugador menuJugador;
    private MenuRanking menuRanking;
    private MenuOro menuOro;
    private MenuBorrarPersonaje menuBorrarPersonaje;
    private MenuBorrarCuenta menuBorrarCuenta;
    private int modo;  //0 selección de opción, 1 borrarPersonaje/cuenta (si/no)
    private HashSet opcionesDisponibles;

    public ControladorJugador() {
        this.menuBorrarPersonaje = new MenuBorrarPersonaje();
        this.menuBorrarCuenta = new MenuBorrarCuenta();
        this.menuJugador = new MenuJugador();
        this.menuRanking = new MenuRanking();
        this.menuOro = new MenuOro();
        this.opcionesDisponibles = new HashSet(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));
        this.modo = 0;
    }

    public void iniciarControlador() {

        Personaje p = Juego.estado.obtenerPersonajeActivo();
        ControladorNotificaciones cNot = new ControladorNotificaciones();
        cNot.iniciarControlador();
        if (p != null) {
            this.menuJugador.ponerOro(p.obtenerOro());
        }

        boolean salir = false;
        do {
            this.modo = 0;
            String opcion = this.menuJugador.mostrarMensaje(0);
            if (validarEntrada(opcion)) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuJugador.mostrarMensajeError(0);
            }
        } while (!salir);
        Juego.estado.ponerUsuarioActivo(null);
    }

    private boolean validarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> {
                return this.opcionesDisponibles.contains(opcion);
            }
            case 1 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return false;
    }

    private boolean procesarEntrada(String entrada) {
        String opcion;
        Personaje pActivo = Juego.estado.obtenerPersonajeActivo();
        switch (entrada) {
            case "1" -> {
                List<Jugador> ranking = Juego.estado.obtenerAlmacenUsuarios().obtenerRanking();
                this.menuRanking.mostrarRanking(ranking);
            }
            case "2" -> {
                if (pActivo == null) {
                    this.menuJugador.mostrarMensaje(5);
                } else {
                    ControladorCambiarEquipoActivo cCamEqAc = new ControladorCambiarEquipoActivo(pActivo);
                    cCamEqAc.iniciarControlador();
                }
            }
            case "3" -> {
                if (pActivo != null && Juego.estado.obtenerAlmacenUsuarios().obtenerNumJugadores() >= 2) {
                    ControladorCrearDesafío cCrearDes = new ControladorCrearDesafío();
                    cCrearDes.iniciarControlador();
                    this.menuJugador.ponerOro(pActivo.obtenerOro());
                } else {
                    this.menuJugador.mostrarMensaje((pActivo != null ? 4 : 6));
                }
            }
            case "4" -> {
                mostrarMenuOro();
            }
            case "5" -> {
                if (pActivo != null) {
                    this.menuJugador.mostrarMensajeError(1);
                } else {
                    ControladorCrearPersonaje cCrearPers = new ControladorCrearPersonaje();
                    cCrearPers.iniciarControlador();
                    if (pActivo != null) {
                        this.menuJugador.ponerOro(pActivo.obtenerOro());
                    }
                }
            }
            case "6" -> {
                if (pActivo == null) {
                    this.menuBorrarPersonaje.mostrarMensajeError(1);
                    return false;
                }
                boolean valido;
                do {
                    this.modo = 1;
                    opcion = this.menuBorrarPersonaje.mostrarMensaje(0);
                    valido = validarEntrada(opcion);
                    if (!valido) {
                        this.menuBorrarPersonaje.mostrarMensajeError(0);
                    }
                } while (!valido);
                if (opcion.equalsIgnoreCase("si")) {
                    AlmacenPersonajes almacen = Juego.estado.obtenerAlmacenPersonajes();
                    almacen.borrarPersonaje(pActivo);
                    Juego.estado.quitarPersonajeActivo();
                    this.menuBorrarPersonaje.mostrarMensaje(1);
                    this.menuJugador.ponerOro(0);
                }
            }
            case "7" -> {
                boolean valido;
                int i = 0;
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
                    AlmacenPersonajes almacenP = Juego.estado.obtenerAlmacenPersonajes();
                    almacenP.borrarPersonaje(pActivo);
                    AlmacenUsuarios almacenU = Juego.estado.obtenerAlmacenUsuarios();
                    almacenU.borrarUsuario(Juego.estado.obtenerUsuarioActivo());
                    this.menuBorrarCuenta.mostrarMensaje(i);
                    return true;
                }
            }
            case "8" -> {
                String optSalir = this.menuJugador.mostrarMensaje(3);
                this.modo = 1;
                if (validarEntrada(optSalir)) {
                    return optSalir.equalsIgnoreCase("si");
                }

            }
        }
        return false;
    }

    private void mostrarMenuOro() {
        AlmacenDesafios almacen = Juego.estado.obtenerAlmacenDesafios();
        List<Desafio> desafios = almacen.obtenerDesafiosCompletados(Juego.estado.obtenerUsuarioActivo().obtenerNick());
        if (desafios.isEmpty()) {
            this.menuOro.mostrarMensaje();
        }

        List<Combate> combates = new ArrayList<>();
        for (Desafio desafio : desafios) {
            combates.add(desafio.obtenerCombate());
        }
        this.menuOro.mostrarHistorial(combates);
    }
}
