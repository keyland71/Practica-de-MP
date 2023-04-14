/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;


public class Fortaleza extends Modificador {

    public int obtenerIncremento(){
        return 0;//this.valor; //obtenerIncremento no puede ser abstracto, ya que al serlo no se permite acceder a la propiedad privada valor de la clase Modificador (REVISAR)
    }

}