/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas;

import clasesDeJuego.Combate;
import clasesDeJuego.Personaje;
import clasesDeJuego.Ronda;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class DirectorCombate {

    private Combate combate;
    private Ronda rondaActual;
    private Personaje p1;
    private int vidaP1;
    private Personaje p2;
    private int vidaP2;
    public static final int ORO_FIJO = 10;

    public DirectorCombate(Combate c) {
        this.combate = c;

        this.p1 = c.obtenerUDesafiante().obtenerPersonaje();
        this.vidaP1 = this.p1.calcularVida();

        this.p2 = c.obtenerUDesafiado().obtenerPersonaje();
        this.vidaP2 = this.p2.calcularVida();
    }

    public void realizarCombate() {
        while (this.vidaP1 > 0 && this.vidaP2 > 0) {
            realizarRonda();
        }
        if (vidaP1 == vidaP2) {
            p1.reestablecerPersonaje();
            p2.reestablecerPersonaje();
            return;
        }
        boolean ganaP1 = vidaP1 > vidaP2;
        this.combate.ponerVencedor(ganaP1);
        this.combate.ponerUsuarioConEsbirros(null);
        if (ganaP1) {
            if (this.vidaP1 > this.p1.obtenerVida()) {
                this.combate.ponerUsuarioConEsbirros(this.combate.obtenerUDesafiante());
            }
        } else if (this.vidaP2 > this.p2.obtenerVida()) {
            this.combate.ponerUsuarioConEsbirros(this.combate.obtenerUDesafiado());
        }
        p1.reestablecerPersonaje();
        p2.reestablecerPersonaje();
    }

    private void realizarRonda() {
        this.rondaActual = new Ronda();
        this.rondaActual.ponerVidaInicialA(vidaP1);
        this.rondaActual.ponerVidaInicialB(vidaP2);
        realizarTurno(p1, p2);
        realizarTurno(p2, p1);
        if (p1.puedeUsarHabilidad()) {
            p1.usarHabilidad();
        }
        if (p2.puedeUsarHabilidad()) {
            p2.usarHabilidad();
        }
        this.rondaActual.ponerVidaFinalA(vidaP1);
        this.rondaActual.ponerVidaFinalB(vidaP2);
        this.combate.incrementarRonda();
        this.combate.aniadirRonda(rondaActual);
    }

    private void realizarTurno(Personaje atacante, Personaje defensor) {
        int potencial = atacante.calcularPotencialAtaque();
        int ataqueReal = calcularEficacia(potencial);
        if (atacante.obtenerNombre().equalsIgnoreCase(p1.obtenerNombre())) {
            this.rondaActual.ponerAtaqueA(ataqueReal);
        } else {
            this.rondaActual.ponerAtaqueB(ataqueReal);
        }

        potencial = defensor.calcularPotencialDefensa();
        int defensaReal = calcularEficacia(potencial);
        if (atacante.obtenerNombre().equalsIgnoreCase(p1.obtenerNombre())) {
            this.rondaActual.ponerDefensaB(defensaReal);
        } else {
            this.rondaActual.ponerDefensaA(defensaReal);
        }

        if (ataqueReal >= defensaReal) {
            atacante.hacerDanio();
            defensor.recibirDanio();
            if (defensor.obtenerNombre().equals(p1.obtenerNombre())) {
                this.vidaP1--;
            } else {
                this.vidaP2--;
            }
        }
    }

    private int calcularEficacia(int potencial) {
        int result = 0;
        for (int i = 0; i < potencial; i++) {
            int randomNumber = (int) (Math.random() * 6 + 1);
            if (randomNumber == 5 || randomNumber == 6) {
                result++;
            }
        }
        return result;
    }
}
