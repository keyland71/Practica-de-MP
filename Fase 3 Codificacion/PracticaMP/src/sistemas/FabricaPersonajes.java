/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas;

import clasesDeJuego.Arma;
import clasesDeJuego.Armadura;
import clasesDeJuego.Cazador;
import clasesDeJuego.Esbirro;
import clasesDeJuego.HabilidadEspecial;
import clasesDeJuego.Licantropo;
import clasesDeJuego.Modificador;
import clasesDeJuego.Vampiro;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Marcos, Lucía
 */
public class FabricaPersonajes implements Serializable {

    private Vampiro modeloVampiro;
    private Licantropo modeloLicantropo;
    private Cazador modeloCazador;

    public FabricaPersonajes() {
    }

    public Vampiro crearVampiro(String nombre) {
        return new Vampiro(nombre, this.modeloVampiro);
    }

    public Licantropo crearLicantropo(String nombre) {
        return new Licantropo(nombre, this.modeloLicantropo);
    }

    public Cazador crearCazador(String nombre) {
        return new Cazador(nombre, this.modeloCazador);
    }

    public void crearModeloVampiro(Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, HabilidadEspecial habilidad, List<Modificador> modificadores) {
        this.modeloVampiro = new Vampiro(habilidad, armas, armaduras, esbirros, 5, 3, modificadores, "Los vampiros son criaturas que utilizan la sangre que roban de sus víctimas como recurso para activar algunas de sus habilidades.");
    }

    public void crearModeloLicantropo(Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, HabilidadEspecial habilidad, List<Modificador> modificadores) {
        this.modeloLicantropo = new Licantropo(habilidad, armas, armaduras, esbirros, 4, 4, modificadores, "Los licántropos son criaturas que pueden cambiar de forma humana a una forma de Bestia que aparenta ser la de un gigantesco lobo bípedo.");
    }

    public void crearModeloCazador(Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, HabilidadEspecial habilidad, List<Modificador> modificadores) {
        this.modeloCazador = new Cazador(habilidad, armas, armaduras, esbirros, 3, 3, modificadores, "Los cazadores son humanos con una voluntad extraordinaria que les dota de habilidades sobrenaturales.");
    }
}
