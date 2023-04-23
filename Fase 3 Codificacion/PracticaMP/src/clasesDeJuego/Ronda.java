/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lucia
 */
public class Ronda implements Serializable {

    static String registroAString(List<Ronda> registroRondas) {
        String result = "";
        int i = 0;
        for (Ronda r:registroRondas){
            result += r.toStringRonda(i) + "\n    ";
            i++;
        }
        
        return result;
    }

    private int vidaInicialA;
    private int vidaInicialB;
    private int vidaFinalA;
    private int vidaFinalB;
    private int ataqueFinalA;
    private int ataqueFinalB;
    private int defensaFinalA;
    private int defensaFinalB;

    public Ronda() {
        this.vidaInicialA = 0;
        this.vidaInicialB = 0; //valor por defecto
        this.vidaFinalA = 0;   //valor por defecto
        this.vidaFinalB = 0;    //valor por defecto
        this.ataqueFinalA = 0; //valor por defecto
        this.ataqueFinalB = 0; //valor por defecto
        this.defensaFinalA = 0; //valor por defecto;
        this.defensaFinalB = 0; //valor por defecto;
    }
    
    public String toStringRonda(int i) {
        String ronda = "Ronda " + Integer.toString(i)
                     + "\n        Datos del desafiante:"
                     + "\n            Vida Inicial: " + Integer.toString(vidaInicialA)
                     + "\n            Vida Final: " + Integer.toString(vidaFinalA)
                     + "\n            Ataque: " + Integer.toString(ataqueFinalA)
                     + "\n            Defensa: " + Integer.toString(defensaFinalA)
                
                     + "\n        Datos del desafiado:"
                     + "\n            Vida Inicial: " + Integer.toString(vidaInicialB)
                     + "\n            Vida Final: " + Integer.toString(vidaFinalB)
                     + "\n            Ataque: " + Integer.toString(ataqueFinalB)
                     + "\n            Defensa: " + Integer.toString(defensaFinalB)
                     ;
        return ronda;
    }

    public void ponerVidaInicialA(int valor) {
        this.vidaInicialA = valor;
    }
    public void ponerVidaInicialB(int valor) {
        this.vidaInicialB = valor;
    }
    public void ponerVidaFinalA(int valor) {
        this.vidaFinalA = valor;
    }
    public void ponerVidaFinalB(int valor) {
        this.vidaFinalB = valor;
    }
    public void ponerAtaqueA(int valor) {
        this.ataqueFinalA = valor;
    }
    public void ponerAtaqueB(int valor) {
        this.ataqueFinalB = valor;
    }
    public void ponerDefensaA(int valor) {
        this.defensaFinalA = valor;
    }
    public void ponerDefensaB(int valor) {
        this.defensaFinalB = valor;
    }
}
