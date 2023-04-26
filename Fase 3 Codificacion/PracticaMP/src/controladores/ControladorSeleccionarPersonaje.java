/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenPersonajes;
import clasesDeJuego.Personaje;
import java.util.ArrayList;
import java.util.List;
import menus.MenuSeleccionarPersonaje;
import practicamp.Juego;

/**
 *
 * @author Ángel Marqués
 */
public class ControladorSeleccionarPersonaje {

    private MenuSeleccionarPersonaje menuSel;
    private List<Personaje> personajes;
    private int modo;
    private int pagActual;
    public static final int TAMANIO_PAGINA = 5;

    public ControladorSeleccionarPersonaje() {
        this.menuSel = new MenuSeleccionarPersonaje();
        this.pagActual = 0;
        this.modo = 0;
    }

    private void cargarPersonajes() {
        AlmacenPersonajes almacen = Juego.estado.obtenerAlmacenPersonajes();
        this.personajes = new ArrayList<>(almacen.obtenerPersonajes());
    }

    public void iniciarControlador() {
        cargarPersonajes();
        this.menuSel.ponerPersonajes(this.personajes);
        if (this.personajes.isEmpty()) {
            this.menuSel.mostrarMensaje(1);
            return;
        }

        boolean salir = false;
        do {
            this.modo = 0;
            if (this.pagActual * TAMANIO_PAGINA > this.personajes.size() - 1) {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuSel.mostrarMensaje(5);
                    return;
                }
            }
            String opcion = this.menuSel.mostrarPagina(pagActual);
            if (validarEntrada(opcion)) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuSel.mostrarMensajeError(0);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> { //salir, s, a, 1, 2, ..., tamPag
                //si decide salir, siguiente o anterior página, es válido
                //si no decide eso, hay varias opciones.
                //si el número de elementos es múltiplo del tamaño de página, todas las páginas tendrán 5 elementos, por lo que 1-5 serán válidos independientemente de pagActual
                //En caso contrario, última página tendrá menos opciones. Si sólo muestra 4 opciones, 5 no es un input válido
                //por tanto comprobamos si estamos en la última página. Si no estamos, vale 1-5
                //Si estamos en la última página, valen los números del 1 al último que muestre la página
                double ultimaPagina = Math.ceil((double) personajes.size() / TAMANIO_PAGINA) - 1;
                if (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("a") || opcion.equalsIgnoreCase("salir")) {
                    return true;
                }
                int mod = personajes.size() % TAMANIO_PAGINA;
                if (mod == 0 || this.pagActual != ultimaPagina) {
                    for (int i = 1; i <= TAMANIO_PAGINA; i++) {
                        if (opcion.equals(Integer.toString(i))) {
                            return true;
                        }
                    }
                    return false;
                }
                for (int i = 1; i <= mod; i++) {
                    if (opcion.equals(Integer.toString(i))) {
                        return true;
                    }
                }
                return false;
            }
            case 1 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return false;
    }

    private boolean procesarEntrada(String entrada) {
        switch (entrada) {
            case "volver" -> {
                this.modo = 0;
            }
            case "s", "S" -> {
                if (this.pagActual != Math.ceil((double) personajes.size() / TAMANIO_PAGINA) - 1) {
                    this.pagActual++;
                } else {
                    this.menuSel.mostrarMensajeError(2);
                }
            }
            case "a", "A" -> {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuSel.mostrarMensajeError(2);
                }
            }
            case "salir" -> {
                return true;
            }
            default -> {
                int op = Integer.parseInt(entrada) - 1;
                ControladorEditarPersonaje cEdPj = new ControladorEditarPersonaje(this.personajes.get(op));
                cEdPj.iniciarControlador();
            }
        }

        return false;
    }
}
