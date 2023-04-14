
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
    
    
    public Personaje(String nombre) {
        this.nombre = nombre;
    }
    
    public void ponerArmasActivas(Set<Arma> armas){
        this.armasActivas = armas;
    }
    
    public void ponerArmaduraActiva(Armadura armadura){
        this.armaduraActiva = armadura;
    }   
    
    public abstract int calcularPotencialAtaque(); //Como el personaje que se le pasa como parámetro es el personaje mismo, no se pone. Se tendrá que llamar a si mismo (this)
    
    public abstract int calcularPotencialDefensa();
    
    public int calcularVida(){ //¿Por que no mejor obtenerVida? No se calcula nada
        return this.vida;
    }
    
    //public boolean puedeUsarHabilidad(). ¿Qué hace? ¿Innecesario?
    
    public void modificarRecurso(int cantidad){
        this.puntosRecurso = cantidad;
    }
    
    public void recibirDanio(int danio){
        this.vida -= danio;
    }
    
    public void activarModificadores(List<String> modificadores){
        ArrayList <Fortaleza> fortalezas = new ArrayList <Fortaleza>();
        ArrayList <Debilidad> debilidades = new ArrayList <Debilidad>();
        
        for (int i=0; i<=modificadores.size();i++){
            if (modificadores.get(i).obtenerIncremento() > 0){
                fortalezas.add(i);
            }
            else{
                debilidades.add(i);
             }    
        }
        
        this.fortalezas = fortalezas;
        this.debilidades = debilidades;
    }
    
    public void reestablecerPersonaje(){
        //Se reestablecen los campos del personaje pero, ¿dónde están esos valores guardados para restaurarlos?
    }
    
    public void sumarOro(int oro){
        this.oro += oro;
    }
    
}