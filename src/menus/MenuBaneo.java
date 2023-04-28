/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Jugador;
import controladores.ControladorBaneos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuBaneo {

    private List<String> jugadores;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuBaneo() {
        this.jugadores = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "Seleccione un usuario que banear (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "Seleccione un usuario que desbanear (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres banear a este usuario? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres desbanear a este usuario? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Usuario baneado. Pulse intro para continuar";
        this.mensajes.add(mensaje);
        mensaje = "Usuario desbaneado. Pulse intro para continuar";
        this.mensajes.add(mensaje);
        mensaje = "Todos los usuarios estan baneados, no se puede banear ningun usuario";
        this.mensajes.add(mensaje);
        mensaje = "No hay ningún usuario baneado";
        this.mensajes.add(mensaje);
        mensaje = "   (s)siguiente página\n   (a)anterior página\n   (salir) para volver al menu Admin";
        this.mensajes.add(mensaje);

        mensaje = "Por favor introduzca un valor valido (s,a,salir, o el numero correspondiente a alguno de los elementos). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor valido (si/no). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "No hay mas datos que mostrar. Pulse intro para continuar";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarPagina(int n, boolean mostrarBaneados) {
        if (mostrarBaneados) {
            System.out.println(this.mensajes.get(1));
        } else {
            System.out.println(this.mensajes.get(0));
        }
        int tamPag = ControladorBaneos.TAMANIO_PAGINA;
        for (int i = 0; i <= tamPag - 1; i++) {
            if (i + n * tamPag >= this.jugadores.size()) {
                break;
            } else {
                System.out.println(Integer.toString(i + 1) + ". " + this.jugadores.get(i + n * tamPag));
            }
        }

        return mostrarMensaje(8);

    }

    public void quitarJugador(int pos) {
        this.jugadores.remove(pos);
    }

    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

    public void ponerJugadores(List<Jugador> jugadores) {
        for (Jugador j : jugadores) {
            this.jugadores.add(j.obtenerNick());
        }
    }
}
