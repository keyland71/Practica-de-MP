/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import clasesDeJuego.Desafio;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuDesafioPendiente {

    private List<String> mensajes;
    private Scanner lector;

    public MenuDesafioPendiente() {
        this.mensajes = new ArrayList<>();

        String mensaje = "El valor introducido no es correcto. Introduce a para aceptar, o r para rechazar el combate.";
        this.mensajes.add(mensaje);
        mensaje = "No tienes ningun desafio pendiente de ser aceptado";
        this.mensajes.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarResumenDesafio(Desafio d) {
        String mensaje = "Te desafia " + d.obtenerJugadorDesafiante().obtenerNick() + ", con una apuesta de "
                + Integer.toString(d.obtenerOro()) + " piezas de oro.\n"
                + "¿Aceptas(a) o rechazas(r) el desafio? Ten en cuenta que si lo rechazas, deberas pagar "
                + Integer.toString(d.obtenerOro() / 10) + " piezas de oro";
        System.out.println(mensaje);
        return this.lector.nextLine();
    }

    public void mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        this.lector.nextLine();
    }

}
