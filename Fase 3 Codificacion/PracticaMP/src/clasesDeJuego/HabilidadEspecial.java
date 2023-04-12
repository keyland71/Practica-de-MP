/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author lucia
 */
public abstract class HabilidadEspecial {
    private String nombre;
    private int ataque;
    private int defensa;
    private int coste;
    
    
  public int obtenerAtaque (){
      return ataque;
  }
  
  public int obtenerDefensa (){
      return defensa;
  }
  
  public int obtenerCoste(){
      return coste;
  }
    
}
