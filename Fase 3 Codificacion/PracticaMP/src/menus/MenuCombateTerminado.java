/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Combate;
import clasesDeJuego.Desafio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuCombateTerminado {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuCombateTerminado() {
        mensajes = new ArrayList<>();
        mensajesError = new ArrayList<>();

        String mensaje = "Si has enviado algun desafio, el oponente todavia no ha respondido";
        this.mensajes.add(mensaje);
        mensaje = "Han respondido a alguno de tus desafios. Aqui esta el resultado:";
        this.mensajes.add(mensaje);

        mensaje = "Por favor, introduzca un valor correcto. Pulse intro para continuar";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

    public void mostrarCombate(Combate c) {
        System.out.println(c.toStringCombate());
        System.out.println("\nPulsa intro para continuar");
        this.lector.nextLine();
    }

    public void mostrarDesafioRechazado(Desafio d) {
        System.out.println("El jugador " + d.obtenerJugadorDesafiado().obtenerNick() + " ha rechazado tu desafio. Se te devolvera el oro que apostaste (" + d.obtenerOro() + ")");
        this.lector.nextLine();
    }

    public void mostrarDesafioCancelado(Desafio d) {
        System.out.println("El desafio " + d.toString() + " ha sido cancelado por un administrador. Se te devolvera el oro que apostaste (" + d.obtenerOro() + ")");
        this.lector.nextLine();
    }

}
