/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenPersonajes;
import baseDeDatos.Estado;
import clasesDeJuego.Desafio;
import clasesDeJuego.Jugador;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menus.MenuCrearPersonaje;
import sistemas.FabricaPersonajes;

/**
 *
 * @author lucia
 */
public class ControladorCrearPersonajes {
       private int modo;
    private MenuCrearPersonaje menuCrearPersonajes;
    private Set <String> tipoPersonajes;
      private FabricaPersonajes fabricaPersonaje;

    public ControladorCrearPersonajes() {
        this.menuCrearPersonajes = new MenuCrearPersonaje();
        this.modo = 0;
        this.tipoPersonajes = new HashSet(Arrays.asList("vampiro", "licantropo", "cazador"));
    }

    public void iniciarControlador() {
        boolean salir = false;
        this.modo = 0;
        do {
            String opcion = this.menuCrearPersonajes.mostrarMensaje(this.modo);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
                this.modo++;
            } else {
                this.menuCrearPersonajes.mostrarMensajeError(this.modo);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")){
            return true;
        }
        switch (this.modo) {
            case 0 -> { //input válido si 
                return  this.nombreUnico(opcion)|| opcion.equalsIgnoreCase ("salir") ;
            }
            case 1 -> {
                return this.tipoPersonajes.contains(opcion) || opcion.equalsIgnoreCase ("salir");
            }
            case 2 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return false;
    }

    private boolean nombreUnico (String o) {
         
        AlmacenPersonajes almacen = Estado.obtenerAlmacenPersonajes();
        return !almacen.existePersonaje(o);
    }
    

   
    private boolean procesarEntrada (String entrada) {
    /* if (entrada.equalsIgnoreCase("salir")){
            return true;
        }
        String opcion;
        switch (modo) {
            case 0 -> { //guardar el oro apostado
                this.oro = Integer.parseInt(entrada);
            }
            case 1 -> { 
                
                this.oponente = (Jugador) Estado.obtenerAlmacenUsuarios().obtenerUsuario(entrada);
            }
            case 2 -> { //crear el desafío y guardarlo
                if (entrada.equalsIgnoreCase("si")){
                    Jugador jActivo = (Jugador) Estado.obtenerUsuarioActivo();
                    Desafio des = new Desafio(jActivo, this.oponente, this.oro);
                    Estado.obtenerAlmacenDesafios().aniadirDesafio(des);
                }
            }

        } //end switch 1*/
        return false;
    }
}
