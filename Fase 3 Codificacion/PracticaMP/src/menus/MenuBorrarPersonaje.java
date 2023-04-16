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
 * @author Ángel Marqués
 */
public class MenuBorrarPersonaje {
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;   
    
    public MenuBorrarPersonaje(){
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        this.lector = new Scanner(System.in);
        
        String mensaje = "¿Seguro que quieres borrar tu personaje? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Personaje borrado correctamente. Pulse intro para continuar.";
        this.mensajes.add(mensaje);
        
        mensaje = "Por favor, introduzca un valor correcto. Pulse cualquier boton para continuar";
        this.mensajesError.add(mensaje);
    }
    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }
 
  public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

}
