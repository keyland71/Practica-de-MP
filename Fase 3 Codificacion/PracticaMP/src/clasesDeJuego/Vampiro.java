/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;


/**
 *
 * @author lucia
 */
public class Vampiro extends Personaje implements Cloneable {
    private int edad;
    
    public Vampiro () {
        
    }
    
    @Override
    public boolean puedeUsarHabilidad(){
        if (this.obtenerRecurso() >= this.obtenerHabilidadEspecial().obtenerCoste()){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public void modificarRecurso (int recurso){ 
        //sangre que le quita a su oponente. Pone que como máximo tiene que ser 10
        if ((this.obtenerRecurso())<=10) { //pone que tiene que ser como máximo 10.
            ponerRecurso (recurso);
        }
    }
    
}

