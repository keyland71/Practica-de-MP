/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués
 */
public class MenuRanking { //Hay que ver cómo hacemos el ranking
    //private List <String> mensajes;
    private Scanner lector;
    
    public MenuRanking(){
        //carga el ranking
        this.lector = new Scanner(System.in);
    }
    public void mostrarRanking(){
        System.out.println("Aquí se mostrará el ranking una vez implementado. Pulsa intro para continuar");
        this.lector.nextLine();
        return;
    }
}
