/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package menus;

/**
 *
 * @author Marcos, Lucía
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MenuCrearPersonaje {
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;  
  
    
    public MenuCrearPersonaje(){
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        this.lector = new Scanner(System.in);
        
        String mensaje = "Introduce el nombre del personaje: ";
        this.mensajes.add(mensaje);
        mensaje = "Introduce el tipo de personaje: ";
        this.mensajes.add(mensaje);
        
        mensaje = "Por favor, introduzca un valor correcto. Pulse cualquier boton para continuar";
        this.mensajesError.add(mensaje);
    }

    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }
    
      public void mostrarMensajeError(int pos) {
        String mensaje = this.mensajesError.get(pos);
        System.out.println(mensaje);
       this.lector.nextLine();
    }
    
}