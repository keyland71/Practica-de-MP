/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Desafio;
import controladores.ControladorSeleccionarDesafio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author burakku
 */
public class MenuSeleccionarDesafio {
    private List<Desafio> desafios;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuSeleccionarDesafio(){
        this.desafios = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>(); 
       
        String mensaje = "Seleccione un desafio que validar o cancelar (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "¿Quieres validar el desafío, cancelarlo, o volver a la selección de desafíos? (validar/cancelar/volver)";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres validar el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres cancelar el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Desafío eliminado";
        this.mensajes.add(mensaje);
        mensaje = "No hay desafíos que validar";
        this.mensajes.add(mensaje);
        mensaje = "   (s)siguiente página\n   (a)anterior página\n   (salir) para volver al menú Admin";
        this.mensajes.add(mensaje);
        mensaje = "¿Por qué quieres cancelar el desafío?\n   1. Me parece injusto\n   2. Incumple las normas\n   3. Cancelar";
        this.mensajes.add(mensaje);
        
        mensaje = "El valor introducido no es válido. Por favor introduzca un valor válido. Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor válido (validar/cancelar/volver). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor válido (si/no). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "No hay más datos que mostrar. Pulse intro para continuar";
        this.mensajesError.add(mensaje);
        
        this.lector = new Scanner(System.in);
    }
    
    public String mostrarPagina(int n) {
        System.out.println(this.mensajes.get(0));
        int tamPag = ControladorSeleccionarDesafio.tamPag;
        for (int i=0;i<=tamPag-1;i++){
            if (i+n*tamPag >= this.desafios.size()){ //si el elemento que se mostraría no existe en el array, no hacemos nada
                break;
            } else{ //la posición en la que vamos a buscar al jugador existe en el array
                System.out.println(Integer.toString(i+1) + ". " + this.desafios.get(i+n*tamPag).toString());
            }
        }
        return mostrarMensaje(6);
    }

    public void quitarDesafio(int pos){
        this.desafios.remove(pos);
    }
    
    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }
    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
       this.lector.nextLine();
    }

    public void ponerDesafios(List<Desafio> challenges) {
        this.desafios.clear();
        this.desafios.addAll(challenges);
    }
}
