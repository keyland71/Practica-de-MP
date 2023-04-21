/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ángel Marqués
 */
public class AlmacenDesafios {
    private List<Desafio> desafios;
    
   
    
    
    public AlmacenDesafios (){
        this.cargarDesafios();
    }
    
    
    public List<Desafio> obtenerDesafiosCompletados(){
        List<Desafio> desafiosCompletados = new ArrayList <>();
         for (int i = 0; i<= this.desafios.size();i++) {
            if (this.desafios.get(i).obtenerEstado() == EstadoDesafio.completado ) {
              desafiosCompletados.add(desafios.get(i));
            } 
         }  
      return desafiosCompletados; 
    }
    
    
    
     public List<Desafio> obtenerDesafiosAvalidar(){
         List<Desafio> desafiosAvalidar = new ArrayList <>();
         for (int i = 0; i<= this.desafios.size();i++) {
            if (this.desafios.get(i).obtenerEstado() == EstadoDesafio.pendienteValidar ) {
              desafiosAvalidar.add(desafios.get(i));
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
     
     
   
      public List<Desafio> obtenerDesafiosPendientes(){
         List<Desafio> desafiosPendientes = new ArrayList<>();
         for (int i = 0; i<= this.desafios.size();i++) {
            if (this.desafios.get(i).obtenerEstado() == EstadoDesafio.pendienteMostrar) {
              desafiosPendientes.add(desafios.get(i));
            } 
         }  
      return desafiosPendientes; 
    }
      
   
   

    public void aniadirDesafio(Desafio des) {
        desafios.add(des);
        this.guardarDesafio();
    }
    
    
  
    
     private void cargarDesafios() {
        AlmacenDesafios almacenLeido = null;
        try {
            String fic = "./archivos/AlmacenDesafio.AlmacenDesafio";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            almacenLeido = (AlmacenDesafios) entrada.readObject();
            this.desafios.addAll(almacenLeido.obtenerDesafiosCompletados());
            this.desafios.addAll(almacenLeido.obtenerDesafiosAvalidar()); //se añade addAll para no sobreescribir this.desafio. Se va añadiendo a la lista desafio según se obtengan
            this.desafios.addAll(almacenLeido.obtenerDesafiosPendientes());
            entrada.close();
        } catch (Exception e) {
            System.out.println("No se ha encontrado el almacén, así que se ha creado uno nuevo");
            System.out.println(e);
            this.desafios = new ArrayList<>();
        }
    }
     
     
       public void guardarDesafio () {
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
