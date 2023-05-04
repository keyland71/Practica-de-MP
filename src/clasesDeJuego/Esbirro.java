/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Esbirro implements Serializable {

    public static String fromListToString(Collection<Esbirro> elementos) {
        String result = "";
        int i = 1;
        for (Esbirro esb : elementos) {
            result += "    " + Integer.toString(i) + ". " + esb.nombre + "\n";
            i++;
        }
        return result;
    }

    private String nombre;
    private int vida;

    public Esbirro(String nom, int v) {
        this.nombre = nom;
        this.vida = v;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int obtenerVida() {
        return this.vida;
    }

    public boolean tieneSubordinados() {
        return false;
    }

    public boolean tieneHumanos() {
        return false;
    }

}
