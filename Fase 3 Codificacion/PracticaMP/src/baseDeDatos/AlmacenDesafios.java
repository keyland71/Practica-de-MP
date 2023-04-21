/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Desafio;
import clasesDeJuego.Jugador;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Ángel Marqués
 */
public class AlmacenDesafios {
    private List<Desafio> desafios;
    
    public List<Desafio> obtenerDesafiosCompletados(Jugador j){
        return null;
    }

    public void aniadirDesafio(Desafio des) {
        desafios.add(des);
        this.guardar();
    }
    public void guardar() {
        /*
    }
        try {
            String fic = "./archivos/AlmacenDesafios.AlmacenDesafios";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(this);
            salida.close();
        } catch (Exception e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }*/
    }
}
