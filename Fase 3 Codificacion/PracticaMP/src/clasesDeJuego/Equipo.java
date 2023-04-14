/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;


public class Equipo {
    
    private String nombre;
    
    private int modificadorAtaque;
    
    private int modificadorDefensa;
    
    
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