/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Jugador;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuRanking {

    private Scanner lector;

    public MenuRanking() {
        this.lector = new Scanner(System.in);
    }

    public void mostrarRanking(List<Jugador> ranking) {
        System.out.print("Este es el ranking de Jugadores:");

        for (int i = 0; i < ranking.size(); i++) {
            System.out.print("\n    " + Integer.toString(i + 1) + ". " + ranking.get(i).obtenerNick()
                    + " (" + Integer.toString(ranking.get(i).obtenerVictorias()) + " victorias)");
        }
        System.out.println();
        this.lector.nextLine();
    }
}
