/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos
 */

package clasesDeJuego;

import java.io.Serializable;


public class Modificador implements Serializable{

    private String nombre;
    private int valor;
    private TipoModificador tipo;
    
    public Modificador(String nombre, int valor, TipoModificador tipo){
        this.nombre = nombre;
        this.valor = obtenerIncremento(valor, tipo);
        this.tipo = tipo;
    }
    
    public int obtenerIncremento(int valor, TipoModificador tipo){
        if(tipo.equals(TipoModificador.Fortaleza)){
            return valor;
        }
        else if(tipo.equals(TipoModificador.Debilidad)){
            return valor * (-1);
        }
        else{
            return 0;
        }
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }

    public TipoModificador obtenerTipo() {
        return this.tipo;
    }
    
}

