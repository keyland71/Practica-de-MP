/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;


public class Arma extends Equipo {

    private Variante tipo;
    
    public Arma(String nombre, int modAtaque, int modDefensa, Variante tipoArma){
        super(nombre, modAtaque, modDefensa);
        this.tipo = tipoArma;
        
    }
    
    public Variante obtenerVariante(){
        return this.tipo;
    }
    
    @Override
    public String toString(){
        String result = "        Nombre: " + this.obtenerNombre() + "\n        Ataque: " + this.obtenerAtaque() + "\n        Defensa: " + this.obtenerDefensa() + "\n        Tipo: " + (this.tipo == Variante.unaMano ? "Una mano":"Dos manos");
        return result;
    }

}