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
    public static final int tamPag = 5;

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
            this.menuSel.mostrarMensaje(1); //No hay desafios que validar
            return;
        }

        boolean salir = false;
        do {
            this.modo = 0; //podría dar problemas, igual lo hay que sacar del bucle
            if (this.pagActual * tamPag > this.personajes.size() - 1) { //this is some confusing logic
                //entramos aquí si la página actual NO tiene jugadores
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuSel.mostrarMensaje(5);//No hay desafios que validar
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
                double ultimaPagina = Math.ceil((double) personajes.size() / tamPag) - 1;
                if (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("a") || opcion.equals("salir")){ //salir debe ser con minúsculas, o toca poner 2^5 combinaciones en el case de procesarEntrada
                    return true;
                }
                int mod = personajes.size() % tamPag;
                if (mod == 0 || this.pagActual != ultimaPagina) { // si la última página tiene tamPag elementos o no estamos en la última página
                    for (int i = 1; i <= tamPag; i++) { //el for hace lo mismo que los or, pero dinámico. Permite que los válidos dependan de tamPag
                        if (opcion.equals(Integer.toString(i))) {
                            return true;
                        }
                    }
                    return false;
                }
                // Si estamos en la última página, y esta tiene menos de tamPag elementos
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
        boolean valido;
        String opcion;
        switch (entrada) {
            case "volver" -> {
                this.modo = 0;
            }
            case "s", "S" -> { //suma 1 a la página actual si no estamos en la última. 
                //Para saber si estamos en la última, divide el tamaño de la lista entre el tamaño de página (redondeando hacia arriba), y lo compara con la página actual
                if (this.pagActual != Math.ceil((double) personajes.size() / tamPag) - 1) {
                    this.pagActual++;
                } else {
                    this.menuSel.mostrarMensajeError(2); //no hay más que mostrar
                }
            }
            case "a", "A" -> {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuSel.mostrarMensajeError(2); //no hay más que mostrar
                }
            }
            case "salir" -> {
                return true;
            } //end if
            default -> { // si el usuario ha introducido un numero
                int op = Integer.parseInt(entrada)-1;
                ControladorEditarPersonaje cEdPj = new ControladorEditarPersonaje(this.personajes.get(op));
                cEdPj.iniciarControlador();
                //Juego.estado.guardar() ???
            }
        } //end case 5

        return false;
    }
}
