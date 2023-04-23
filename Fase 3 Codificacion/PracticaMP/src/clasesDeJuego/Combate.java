/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private Jugador vencedor;
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
        this.registroRondas = new ArrayList<>();
        this.fortDebP1 = new int[2];
        this.fortDebP2 = new int[2];
    }

    public void incrementarRonda() {
        this.rondasUsadas++;  //incrementa el valor en 1
    }

    public String obtenerFecha() {
        return fecha.toString();
    }

    public void aniadirRonda(Ronda ronda) {
        registroRondas.add(ronda);
    }

    public String toStringCombate() {
        String reg = Ronda.registroAString(registroRondas);
        String combate = "Resumen del Combate: "
                + "\n    Usuario Desafiante: " + uDesafiante.obtenerNick()
                + ",\n    Usuario Desafiado: " + uDesafiado.obtenerNick()
                + ",\n    Rondas Usadas: " + Integer.toString(rondasUsadas)
                + ",\n    Fecha: " + fecha.toString()
                + ",\n    Vencedor: " + vencedor.obtenerNick()
                + ",\n    Usuario Con Esbirros Vivos: " + usuarioConEsbirros
                + ",\n    Oro Ganado: " + Integer.toString(oroGanado)
                + ",\n    " + reg; //habrá que revisar cómo escribir el registro de rondas
        return combate;
    }

    public Jugador obtenerUDesafiado() {
        return uDesafiado;
    }

    public Jugador obtenerUDesafiante() {
        return uDesafiante;
    }

    //Son necesarias para mostrar el historial de oro
    public int obtenerOroGanado() {
        return this.oroGanado;
    }

    public Jugador obtenerVencedor() {
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

    public void ponerVencedor(boolean b) {
        this.vencedor = (b ? this.uDesafiante:this.uDesafiado);
    }

    public void ponerUsuarioConEsbirros(boolean b) {
        this.usuarioConEsbirros = (b ? this.uDesafiante:this.uDesafiado).obtenerNick();
    }

    public void ponerOro(int o) {
        this.oroGanado = o;
    }
}
