/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.util.List;
import java.util.Set;



/**
 *
 * @author lucia
 */
public class Licantropo extends Personaje {
    
    public static int rabiaMaxima = 3;
    
    public Licantropo(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc) {
        super(hab, armas, armaduras, esbirros, vida, poder, mods, desc, 0);
    }

    public Licantropo(String nombre, Licantropo licantropoModelo) {
        super(nombre, licantropoModelo);
    }
    
    @Override
    public void ponerHabilidadEspecial(HabilidadEspecial hab) {
        if (hab.obtenerTipo().equals(TipoHabilidad.don)) {
            super.ponerHabilidadEspecial(hab);
        }
    }

    @Override
    public void modificarRecurso() {
        if ((this.obtenerRecurso()) <= Licantropo.rabiaMaxima) {
            this.sumarRecurso(1);
        }
    }

    @Override
    public int calcularPotencialAtaque(int promedioModificadores) {
        int potencialAtaque = super.calcularPotencialAtaque(promedioModificadores) + this.obtenerRecurso();
        return potencialAtaque;
    }

    @Override
    public int calcularPotencialDefensa(int promedioModificadores) {
        int potencialDefensa = super.calcularPotencialDefensa(promedioModificadores) + this.obtenerRecurso();
        return potencialDefensa;
    }
}
