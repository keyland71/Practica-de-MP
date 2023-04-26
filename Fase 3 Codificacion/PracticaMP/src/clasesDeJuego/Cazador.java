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
public class Cazador extends Personaje {

    public static int voluntadMaxima = 3;

    public Cazador(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc) {
        super(hab, armas, armaduras, esbirros, vida, poder, mods, desc, voluntadMaxima);
    }

    public Cazador(String nombre, Cazador cazadorModelo) {
        super(nombre, cazadorModelo);
    }

    @Override
    public void ponerHabilidadEspecial(HabilidadEspecial hab) {
        if (hab.obtenerTipo().equals(TipoHabilidad.Talento)) {
            super.ponerHabilidadEspecial(hab);
        }
    }

    @Override
    public void modificarRecurso() {
        this.sumarRecurso(-1);
    }

    @Override
    public int calcularPotencialAtaque() {
        int potencialAtaque = super.calcularPotencialAtaque() + this.obtenerRecurso();
        return potencialAtaque;
    }

    @Override
    public int calcularPotencialDefensa() {
        int potencialDefensa = super.calcularPotencialDefensa() + this.obtenerRecurso();
        return potencialDefensa;
    }

    @Override
    public void reestablecerPersonaje() {
        this.ponerPuntosRecurso(voluntadMaxima);
    }
}
