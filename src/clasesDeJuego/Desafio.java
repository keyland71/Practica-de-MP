/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Desafio implements Serializable {

    private Jugador uDesafiante;
    private Jugador uDesafiado;
    private EstadoDesafio estadoCombate;
    private int oroApostado;
    private Combate combate;

    public Desafio(Jugador j1, Jugador j2, int oro) {
        this.uDesafiante = j1;
        this.uDesafiado = j2;
        this.estadoCombate = EstadoDesafio.pendienteValidar;
        this.oroApostado = oro;
        this.combate = new Combate(j1, j2);
    }

    public EstadoDesafio obtenerEstado() {
        return estadoCombate;
    }

    public void cambiarEstado(EstadoDesafio estado) {
        estadoCombate = estado;
    }

    public int obtenerOro() {
        return oroApostado;
    }

    public String resultadoCombate(Combate comb) {
        return comb.toStringCombate();
    }

    public Combate obtenerCombate() {
        return this.combate;
    }

    public Jugador obtenerJugadorDesafiante() {
        return this.uDesafiante;
    }

    public Jugador obtenerJugadorDesafiado() {
        return uDesafiado;
    }

    public void devolverOro() {
        this.uDesafiante.obtenerPersonaje().sumarOro(oroApostado);
    }

    @Override
    public String toString() {
        return this.uDesafiante.obtenerNick() + " -> " + this.uDesafiado.obtenerNick()
                + "(" + Integer.toString(this.oroApostado) + ")";
    }
}
