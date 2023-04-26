/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.util.Set;

/**
 *
 * @author sergi
 */
public class Demonio extends Esbirro {

    private String pacto;
    private Set<Esbirro> esbirros;

    public Demonio(String nom, int vida, String pac, Set<Esbirro> conjEsb) {
        super(nom, vida);
        this.pacto = pac;
        this.esbirros = conjEsb;
    }

    @Override
    public int obtenerVida() {
        int vidaTotal = super.obtenerVida();
        for (Esbirro esbirro : this.esbirros) {
            vidaTotal += esbirro.obtenerVida();
        }
        return vidaTotal;
    }

    @Override
    public boolean tieneSubordinados() {
        return (!this.esbirros.isEmpty());
    }

    public boolean tieneHumanos() {
        boolean hayHumanos = super.tieneHumanos();
        for (Esbirro esbirro : this.esbirros) {
            hayHumanos |= esbirro.tieneHumanos();
        }
        return hayHumanos;
    }

}
