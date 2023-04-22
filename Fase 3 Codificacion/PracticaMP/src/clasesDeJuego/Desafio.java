/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author lucia
 */
public class Desafio {
    private Jugador uDesafiante;
    private Jugador uDesafiado;
    private EstadoDesafio estadoCombate;
    private int oroApostado;
    private Combate combate;
    
    
    public Desafio (Jugador j1, Jugador j2,int oro){
     this.uDesafiante = j1;
     this.uDesafiado = j2;
     this.estadoCombate = null;
     this.oroApostado = oro;
     this.combate = null;
}
    
    public EstadoDesafio obtenerEstado (){
        return estadoCombate;
    }
    
    public void cambiarEstado(EstadoDesafio estado){
        estadoCombate = estado;
    }
    
    public int obtenerOroApostado(){
        return oroApostado;
    }
    
    public String resultadoCombate(Combate comb){
       return comb.toStringCombate();
    }
    
    public Combate obtenerCombate(){
       return this.combate;
    }
    
    public Jugador obtenerJugadorDesafiante (){
        return this.uDesafiante;
    }
    
    public Jugador obtenerJugadorDesafiado (){
        return uDesafiado;
    }

    public void devolverOro() {
        this.uDesafiante.obtenerPersonaje().sumarOro(oroApostado);
    }
    
    @Override
    public String toString(){
        return this.uDesafiante.obtenerNick() + " -> " + this.uDesafiado + "(" + Integer.toString(this.oroApostado) + ")"; //Escribe angel -> sergio (300)
    }
}
