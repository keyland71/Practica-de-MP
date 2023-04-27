/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
package clasesDeJuego;

import java.io.Serializable;
import java.util.Collection;

public class Modificador implements Serializable {

    public static String fromListToString(Collection<Modificador> elementos) {
        String result = "";
        int i = 1;
        for (Modificador mod : elementos) {
            result += "    " + Integer.toString(i) + ". " + mod.nombre + (mod.obtenerTipo() == TipoModificador.Debilidad ? "(D)" : "(F)") + "\n";
            i++;
        }
        return result;
    }

    private String nombre;
    private int valor;
    private TipoModificador tipo;
    private boolean estaActivo;

    public Modificador(String nombre, int valor, TipoModificador tipo) {
        this.nombre = nombre;
        this.valor = obtenerIncremento(valor, tipo);
        this.tipo = tipo;
    }

    public int obtenerValor() {
        return this.valor;
    }

    private int obtenerIncremento(int valor, TipoModificador tipo) {
        return switch (tipo) {
            case Fortaleza ->
                valor;
            case Debilidad ->
                valor * (-1);
            default ->
                0;
        };
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public TipoModificador obtenerTipo() {
        return this.tipo;
    }

    public boolean obtenerEstaActivo() {
        return this.estaActivo;
    }

    public void ponerEstaActivo(boolean b) {
        this.estaActivo = b;
    }

}
