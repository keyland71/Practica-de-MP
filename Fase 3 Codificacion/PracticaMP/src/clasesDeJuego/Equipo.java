/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;

import java.io.Serializable;


public class Equipo implements Serializable{
    
    private String nombre;
    
    private int modificadorAtaque;
    
    private int modificadorDefensa;
    
    public Equipo(String nombre, int modAtaque, int modDefensa){
        this.nombre = nombre;
        this.modificadorAtaque = modAtaque;
        this.modificadorDefensa = modDefensa;
    }
    
    
    public int obtenerAtaque(){
        return this.modificadorAtaque;
    }
    
    public int obtenerDefensa(){
        return this.modificadorDefensa;
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }
    

}