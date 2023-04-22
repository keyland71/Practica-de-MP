/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;


public abstract class Modificador {

    private String nombre;
    private int valor;
    private boolean estaActivo;
    
    
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public void ponerActivo(boolean activo){
        this.estaActivo = true;
    }
    
    public int obtenerValor(){
        return this.valor;
    }
    
    public abstract int obtenerIncremento();
    
}

