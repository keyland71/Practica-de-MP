/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sergio de Oro
 * @author Marcos Jimenez
 * @author Lucía Dominguez
 * @author Ángel Marqués
 */
public class MenuCrearDesafio {
    private List<String> jugadores;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuCrearDesafio(){
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>(); 
       
        String mensaje = "¿Cuanto Oro quieres apostar?";
        this.mensajes.add(mensaje);
        mensaje = "¿A quién quieres desafiar (introduce su nick)?";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres crear el desafío? (si/no)";
        this.mensajes.add(mensaje);
        
        mensaje = "No puedes apostar esa cantidad";
        this.mensajesError.add(mensaje);
        mensaje = "No existe un usuario con ese nick";
        this.mensajesError.add(mensaje);
        mensaje = "No has introducido un valor válido. Vuelve a interlo!";
        this.mensajesError.add(mensaje);
        
        this.lector = new Scanner(System.in);
    }
    

    
    public String mostrarMensaje(int pos) {
        String mensaje = this.mensajes.get(pos);
        System.out.println(mensaje);
        String opcion = this.lector.nextLine();
        return opcion;
    }
    public void mostrarMensajeError(int pos) {
        String mensaje = this.mensajesError.get(pos);
        System.out.println(mensaje);
       this.lector.nextLine();
    }
}
