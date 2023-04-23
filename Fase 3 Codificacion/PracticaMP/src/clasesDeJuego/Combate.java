/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author lucia
 */
public class Combate implements Serializable{

    private Jugador uDesafiante;
    private Jugador uDesafiado;
    private int rondasUsadas;
    private LocalDateTime fecha;
    private String vencedor;
    private String usuarioConEsbirros;
    private int oroGanado;
    private List<Ronda> registroRondas;
    private int[] fortDebP1;
    private int[] fortDebP2;

    public Combate(Jugador j1, Jugador j2) {
        this.uDesafiante = j1;
        this.uDesafiado = j2;
        this.fecha = LocalDateTime.now(); //ponía fecha.now, por si diera problemas
        this.rondasUsadas = 0;
        this.vencedor = null;
        this.usuarioConEsbirros = null;
        this.oroGanado = 0;
        this.registroRondas = null;
        this.fortDebP1 = new int[2];
        this.fortDebP2 = new int[2];
    }

    public void incrementoRondasUsadas() {
        this.rondasUsadas++;  //incrementa el valor en 1
    }

    public String obtenerFecha() {
        return fecha.toString();
    }

    public void aniadirRonda(Ronda ronda) {
        registroRondas.add(ronda);
    }

    public String toStringCombate() {
        String combate = "Partida: "
                + "\n    Usuario Desafiante: " + uDesafiante
                + ",\n    Usuario Desafiado: " + uDesafiado
                + ",\n    Rondas Usadas: " + rondasUsadas
                + ",\n    Fecha: " + fecha.toString()
                + ",\n    Vencedor: " + vencedor
                + ",\n    Usuario Con Esbirros Vivos: " + usuarioConEsbirros
                + ",\n    Oro Ganado: " + oroGanado
                + ",\n    registroRonda: " + registroRondas.toString(); //habrá que revisar cómo escribir el registro de rondas
        return combate;
    }

    public Jugador obtenerUDessafiado() {
        return uDesafiado;
    }

    public Jugador obtenerUDesafiante() {
        return uDesafiante;
    }

    //Son necesarias para mostrar el historial de oro
    public int obtenerOroGanado() {
        return this.oroGanado;
    }

    public String obtenerVencedor() {
        return this.vencedor;
    }

    public void ponerFortalezaP1(int f) {
        fortDebP1[0] = f;
    }

    public void ponerDebilidadP1(int f) {
        fortDebP1[1] = f;
    }

    public void ponerFortalezaP2(int f) {
        fortDebP2[0] = f;
    }

    public void ponerDebilidadP2(int f) {
        fortDebP2[1] = f;
    }

    public void resetearModificadores() {
        this.fortDebP1 = new int[2];
        this.fortDebP2 = new int[2];

    }
}
