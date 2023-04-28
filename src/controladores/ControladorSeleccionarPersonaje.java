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
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
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
            case 0 -> {
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
