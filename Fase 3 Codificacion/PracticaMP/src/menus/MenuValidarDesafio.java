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
public class MenuValidarDesafio {
    private List<String> jugadores;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuValidarDesafio(){
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>(); 
       
        String mensaje = "Elige una fortaleza del personaje 1 que activar";
        this.mensajes.add(mensaje);
        mensaje = "Elige una debilidad del personaje 1 que activar";
        this.mensajes.add(mensaje);
        mensaje = "Elige una fortaleza del personaje 2 que activar";
        this.mensajes.add(mensaje);
        mensaje = "Elige una debilidad del personaje 2 que activar";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres validar el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Desafio validado. Pulsa intro para continuar";
        this.mensajes.add(mensaje);
        
        mensaje = "El numero introducido no corresponde con una debilidad/fortaleza";
        this.mensajesError.add(mensaje);   
        mensaje = "Ha introducido un valor no válido. Los valores válidos son 'si' y 'no'";
        this.mensajesError.add(mensaje);
        mensaje = "Operación cancelada";
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
        String mensaje = this.mensajesError.get(pos==4 ? 1:0); //pos=4 implica modo 4, que es en el que se pregunta si está seguro, así que muestra ese mensaje en vez del otro
        System.out.println(mensaje);
       this.lector.nextLine();
    }
}
