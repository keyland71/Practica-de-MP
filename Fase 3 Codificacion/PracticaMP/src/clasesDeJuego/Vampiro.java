/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Vampiro extends Personaje {

    private int edad;

    public Vampiro(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc) {
        super(hab, armas, armaduras, esbirros, vida, poder, mods, desc, 0);
        this.edad = (int) (Math.random() * 1000 + 18);
    }

    public Vampiro(String nombre, Vampiro vampiroModelo) {
        super(nombre, vampiroModelo);
        this.edad = vampiroModelo.obtenerEdad();
    }

    @Override
    public void ponerEsbirros(Set<Esbirro> esbirros) {
        Set<Esbirro> esbirrosSinHumanos = new HashSet<>();
        for (Esbirro esbirro : esbirros) {
            if (!esbirro.tieneHumanos()) {
                esbirrosSinHumanos.add(esbirro);
            }
        }
        super.ponerEsbirros(esbirrosSinHumanos);
    }

    @Override
    public void ponerHabilidadEspecial(HabilidadEspecial hab) {
        if (hab.obtenerTipo().equals(TipoHabilidad.Disciplina)) {
            super.ponerHabilidadEspecial(hab);
        }
    }

    @Override
    public void modificarRecurso() {
        if ((this.obtenerRecurso()) <= 10) {
            this.sumarRecurso(4);
        }
    }

    @Override
    public int calcularPotencialAtaque() {
        int potencialAtaque = super.calcularPotencialAtaque();
        if (this.obtenerRecurso() >= 5) {
            potencialAtaque += 2;
        }
        return potencialAtaque;
    }

    @Override
    public int calcularPotencialDefensa() {
        int potencialDefensa = super.calcularPotencialDefensa();
        if (this.obtenerRecurso() >= 5) {
            potencialDefensa += 2;
        }
        return potencialDefensa;
    }

    @Override
    public void usarHabilidad() {
        this.sumarRecurso(this.obtenerHabilidadEspecial().obtenerCoste() * -1);
    }

    public int obtenerEdad() {
        return this.edad;
    }

}
