/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import clasesDeJuego.Jugador;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import practicamp.Juego;

/**
 *
 * @author Marcos Jiménez
 * @author Lucia Dominguez
 * @author Ángel Marqués
 */
public class AlmacenDesafios implements Serializable{

    private List<Desafio> desafios;

    public AlmacenDesafios() {
        this.desafios = new ArrayList<>();
    }

    public void aniadirDesafio(Desafio des) {
        desafios.add(des);
        Juego.estado.guardar();
    }
    public void borrarDesafio(Desafio des) {
        desafios.remove(des); //esto podría no funcionar si Desafío no implementa .equals En ese caso, habría que buscar secuencialmente uno que coincida
        Juego.estado.guardar();
    }
    public List<Desafio> obtenerDesafios() {
        return this.desafios;
    }

    public List<Desafio> obtenerDesafiosCompletados(String nick) {
        Jugador j = (Jugador) Juego.estado.obtenerAlmacenUsuarios().obtenerUsuario(nick);
        
        List<Desafio> desafiosCompletados = new ArrayList<>();
        for (Desafio d:this.desafios){
            if (d.obtenerEstado() == EstadoDesafio.completado && (d.obtenerJugadorDesafiado().obtenerNick().equals(j.obtenerNick()) || d.obtenerJugadorDesafiante().obtenerNick().equals(j.obtenerNick()))){
                desafiosCompletados.add(d); //si el combate está completado y el j es uno de los dos jugadores, añade el combate
            }
        }
        return desafiosCompletados;
    }

    public List<Desafio> obtenerDesafiosAvalidar() {
        List<Desafio> desafiosAvalidar = new ArrayList<>();
        for (Desafio d:this.desafios){
            if (d.obtenerEstado() == EstadoDesafio.pendienteValidar) {
                desafiosAvalidar.add(d);
            }
        }
        return desafiosAvalidar;
    }

    /*
     public List<Desafio> obtenerDesafiosAvalidar(Jugador j){
         List<Desafio> desafiosAvalidar = new ArrayList <>();
         for (int i = 0; i<= this.desafios.size();i++) {
            if (this.desafios.get(i).obtenerEstado() == EstadoDesafio.pendienteValidar ) && (this.desafios.get(i).obteneruDesafiante()== (Jugador) Estado.obtenerUsuarioActivo()){
              desafiosAvalidar.add(desafios.get(i));
            } 
         }  
      return desafiosAvalidar; 
    }
     */
    public List<Desafio> obtenerDesafiosPendientesAceptar(String nick) {
        List<Desafio> desafiosPendientes = new ArrayList<>();
        for (Desafio d:this.desafios){
            if (d.obtenerEstado() == EstadoDesafio.validado && (d.obtenerJugadorDesafiado().obtenerNick().equals(nick) || d.obtenerJugadorDesafiante().obtenerNick().equals(nick))){
                desafiosPendientes.add(d); //si el combate está pendiente de aceptar y el j es uno de los dos jugadores, añade el combate
            }
        }
        return desafiosPendientes;
    }
    
    public List<Desafio> obtenerDesafiosNoMostrados(String nick) {
        List<Desafio> desafiosPendientes = new ArrayList<>();
        for (Desafio d:this.desafios){
            if ((d.obtenerEstado() == EstadoDesafio.aceptado || d.obtenerEstado() == EstadoDesafio.rechazado) && (d.obtenerJugadorDesafiado().obtenerNick().equals(nick) || d.obtenerJugadorDesafiante().obtenerNick().equals(nick))){
                desafiosPendientes.add(d); //si el combate está completado o rechazado y el j es uno de los dos jugadores, añade el combate
            }
        }
        return desafiosPendientes;
    }

 
    //inutil
    private void cargarDesafios() {
        AlmacenDesafios almacenLeido = null;
        try {
            String fic = "./archivos/AlmacenDesafio.AlmacenDesafio";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            almacenLeido = (AlmacenDesafios) entrada.readObject();
            this.desafios = almacenLeido.obtenerDesafios();
            entrada.close();
        } catch (Exception e) {
            System.out.println("No se ha encontrado el almacén, así que se ha creado uno nuevo");
            System.out.println(e);
            this.desafios = new ArrayList<>();
        }
    }

    //inutil
    public void guardarDesafios() {
        try {
            String fic = "./archivos/AlmacenDesafio.AlmacenDesafio";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(this);
            salida.close();
        } catch (Exception e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }
    }
}
