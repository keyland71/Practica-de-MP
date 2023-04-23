/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;

/**
 * @author marcos
 * @author lucia
 */
public abstract class Esbirro implements Serializable{

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
    
    public boolean tieneSubordinados(){
    public boolean tieneHumanos() {
        return false;
    }

}
