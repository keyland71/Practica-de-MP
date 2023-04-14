/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;


public class Modificador {

    private String nombre;
    private int valor;
    private boolean estaActivo;
    
    
    public int obtenerIncremento() {
        return this.valor;
    } 
    
    public void ponerActivo(boolean activo){
        this.estaActivo = true;
    }
    
}

