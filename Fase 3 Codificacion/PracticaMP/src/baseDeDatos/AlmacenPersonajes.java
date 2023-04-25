/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Cazador;
import clasesDeJuego.Licantropo;
import clasesDeJuego.Personaje;
import clasesDeJuego.Vampiro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ángel Marqués
 */
public class AlmacenPersonajes implements Serializable{
    
    private List<Vampiro> vampiros;
    private List<Licantropo> licantropos;
    private List<Cazador> cazadores;
    
    public AlmacenPersonajes(){
        this.vampiros = new ArrayList<>();
        this.licantropos = new ArrayList<>();
        this.cazadores = new ArrayList<>();
    }
    
    public List<Personaje> obtenerPersonajes(){
        List<Personaje> result = new ArrayList<>();
        result.addAll(vampiros);
        result.addAll(licantropos);
        result.addAll(cazadores);
        return result;
    }
    
    public void borrarPersonaje(Personaje p){
        String nombre = p.obtenerNombre();
        int i;
        
        //buscamos en los vampiros
        i = 0;
        for (Vampiro v:this.vampiros){
            if (v.obtenerNombre().equalsIgnoreCase(nombre)){
                this.vampiros.remove(i); //se puede hacer con el objeto, pero imagino que deberá implementar equals
                return;
            }
            i++;
        }
        //buscamos en los licantropos
        i=0;
        for (Licantropo l:this.licantropos){
            if (l.obtenerNombre().equalsIgnoreCase(nombre)){
                this.licantropos.remove(i);
                return;
            }
            i++;
        }
        //buscamos en los cazadores
        i=0;
        for (Cazador c:this.cazadores){
            if (c.obtenerNombre().equalsIgnoreCase(nombre)){
                this.cazadores.remove(i);
                return;
            }
            i++;
        }
    }
    
    public boolean existePersonaje(String nombre){
        //buscamos en los vampiros
        for (Vampiro v:this.vampiros){
            if (v.obtenerNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        //buscamos en los licantropos
        for (Licantropo l:this.licantropos){
            if (l.obtenerNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        //buscamos en los cazadores
        for (Cazador c:this.cazadores){
            if (c.obtenerNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        //si no está en ninguno, no existe
        return false;
    }
    
    public void aniadirVampiro(Vampiro v){
        this.vampiros.add(v);
    }
    public void aniadirLicantropo(Licantropo l){
        this.licantropos.add(l);
    }
    public void aniadirCazador(Cazador c){
        this.cazadores.add(c);
    }
    
    
    
}
