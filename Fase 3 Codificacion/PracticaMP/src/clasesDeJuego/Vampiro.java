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
    public void modificarRecurso() {
        if ((this.obtenerRecurso()) <= 10) {
            this.sumarRecurso(4);
        }
    }

    @Override
    public int calcularPotencialAtaque(int promedioModificadores) {
        int potencialAtaque = this.obtenerPoder() + this.obtenerAtaqueArmas() + this.obtenerAtaqueArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialAtaque += this.obtenerHabilidadEspecial().obtenerAtaque();
        }
        if (this.obtenerRecurso() >= 5) {
            potencialAtaque += 2;
        }
        return potencialAtaque;
    }

    @Override
    public int calcularPotencialDefensa(int promedioModificadores) {
        int potencialDefensa = this.obtenerDefensaArmas() + this.obtenerDefensaArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialDefensa += this.obtenerHabilidadEspecial().obtenerDefensa();
        }
        if (this.obtenerRecurso() >= 5) {
            potencialDefensa += 2;
        }
        return potencialDefensa;
    }

    @Override
    public void usarHabilidad() {
        this.sumarRecurso(this.obtenerHabilidadEspecial().obtenerAtaque() * -1);
    }

    public int obtenerEdad() {
        return this.edad;
    }

}
