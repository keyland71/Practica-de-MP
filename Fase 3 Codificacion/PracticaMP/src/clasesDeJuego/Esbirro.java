/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 * @author marcos
 * @author lucia
 */
public abstract class Esbirro {

    private String nombre;
    private int vida;
    
    public Esbirro(String nom, int v){
        this.nombre = nom;
        this.vida = v;
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }
    
    public int obtenerVida() {
        return this.vida;
    }
    
    public boolean tieneHumanos() {
        return false;
    }

}
