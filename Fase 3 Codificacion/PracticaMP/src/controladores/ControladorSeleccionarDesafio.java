/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenDesafios;
import baseDeDatos.AlmacenUsuarios;
import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import clasesDeJuego.Jugador;
import java.util.ArrayList;
import java.util.List;
import menus.MenuSeleccionarDesafio;
import practicamp.Juego;

/**
 *
 * @author Ángel Marqués
 */
public class ControladorSeleccionarDesafio {

    private MenuSeleccionarDesafio menuSel;
    private List<Desafio> desafios;
    private int modo;
    private int pagActual;
    public static final int TAMANIO_PAGINA = 5;

    public ControladorSeleccionarDesafio() {
        this.menuSel = new MenuSeleccionarDesafio();
        this.pagActual = 0;
        this.modo = 0;
    }

    private void cargarDesafios() {
        AlmacenDesafios almacen = Juego.estado.obtenerAlmacenDesafios();
        this.desafios = new ArrayList<>(almacen.obtenerDesafiosAvalidar());
    }

    public void iniciarControlador() {
        cargarDesafios();
        this.menuSel.ponerDesafios(this.desafios);
        if (this.desafios.isEmpty()) {
            this.menuSel.mostrarMensaje(5);
            return;
        }

        boolean salir = false;
        do {
            this.modo = 0;
            if (this.pagActual * TAMANIO_PAGINA > this.desafios.size() - 1) {
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
                double ultimaPagina = Math.ceil((double) desafios.size() / TAMANIO_PAGINA) - 1;
                if (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("a") || opcion.equals("salir")) { //salir debe ser con minúsculas, o toca poner 2^5 combinaciones en el case de procesarEntrada
                    return true;
                }
                int mod = desafios.size() % TAMANIO_PAGINA;
                if (mod == 0 || this.pagActual != ultimaPagina) { // si la última página tiene tamPag elementos o no estamos en la última página
                    for (int i = 1; i <= TAMANIO_PAGINA; i++) { //el for hace lo mismo que los or, pero dinámico. Permite que los válidos dependan de tamPag
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
            case 2 -> {
                return opcion.equalsIgnoreCase("validar") || opcion.equalsIgnoreCase("cancelar") || opcion.equalsIgnoreCase("volver");
            }
            case 3 -> {
                return opcion.equals("1") || opcion.equals("2") || opcion.equals("3");
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
                if (this.pagActual != Math.ceil((double) desafios.size() / TAMANIO_PAGINA) - 1) {
                    this.pagActual++;
                } else {
                    this.menuSel.mostrarMensajeError(3);
                }
            }
            case "a", "A" -> {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuSel.mostrarMensajeError(3);
                }
            }
            case "salir" -> {
                return true;
            }
            default -> {
                do {
                    this.modo = 2;
                    opcion = this.menuSel.mostrarMensaje(1);
                    valido = validarEntrada(opcion);
                    if (!valido) {
                        this.menuSel.mostrarMensajeError(1);
                    }
                } while (!valido);
                if (opcion.equalsIgnoreCase("validar")) {
                    validarDesafio(entrada);
                } else if (opcion.equalsIgnoreCase("cancelar")) {
                    cancelarDesafio(entrada);
                } else {
                    this.modo = 0;
                }
            }
        }

        return false;
    }

    private void validarDesafio(String entrada) {
        int pos = Integer.parseInt(entrada) + this.pagActual * ControladorBaneos.TAMANIO_PAGINA;
        pos--;
        Desafio d = this.desafios.get(pos);
        ControladorValidarDesafio cVaDes = new ControladorValidarDesafio(d);
        boolean desafioTramitado = cVaDes.iniciarControlador();
        if (desafioTramitado) {
            this.desafios.remove(pos);
            this.menuSel.quitarDesafio(pos);
        }
    }

    private void cancelarDesafio(String entrada) {
        String opcion;
        boolean valido;
        do {
            this.modo = 3;
            opcion = this.menuSel.mostrarMensaje(7);
            valido = validarEntrada(opcion);
            if (!valido) {
                this.menuSel.mostrarMensajeError(0);
            }
        } while (!valido);

        this.modo = 0;
        if (opcion.equals("3")) {
            return;
        }

        int pos = Integer.parseInt(entrada) + this.pagActual * ControladorBaneos.TAMANIO_PAGINA;
        pos--;

        Desafio d = this.desafios.get(pos);

        d.devolverOro();

        this.desafios.remove(pos);
        this.menuSel.quitarDesafio(pos);

        d.cambiarEstado(EstadoDesafio.cancelado);

        this.menuSel.mostrarMensaje(4);

        if (opcion.equals("2")) {
            AlmacenUsuarios almacenU = Juego.estado.obtenerAlmacenUsuarios();
            Jugador j = (Jugador) almacenU.obtenerUsuario(d.obtenerJugadorDesafiante().obtenerNick());
            j.cambiarBaneo(true);
            Juego.estado.guardar();
        }
    }
}
