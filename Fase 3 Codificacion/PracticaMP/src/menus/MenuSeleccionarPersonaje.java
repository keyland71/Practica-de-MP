/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Personaje;
import controladores.ControladorSeleccionarPersonaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués
 */
public class MenuSeleccionarPersonaje {

    private List<Personaje> personajes;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuSeleccionarPersonaje() {
        this.personajes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "Seleccione un personaje que editar (con su posicion), o una de las opciones del final:";
        this.mensajes.add(mensaje);
        mensaje = "No hay personajes que editar";
        this.mensajes.add(mensaje);
        mensaje = "   (s)siguiente página\n   (a)anterior página\n   (salir) para volver al menú Admin";
        this.mensajes.add(mensaje);

        mensaje = "El valor introducido no es válido. Por favor introduzca un valor válido. Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor introduzca un valor válido (si/no). Pulse intro para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "No hay más datos que mostrar. Pulse intro para continuar";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarPagina(int n) {
        System.out.println(this.mensajes.get(0));
        int tamPag = ControladorSeleccionarPersonaje.tamPag;
        for (int i = 0; i <= tamPag - 1; i++) {
            if (i + n * tamPag >= this.personajes.size()) {
                break;
            } else {
                System.out.println(Integer.toString(i + 1) + ". " + this.personajes.get(i + n * tamPag).obtenerNombre());
            }
        }
        return mostrarMensaje(2);
    }

    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

    public void ponerPersonajes(List<Personaje> pjs) {
        this.personajes.clear();
        this.personajes.addAll(pjs);
    }

}
