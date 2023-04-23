/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Combate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués
 */
public class MenuCombateTerminado {
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;
    
    public MenuCombateTerminado(){
        mensajes = new ArrayList<>();
        mensajesError = new ArrayList<>();
        
        String mensaje = "Mensaje0";
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
    }

}
