/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Personaje;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués
 */
public class MenuDetallePersonaje {
    private Personaje personaje;
    private Scanner lector;
    
    public MenuDetallePersonaje(Personaje p){
        this.personaje = p;
        this.lector = new Scanner(System.in);
    }
    
    public String mostrarPersonaje(){
        System.out.println(personaje.toString());
        System.out.println("Elige un atributo que modificar, introduciendo su número (1-11)");
        return this.lector.nextLine();
    }
}
