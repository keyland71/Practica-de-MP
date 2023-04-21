/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas;

import clasesDeJuego.Personaje;

/**
 *
 * @author lucia
 */
class ModeloVampiro extends Personaje {
   
  
 public ModeloVampiro (){
    }
 
@Override 
  public int calcularPotencialAtaque(){
      return 0;
  }
  
  
 @Override
   public int calcularPotencialDefensa(){
     return 0; }

   //esta me decia NetBeans que la tengo que añadir, la ha añadido netbeans. Daba problemas, en rojo
    @Override
    public boolean puedeUsarHabilidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  }
    
    

