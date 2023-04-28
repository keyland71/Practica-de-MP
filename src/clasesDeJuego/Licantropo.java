/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.util.List;
import java.util.Set;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Licantropo extends Personaje {

    private static int SUMA_RECURSO = 1;
    private static int MAX_RECURSO = 3;

    public Licantropo(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc) {
        super(hab, armas, armaduras, esbirros, vida, poder, mods, desc, 0, SUMA_RECURSO, MAX_RECURSO);
    }

    public Licantropo(String nombre, Licantropo licantropoModelo) {
        super(nombre, licantropoModelo);
    }

    @Override
    public void ponerHabilidadEspecial(HabilidadEspecial hab) {
        if (hab.obtenerTipo().equals(TipoHabilidad.Don)) {
            super.ponerHabilidadEspecial(hab);
        }
    }

    @Override
    public void modificarRecurso() {
        int sumaTotal = this.obtenerSumaRecurso();
        if (this.obtenerRecurso() + sumaTotal > this.obtenerMaxRecurso()) {
            sumaTotal = this.obtenerMaxRecurso() - this.obtenerRecurso();
        }
        this.sumarRecurso(sumaTotal);
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
}
