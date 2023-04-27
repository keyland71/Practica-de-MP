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
    private static int SUMA_RECURSO = 4;
    private static int MAX_RECURSO = 10;
    private static int LIMITE_RECURSO = 5;
    private static int SUMA_POTENCIAL = 2;

    public Vampiro(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc) {
        super(hab, armas, armaduras, esbirros, vida, poder, mods, desc, 0, SUMA_RECURSO, MAX_RECURSO);
        this.edad = (int) (Math.random() * 1000 + 18);
    }

    public Vampiro(String nombre, Vampiro vampiroModelo) {
        super(nombre, vampiroModelo);
        this.edad = vampiroModelo.obtenerEdad();
    }

    public int obtenerEdad() {
        return this.edad;
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
        int sumaTotal = this.obtenerSumaRecurso();
        if (this.obtenerRecurso() + sumaTotal > this.obtenerMaxRecurso()) {
            sumaTotal = this.obtenerMaxRecurso() - this.obtenerRecurso();
        }
        this.sumarRecurso(sumaTotal);
    }

    @Override
    public int calcularPotencialAtaque() {
        int potencialAtaque = super.calcularPotencialAtaque();
        if (this.obtenerRecurso() >= LIMITE_RECURSO) {
            potencialAtaque += SUMA_POTENCIAL;
        }
        return potencialAtaque;
    }

    @Override
    public int calcularPotencialDefensa() {
        int potencialDefensa = super.calcularPotencialDefensa();
        if (this.obtenerRecurso() >= LIMITE_RECURSO) {
            potencialDefensa += SUMA_POTENCIAL;
        }
        return potencialDefensa;
    }

    /**
     * Se le restará al recurso del vampiro el coste de su habilidad
     */
    @Override
    public void usarHabilidad() {
        int costeFinal = this.obtenerHabilidadEspecial().obtenerCoste() * -1;
        if (this.obtenerRecurso() + costeFinal < 0) {
            costeFinal = this.obtenerRecurso() * -1;
        }
        this.sumarRecurso(costeFinal);
    }

    @Override
    public void hacerDanio() {
        this.modificarRecurso();
    }

}
