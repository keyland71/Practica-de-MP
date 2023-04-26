/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author sergi
 */
public class Humano extends Esbirro {

    private NivelLealtad nivelLealtad;

    public Humano(String nom, int vida, NivelLealtad nivel) {
        super(nom, vida);
        this.nivelLealtad = nivel;

    }

    @Override
    public boolean tieneHumanos() {
        return true;
    }
}
