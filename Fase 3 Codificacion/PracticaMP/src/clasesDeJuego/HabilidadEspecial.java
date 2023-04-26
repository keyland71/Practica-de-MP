/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lucia
 */
public class HabilidadEspecial implements Serializable{

    public static String fromListToString(List<HabilidadEspecial> habilidades) {
        String result = "";
        int i = 1;
        for (HabilidadEspecial h:habilidades){
            result += "    " + Integer.toString(i) + ". " + h.nombre + "\n";
            i++;
        }
        return result;
    }

    private String nombre;
    private int ataque;
    private int defensa;
    private int coste;
    private TipoHabilidad tipo; //Se tiene en cuenta que, en el caso de que la habilidad especial sea de tipo Talento, el coste tiene que ser 0

    public HabilidadEspecial(String nom, int at, int def, int cost, TipoHabilidad t){
        this.nombre = nom;
        this.ataque = at;
        this.defensa = def;
        this.coste = cost;
        this.tipo = t;
        
    }
    
    public int obtenerAtaque() {
        return ataque;
    }

    public int obtenerDefensa() {
        return defensa;
    }

    public int obtenerCoste() {
        return coste;
    }

    public TipoHabilidad obtenerTipo() {
        return this.tipo;
    }
    public String obtenerNombre() {
        return this.nombre;
    }

}
