/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenPersonajes;
import baseDeDatos.Estado;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menus.MenuCrearPersonaje;
import sistemas.FabricaPersonajes;

/**
 *
 * @author Marcos, Lucía
 */
public class ControladorCrearPersonaje {

    private int modo;
    private MenuCrearPersonaje menuCrearPersonaje;
    private Set<String> tiposDisponibles;
    private String tipoElegido;
    private String nombreElegido;

    public ControladorCrearPersonaje() {
        this.menuCrearPersonaje = new MenuCrearPersonaje();
        this.tiposDisponibles = new HashSet(Arrays.asList("vampiro", "licantropo", "cazador"));
        this.modo = 0;
    }

    public void iniciarControlador() {
        boolean salir = false;
        this.modo = 0;
        do {
            String opcion = this.menuCrearPersonaje.mostrarMensaje(this.modo);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
                this.modo++;
            } else {
                this.menuCrearPersonaje.mostrarMensajeError(this.modo); //si el nombre no tiene que ser unico, se usaría this.modo-1
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        switch (this.modo) {
            case 0 -> { 
                return this.nombreUnico(opcion);    //si vale cualquier nombre es tan fácil como poner aqui return true, y borrar la funcion nombreUnico
                                                    //también habría cambios en el MenuCrearPersonaje
            }
            case 1 -> {
                return this.tiposDisponibles.contains(opcion);
            }
            case 2 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return false;
    }

    private boolean nombreUnico(String nombre) {
        AlmacenPersonajes almacen = Estado.obtenerAlmacenPersonajes();
        return !almacen.existePersonaje(nombre);
    }

    private boolean procesarEntrada(String entrada) {
        if (entrada.equalsIgnoreCase("salir")){
            return true;
        }
        String opcion;
        switch (modo) {
            case 0 -> { //guardar el nombre
                this.nombreElegido = entrada;
            }
            case 1 -> { //guardar el tipo
                this.tipoElegido = entrada;
            }
            case 2 -> { //crear el desafío y guardarlo
                if (entrada.equalsIgnoreCase("si")){
                    FabricaPersonajes f = new FabricaPersonajes();
                    //llamar a la fábrica para que cree el personaje
                    //si la fábrica tiene métodos distintos para cada tipo, usar un case para llamar al pertinente
                    //si la fábrica guarda el personaje, that's it.
                    //si la fábrica no guarda el personaje, lo hay que guardar
                }
            }

        }
        return false;
    }
}
