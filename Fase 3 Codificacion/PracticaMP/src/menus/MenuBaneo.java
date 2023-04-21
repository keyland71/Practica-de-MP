/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Jugador;
import controladores.ControladorBaneos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author burakku
 */
public class MenuBaneo {
    private List<String> jugadores;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuBaneo(){
        this.jugadores = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>(); 
       
        String mensaje = "Seleccione un usuario que banear (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "Seleccione un usuario que desbanear (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres banear a este usuario? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Usuario baneado. Pulse intro para continuar";
        this.mensajes.add(mensaje);
        mensaje = "Todos los usuarios están baneados, no se puede banear ningún usuario";
        this.mensajes.add(mensaje);
        mensaje = "No hay ningún usuario baneado";
        this.mensajes.add(mensaje);
        mensaje = "   (s)siguiente página\n   (a)anterior página\n   (salir) para volver al menú Admin";
        this.mensajes.add(mensaje);
        
        mensaje = "Por favor introduzca un valor válido (1,2,3,4,5,s,a,salir). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor válido (si/no). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "No hay más datos que mostrar. Pulse intro para continuar";
        this.mensajesError.add(mensaje);
        
        this.lector = new Scanner(System.in);
    }
    
    public String mostrarPagina(int n, boolean mostrarBaneados) {
        if (mostrarBaneados){
            System.out.println(this.mensajes.get(1));
        } else {
            System.out.println(this.mensajes.get(0));
        }
        int tamPag = ControladorBaneos.tamPag;
        for (int i=0;i<=tamPag-1;i++){
            if (i+n*tamPag >= this.jugadores.size()){ //si el elemento que se mostraría no existe en el array, no hacemos nada
                break;
            } else{ //la posición en la que vamos a buscar al jugador existe en el array
                System.out.println(Integer.toString(i+1) + ". " + this.jugadores.get(i+n*tamPag));
            }
        }
        
        return mostrarMensaje(6);
        
    }

    public void quitarJugador(int pos){
        this.jugadores.remove(pos);
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

    public void ponerJugadores(List<Jugador> jugadores) {
        for (Jugador j:jugadores){
            this.jugadores.add(j.obtenerNick());
        }
    }
}
