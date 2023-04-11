/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author lucia
 */
public class Combate {
    private Jugador uDesafiante;
    private Jugador uDesafiado;
    private int rondasUsadas;
    private LocalDateTime fecha;
    private String vencedor;
    private String usuarioConEsbirros;
    private int oroGanado;
    private List registroRondas;
    
    
    public Combate (Jugador j1, Jugador j2){
        this.uDesafiante=j1;
        this.uDesafiado=j2;
        this.fecha= fecha.now();
        this.rondasUsadas=0;
        this.vencedor = null;
        this.usuarioConEsbirros=null;
        this.oroGanado=0;
        this.registroRondas=null;   
    }
    
    public void incrementoRondasUsadas (){
        this.rondasUsadas +=1;  //incrementa el valor en 1
    }
    
    public String obtenerFecha (){
        String fechastr = fecha.toString();
        return fechastr;
    }
    
    public void aniadirRonda (Ronda ronda){
        registroRondas.add(ronda);
    }
    public String toString() {
    String combate =  "Partida{" +
            "uDesafiante=" + uDesafiante +
            ", uDesafiado=" + uDesafiado +
            ", rondasUsadas=" + rondasUsadas +
            ", fecha=" + fecha +
            ", vencedor='" + vencedor + '\'' +
            ", usuarioConEsbirros='" + usuarioConEsbirros + '\'' +
            ", oroGanado=" + oroGanado +
            ", registroRonda=" + registroRondas +
            '}';
    return combate;
}
    
    public Jugador obtenerUDessafiado(){
        return uDesafiado;
    }
    
    public Jugador obtenerUDesafiante(){
        return uDesafiante;
    }
}
