/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import clasesDeJuego.Jugador;
import java.util.ArrayList;
import java.util.List;
import menus.MenuBaneo;
import practicamp.Juego;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class ControladorBaneos {

    private MenuBaneo menuBan;
    private boolean mostrarBaneados;
    private List<Jugador> jugadores;
    private int modo;
    private int pagActual;
    public static final int TAMANIO_PAGINA = 5;

    public ControladorBaneos(boolean mostrarBan) {
        this.menuBan = new MenuBaneo();
        this.pagActual = 0;
        this.mostrarBaneados = mostrarBan;
        this.modo = 0;
        this.jugadores = new ArrayList<>();
    }

    private void cargarJugadores() {
        AlmacenUsuarios almacen = Juego.estado.obtenerAlmacenUsuarios();
        this.jugadores = almacen.obtenerJugadoresBan(mostrarBaneados);
    }

    public void iniciarControlador() {
        cargarJugadores();
        this.menuBan.ponerJugadores(this.jugadores);
        if (this.jugadores.isEmpty()) {
            this.menuBan.mostrarMensaje(mostrarBaneados ? 7 : 6);
            return;
        }

        boolean salir = false;

        do {
            this.modo = 0;
            if (this.pagActual * TAMANIO_PAGINA > this.jugadores.size() - 1) {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuBan.mostrarMensaje(mostrarBaneados ? 7 : 6);
                    return;
                }
            }
            String opcion = this.menuBan.mostrarPagina(pagActual, mostrarBaneados);
            if (validarEntrada(opcion)) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuBan.mostrarMensajeError(0);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> {
                double ultimaPagina = Math.ceil((double) jugadores.size() / TAMANIO_PAGINA) - 1;
                if (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("a") || opcion.equals("salir")) {
                    return true;
                }
                int mod = jugadores.size() % TAMANIO_PAGINA;
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
        boolean valido;
        String opcion;
        switch (entrada) {
            case "salir" -> {
                return true;
            }
            case "s", "S" -> {
                if (this.pagActual != Math.ceil((double) jugadores.size() / TAMANIO_PAGINA) - 1) {
                    this.pagActual++;
                } else {
                    this.menuBan.mostrarMensajeError(2);
                }
            }
            case "a", "A" -> {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuBan.mostrarMensajeError(2);
                }
            }
            default -> {
                do {
                    this.modo = 1;
                    opcion = this.menuBan.mostrarMensaje(this.mostrarBaneados ? 3 : 2);
                    valido = validarEntrada(opcion);
                    if (!valido) {
                        this.menuBan.mostrarMensajeError(1);
                    }
                } while (!valido);
                if (opcion.equalsIgnoreCase("si")) {
                    int pos = Integer.parseInt(entrada) + this.pagActual * ControladorBaneos.TAMANIO_PAGINA - 1;

                    this.jugadores.get(pos).cambiarBaneo(!mostrarBaneados);
                    Juego.estado.guardar();

                    this.jugadores.remove(pos);
                    this.menuBan.quitarJugador(pos);

                    this.menuBan.mostrarMensaje(this.mostrarBaneados ? 5 : 4);
                }
            }

        }

        return false;
    }
}
