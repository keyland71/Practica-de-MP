
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 *
 * @author Marcos
 */
public abstract class Personaje implements Serializable{

    private String nombre;
    private HabilidadEspecial habilidadEspecial;
    private Set<Arma> armasDisponibles= new HashSet<>();;
    private List<Arma> armasActivas = new ArrayList<>();
    private Set<Armadura> armadurasDisponibles = new HashSet<>();
    private Armadura armaduraActiva;
    private Set<Esbirro> esbirros;
    private int oro = 100;
    private int vida;
    private int poder;
    private List<Modificador> modificadores;
    private String descripcion;
    private int puntosRecurso = 0;

    public Personaje(HabilidadEspecial hab, Collection<Arma> armas, Collection<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc, int puntosRec) {
        this.nombre = "Modelo Personaje";
        ponerHabilidadEspecial(hab);
        this.armasDisponibles.addAll(armas);
        this.armadurasDisponibles.addAll(armaduras);
        ponerEsbirros(esbirros);
        this.vida = vida;
        this.poder = poder;
        this.modificadores = mods;
        this.descripcion = desc;
        this.puntosRecurso = puntosRec;
        
        //para pruebas
        this.armasActivas.add((Arma)armas.toArray()[0]);
        this.armaduraActiva = ((Armadura)armaduras.toArray()[0]);
    }

    public Personaje(String nombre, Personaje personajeModelo) {
        this.nombre = nombre;
        this.habilidadEspecial = personajeModelo.obtenerHabilidadEspecial();
        for (Arma arma : personajeModelo.obtenerArmasDisponibles()) {
            this.armasDisponibles.add(arma);
        }
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
        
        //para pruebas
        this.armasActivas.add((Arma)this.armasDisponibles.toArray()[0]);
        this.armaduraActiva = ((Armadura)this.armadurasDisponibles.toArray()[0]);
    }
    
    public List<Arma> obtenerArmasActivas() {
        return this.armasActivas;
    }
    public Armadura obtenerArmaduraActiva() {
        return this.armaduraActiva;
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
            if (fortaleza.obtenerTipo() == TipoModificador.Fortaleza){
                fortalezas.add(fortaleza);
            }
        }
        return fortalezas;
    }
    public List<Modificador> obtenerDebilidades() {
        List<Modificador> debilidades = new ArrayList<>();
        for (Modificador debilidad:this.modificadores){
            if (debilidad.obtenerTipo() == TipoModificador.Debilidad){
                debilidades.add(debilidad);
            }
        }
        return debilidades;
    }
    
    private void activarModificadores(int[] fortDeb) {
        int indF = 0;
        int indD = 0;
        
        for (Modificador m:this.modificadores){
            if (indF==fortDeb[0] || indD==fortDeb[1]){
                this.modificadores.get(indF+indD).ponerEstaActivo(true);
            } else {
                this.modificadores.get(indF+indD).ponerEstaActivo(false);
            }
            if (m.obtenerTipo() == TipoModificador.Fortaleza) indF++;
            else indD++;
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
    
    public int obtenerOro(){
        return this.oro;
    }
    
    public void ponerPuntosRecurso(int recurso) {
        this.puntosRecurso = recurso;
    }

    public void ponerArmasActivas(Collection<Arma> armas) {
        this.armasActivas.clear();
        this.armasActivas.addAll(armas);
    }

    public void ponerArmaduraActiva(Armadura armadura) {
        this.armaduraActiva = armadura;
    }
    
     public void ponerEsbirros(Set<Esbirro> esbirros) {
        this.esbirros = esbirros;
     }
     
     public void ponerHabilidadEspecial(HabilidadEspecial hab) {
        this.habilidadEspecial = hab;
    }

    public int sumarOro(int i) { //devuelve la cantidad de oro que se le haya quitado/sumado al usuario
        if (this.oro + i >= 0){
            this.oro += i;
        } else {
            i = this.oro;
            this.oro = 0;
        }
        return (i > 0 ? i:-i); //para asegurar que devuelve un valor positivo
    }
    
    public void sumarRecurso(int recurso) {
        if ((this.puntosRecurso + recurso) <= 0) {
            this.puntosRecurso += recurso;
        } else {
            this.puntosRecurso = 0;
        }
        
    }

    private int calcularEfectoModificadores(){ //sería mucho más cómodo si guardaramos aparte los modificadores activos
        int result = 0;
        for (Modificador m:this.modificadores){
            if (m.obtenerEstaActivo()){
                result += m.obtenerValor();
            }
        }
        return result;
    }
    
    public int calcularPotencialAtaque() {
        int promedioModificadores = calcularEfectoModificadores();
        
        int potencialAtaque = this.obtenerPoder() + this.obtenerAtaqueArmas() + this.obtenerAtaqueArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialAtaque += this.obtenerHabilidadEspecial().obtenerAtaque();
            //no habría que poner aquí que gaste el recurso si debe?
        }
        return potencialAtaque;
    }

    public int calcularPotencialDefensa() {
        int promedioModificadores = calcularEfectoModificadores();
        
        int potencialDefensa = this.obtenerDefensaArmas() + this.obtenerDefensaArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialDefensa += this.obtenerHabilidadEspecial().obtenerDefensa();
            //no habría que poner aquí que gaste el recurso si debe?
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

}
