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
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
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
            case 0 -> {
                double ultimaPagina = Math.ceil((double) desafios.size() / TAMANIO_PAGINA) - 1;
                if (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("a") || opcion.equals("salir")) {
                    return true;
                }
                int mod = desafios.size() % TAMANIO_PAGINA;
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
            case "s", "S" -> {
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
