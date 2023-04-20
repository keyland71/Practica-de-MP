
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */

public abstract class Personaje {
    private String nombre;
    private HabilidadEspecial habilidadEspecial;
    private Set<Arma> armasDisponibles;
    private Set<Arma> armasActivas;
    private Set<Armadura> armadurasDisponibles;
    private Armadura armaduraActiva;
    private Set<Esbirro> esbirros;
    private int oro;
    private int vida;
    private int poder;
    private List<Debilidad> debilidades;
    private List<Fortaleza> fortalezas;
    private String descripcion;
    private int puntosRecurso;
    
    
    public Personaje() {
       //se ha quitado porque no deja contruir bn los constructores de los modelos de las fábricas HAY QUE REVISARLO
    }
    
    public void ponerArmasActivas(Set<Arma> armas){
        this.armasActivas = armas;
    }
    
    public void ponerArmaduraActiva(Armadura armadura){
        this.armaduraActiva = armadura;
    }   
    
    public int calcularPotencialAtaque(){
       return 0; } //Como el personaje que se le pasa como parámetro es el personaje mismo, no se pone. Se tendrá que llamar a si mismo (this)
    
    public int calcularPotencialDefensa(){
     return 0; }
    
    public int calcularVida(){ //¿Por que no mejor obtenerVida()? No se calcula nada
        return this.vida;
    }
    
    public HabilidadEspecial obtenerHabilidadEspecial(){
        return this.habilidadEspecial;
    }
    
    public abstract boolean puedeUsarHabilidad();
    
    public void modificarRecurso(int cantidad){
        this.puntosRecurso = cantidad;
    }
    
    public void ponerRecurso (int recurso){
        this.puntosRecurso = recurso;
    }

    public int obtenerRecurso (){
        return this.puntosRecurso;
    }
    
    public void recibirDanio(int danio){
        this.vida -= danio;
    }
    
    public void activarFortalezas (List<Fortaleza> listaFortalezas){
        this.fortalezas = listaFortalezas;
    }

    public void activarDebilidades (List<Debilidad> listaDebilidades){
        this.debilidades = listaDebilidades;
    }
    
    
    /*public void reestablecerPersonaje(){
        this.armaduraActiva = null;
        this.armasActivas.clear();
        this.vida = 
    }
    ¿Se reestablecen todos a null o solo algunos? ¿Cuáles?
    
    */
    
    public void sumarOro(int oro){
        this.oro += oro;
    }
    
}
