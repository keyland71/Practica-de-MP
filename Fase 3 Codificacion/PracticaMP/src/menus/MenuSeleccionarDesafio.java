/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Desafio;
import controladores.ControladorSeleccionarDesafio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuSeleccionarDesafio {

    private List<Desafio> desafios;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuSeleccionarDesafio() {
        this.desafios = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "Seleccione un desafio que validar o cancelar (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "¿Quieres validar el desafio, cancelarlo, o volver a la seleccion de desafios? (validar/cancelar/volver)";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres validar el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres cancelar el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Desafio eliminado";
        this.mensajes.add(mensaje);
        mensaje = "No hay desafios que validar";
        this.mensajes.add(mensaje);
        mensaje = "   (s)siguiente pagina\n   (a)anterior pagina\n   (salir) para volver al menu Admin";
        this.mensajes.add(mensaje);
        mensaje = "¿Por que quieres cancelar el desafio?\n   1. Me parece injusto\n   2. Incumple las normas\n   3. Cancelar";
        this.mensajes.add(mensaje);

        mensaje = "El valor introducido no es valido. Por favor introduzca un valor valido. Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor valido (validar/cancelar/volver). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor valido (si/no). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "No hay mas datos que mostrar. Pulse intro para continuar";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarPagina(int n) {
        System.out.println(this.mensajes.get(0));
        int tamPag = ControladorSeleccionarDesafio.TAMANIO_PAGINA;
        for (int i = 0; i <= tamPag - 1; i++) {
            if (i + n * tamPag >= this.desafios.size()) {
                break;
            } else {
                System.out.println(Integer.toString(i + 1) + ". " + this.desafios.get(i + n * tamPag).toString());
            }
        }
        return mostrarMensaje(6);
    }

    public void quitarDesafio(int pos) {
        this.desafios.remove(pos);
    }

    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

    public void ponerDesafios(List<Desafio> challenges) {
        this.desafios.clear();
        this.desafios.addAll(challenges);
    }
}
