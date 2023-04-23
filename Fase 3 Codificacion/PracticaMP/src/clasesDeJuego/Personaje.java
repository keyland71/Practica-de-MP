
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 *
 * @author Marcos
 */
public abstract class Personaje {

    private String nombre;
    private HabilidadEspecial habilidadEspecial;
    private Set<Arma> armasDisponibles;
    private Set<Arma> armasActivas = new HashSet<>();
    private Set<Armadura> armadurasDisponibles;
    private Armadura armaduraActiva;
    private Set<Esbirro> esbirros;
    private int oro = 100;
    private int vida;
    private int poder;
    private List<Modificador> modificadores;
    private String descripcion;
    private int puntosRecurso = 0;

    public Personaje(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc, int puntosRec) {
        this.nombre = "Modelo Personaje";
        this.habilidadEspecial = hab;
        this.armasDisponibles = armas;
        this.armadurasDisponibles = armaduras;
        this.esbirros = esbirros;
        this.vida = vida;
        this.poder = poder;
        this.modificadores = mods;
        this.descripcion = desc;
        this.puntosRecurso = puntosRec;
    }

    public Personaje(String nombre, Personaje personajeModelo) {
        this.nombre = nombre;
        this.habilidadEspecial = personajeModelo.obtenerHabilidadEspecial();
        this.armasDisponibles = new HashSet<>();
        for (Arma arma : personajeModelo.obtenerArmasDisponibles()) {
            this.armasDisponibles.add(arma);
        }
        this.armadurasDisponibles = new HashSet<>();
        for (Armadura armadura : personajeModelo.obtenerArmadurasDisponibles()) {
            this.armadurasDisponibles.add(armadura);
        }
        this.esbirros = new HashSet<>();
        for (Esbirro esbirro : personajeModelo.obtenerEsbirros()) {
            this.esbirros.add(esbirro);
        }
        this.vida = personajeModelo.obtenerVida();
        this.poder = personajeModelo.obtenerPoder();
        this.modificadores = new ArrayList<>();
        for (Modificador mod : personajeModelo.obtenerModificadores()) {
            this.modificadores.add(mod);
        }
        this.descripcion = personajeModelo.obtenerDescripcion();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public String obtenerDescripcion() {
        return this.descripcion;
    }

    public List<Modificador> obtenerModificadores() {
        return this.modificadores;
    }
    public List<Modificador> obtenerFortalezas() {
        List<Modificador> fortalezas = new ArrayList<>();
        for (Modificador fortaleza:this.modificadores){
            if (fortaleza.obtenerTipo() == TipoModificador.fortaleza){
                fortalezas.add(fortaleza);
            }
        }
        return fortalezas;
    }
    public List<Modificador> obtenerDebilidades() {
        List<Modificador> debilidades = new ArrayList<>();
        for (Modificador debilidad:this.modificadores){
            if (debilidad.obtenerTipo() == TipoModificador.debilidad){
                debilidades.add(debilidad);
            }
        }
        return debilidades;
    }
    
    private void buscarYAniadirModificador(List<Modificador> listaMods, String[] nombres) {
        for (String nombreMod : nombres) {
            boolean encontrado = false;
            int pos = 0;
            while (!encontrado) {
                encontrado = this.modificadores.get(pos).obtenerNombre().equals(nombreMod);
                if (!encontrado) {
                    pos += 1;
                }
            }
            if (encontrado) {
                listaMods.add(this.modificadores.get(pos));
            }
        }
    }

    public int obtenerVida() {
        return this.vida;
    }

    public int obtenerPoder() {
        return this.poder;
    }

    public Set<Esbirro> obtenerEsbirros() {
        return this.esbirros;
    }

    public Set<Arma> obtenerArmasDisponibles() {
        return this.armasDisponibles;
    }

    public Set<Armadura> obtenerArmadurasDisponibles() {
        return this.armadurasDisponibles;
    }

    public HabilidadEspecial obtenerHabilidadEspecial() {
        return this.habilidadEspecial;
    }

    public int obtenerRecurso() {
        return this.puntosRecurso;
    }
    
    public int obtenerAtaqueArmadura() {
        return this.armaduraActiva.obtenerAtaque();
    }
    
    public int obtenerDefensaArmadura() {
        return this.armaduraActiva.obtenerDefensa();
    }
    
    public int obtenerAtaqueArmas() {
        int ataqueTotal = 0;
        for (Arma arma : this.armasActivas) {
            ataqueTotal += arma.obtenerAtaque();
        }
        return ataqueTotal;
    }
    
    public int obtenerDefensaArmas() {
        int defensaTotal = 0;
        for (Arma arma : this.armasActivas) {
            defensaTotal = arma.obtenerDefensa();
        }
        return defensaTotal;
    }
    
    public void ponerPuntosRecurso(int recurso) {
        this.puntosRecurso = recurso;
    }

    public void ponerArmasActivas(Set<Arma> armas) {
        this.armasActivas = armas;
    }

    public void ponerArmaduraActiva(Armadura armadura) {
        this.armaduraActiva = armadura;
    }

    public void sumarOro(int oro) {
        this.oro += oro;
    }
    
    public void sumarRecurso(int recurso) {
        if ((this.puntosRecurso + recurso) <= 0) {
            this.puntosRecurso += recurso;
        } else {
            this.puntosRecurso = 0;
        }
        
    }

    public int calcularPotencialAtaque(int promedioModificadores) {
        int potencialAtaque = this.obtenerPoder() + this.obtenerAtaqueArmas() + this.obtenerAtaqueArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialAtaque += this.obtenerHabilidadEspecial().obtenerAtaque();
        }
        return potencialAtaque;
    }

    public int calcularPotencialDefensa(int promedioModificadores) {
        int potencialDefensa = this.obtenerDefensaArmas() + this.obtenerDefensaArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialDefensa += this.obtenerHabilidadEspecial().obtenerDefensa();
        }
        return potencialDefensa;
    }

    public int calcularVida() {
        int vidaTotal = this.vida;
        for (Esbirro esbirro : this.esbirros) {
            vidaTotal += esbirro.obtenerVida();
        }
        return vidaTotal;
    }

    public boolean puedeUsarHabilidad() {
        return this.puntosRecurso >= this.habilidadEspecial.obtenerCoste();
    }
    
    public void usarHabilidad() {
        //Por defecto no hace nada
    }

    public abstract void modificarRecurso();

    public void recibirDanio() {
        //Por defecto no ocurre nada
    }

    public void reestablecerPersonaje() {
        this.puntosRecurso = 0;
    }
    
    public int obtenerOro(){
        return this.oro;
    }

}
