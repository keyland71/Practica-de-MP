/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasesDeJuego;


public class Debilidad extends Modificador {

    @Override
    public int obtenerIncremento(){
        return (this.obtenerIncremento() * (-1));
    }

}