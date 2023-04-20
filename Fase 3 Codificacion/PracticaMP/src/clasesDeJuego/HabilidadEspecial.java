/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author lucia
 */
public class HabilidadEspecial {
    private String nombre;
    private int ataque;
    private int defensa;
    private int coste;
    public TipoHabilidad tipo; //Se tiene en cuenta que, en el caso de que la habilidad especial sea de tipo Talento, el coste tiene que ser 0
    
    
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