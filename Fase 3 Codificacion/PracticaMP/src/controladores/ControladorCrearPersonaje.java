/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenPersonajes;
import clasesDeJuego.Cazador;
import clasesDeJuego.Jugador;
import clasesDeJuego.Licantropo;
import clasesDeJuego.Personaje;
import clasesDeJuego.Vampiro;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menus.MenuCrearPersonaje;
import practicamp.Juego;
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
        this.tiposDisponibles = new HashSet(Arrays.asList("vampiro", "licantropo", "cazador", "VAMPIRO", "LICANTROPO", "CAZADOR", "Vampiro", "Licantropo", "Cazador"));
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
                this.menuCrearPersonaje.mostrarMensajeError(this.modo);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        switch (this.modo) {
            case 0 -> {
                return this.nombreUnico(opcion);
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
        AlmacenPersonajes almacen = Juego.estado.obtenerAlmacenPersonajes();
        return !almacen.existePersonaje(nombre);
    }

    private boolean procesarEntrada(String entrada) {
        if (entrada.equalsIgnoreCase("salir")) {
            return true;
        }
        switch (modo) {
            case 0 -> {
                this.nombreElegido = entrada;
            }
            case 1 -> {
                this.tipoElegido = entrada;
            }
            case 2 -> {
                if (entrada.equalsIgnoreCase("si")) {
                    Personaje p;
                    AlmacenPersonajes almacen = Juego.estado.obtenerAlmacenPersonajes();

                    FabricaPersonajes f = Juego.estado.obtenerFabricaPersonajes();
                    if (this.tipoElegido.equalsIgnoreCase("vampiro")) {
                        p = f.crearVampiro(this.nombreElegido);
                        almacen.aniadirVampiro((Vampiro) p);

                    } else if (this.tipoElegido.equalsIgnoreCase("licantropo")) {
                        p = f.crearLicantropo(this.nombreElegido);
                        almacen.aniadirLicantropo((Licantropo) p);

                    } else {
                        p = f.crearCazador(this.nombreElegido);
                        almacen.aniadirCazador((Cazador) p);
                    }
                    Jugador j = (Jugador) Juego.estado.obtenerUsuarioActivo();
                    j.ponerPersonaje(p);
                    Juego.estado.guardar();
                }
                return true;
            }

        }
        return false;
    }
}
