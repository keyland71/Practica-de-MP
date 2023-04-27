/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *@author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
package clasesDeJuego;

import java.util.List;

public class Arma extends Equipo {

    public static String fromListToString(List<Arma> elementos) {
        String result = "";
        int i = 1;
        for (Arma a : elementos) {
            result += "    " + Integer.toString(i) + ". " + a.obtenerNombre() + " (" + a.tipo.toString() + ")" + "\n";
            i++;
        }
        return result;
    }

    private Variante tipo;

    public Arma(String nombre, int modAtaque, int modDefensa, Variante tipoArma) {
        super(nombre, modAtaque, modDefensa);
        this.tipo = tipoArma;

    }

    public Variante obtenerVariante() {
        return this.tipo;
    }

    @Override
    public String toString() {
        String result = "        Nombre: " + this.obtenerNombre()
                + "\n        Ataque: " + this.obtenerAtaque()
                + "\n        Defensa: " + this.obtenerDefensa()
                + "\n        Tipo: " + (this.tipo == Variante.unaMano ? "Una mano" : "Dos manos");
        return result;
    }

}
