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

public class Armadura extends Equipo {

    public static String fromListToString(List<Armadura> elementos) {
        String result = "";
        int i = 1;
        for (Armadura a : elementos) {
            result += "    " + Integer.toString(i) + ". " + a.obtenerNombre() + "\n";
            i++;
        }
        return result;
    }

    public Armadura(String nombre, int modAtaque, int modDefensa) {
        super(nombre, modAtaque, modDefensa);
    }

    @Override
    public String toString() {
        String result = "        Nombre: " + this.obtenerNombre()
                + "\n        Defensa: " + this.obtenerDefensa()
                + "\n        Ataque: " + this.obtenerAtaque();
        return result;
    }
}
