/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;



/**
 *
 * @author lucia
 */
public class Licantropo extends Personaje implements Cloneable {
    
    private final int rabiaMinima = 1;
    
    public Licantropo () {
        
    }
    
    @Override
    public boolean puedeUsarHabilidad(){
        if (this.obtenerRecurso() >= this.rabiaMinima){ 
            return true;
        }
        else{
            return false;
        }
    }
}
