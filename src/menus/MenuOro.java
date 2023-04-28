/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Combate;
import java.util.List;
import java.util.Scanner;
import practicamp.Juego;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuOro {

    private Scanner lector;

    public MenuOro() {
        this.lector = new Scanner(System.in);
    }

    public String mostrarHistorial(List<Combate> combates) {
        int i = 1;
        for (Combate c : combates) {
            mostrarCombate(c, i);
            i++;
        }
        System.out.println("Pulsa intro para volver");
        return this.lector.nextLine();
    }

    private void mostrarCombate(Combate combate, int num) {
        String fecha = combate.obtenerFecha();
        int oro = combate.obtenerOroGanado();
        String vencedor = combate.obtenerVencedor().obtenerNick();
        String oponente = combate.obtenerUDesafiado().obtenerNick();
        if (Juego.estado.obtenerUsuarioActivo().obtenerNick().equalsIgnoreCase(oponente)) {
            oponente = combate.obtenerUDesafiante().obtenerNick();
        }
        if (!Juego.estado.obtenerUsuarioActivo().obtenerNick().equals(vencedor)) {
            oro = -oro;
        }
        System.out.println("Combate " + num + ": " + "\n    Oponente: " + oponente + "\n    Oro ganado: " + oro + "\n    Fecha: " + fecha);
    }

    public void mostrarMensaje() {
        System.out.println("No has participado en ningun combate todavia. Pulse intro para continuar");
        this.lector.nextLine();
    }
}
