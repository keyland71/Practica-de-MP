/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués García
 */
public class MenuRegistro {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuRegistro() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        String mensaje = "Introduce tu nick unico: (escriba \"salir\" en cualquier momento si desea salir al menú principal)";
        this.mensajes.add(mensaje);
        mensaje = "Introduce tu nombre de usuario:";
        this.mensajes.add(mensaje);
        mensaje = "Introduce tu contrasenia: (la contrasenia debe tener una longitud entre 8 y 12 caracteres)";
        this.mensajes.add(mensaje);
        mensaje = "¿Qué tipo de usuario quieres crear? (admin/jugador)";
        this.mensajes.add(mensaje);
        mensaje = "Ese nick ya esta en uso. Por favor, introduzca otro. Pulse cualquier boton para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor, introduzca un nombre de usuario no vacio. Pulse cualquier boton para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor, introduzca una contrasenia con una longitud entre 8 y 12 caracteres. Pulse cualquier boton para continuar.";
        this.mensajesError.add(mensaje);
        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(int pos) {
        String mensaje = this.mensajes.get(pos);
        System.out.println(mensaje);
        String opcion = this.lector.nextLine();
        return opcion;
    }

    public void mostrarMensajeError(int pos) {
        String mensaje = this.mensajesError.get(pos);
        System.out.println(mensaje);
        this.lector.nextLine();
    }
}
