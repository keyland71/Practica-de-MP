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
    
    @Override
    public int obtenerVida() {
        int vidaTotal = super.obtenerVida();
        for (Esbirro esbirro : this.esbirros) {
            vidaTotal += esbirro.obtenerVida();
        }
        return vidaTotal;
    }
    
}
