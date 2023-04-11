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
 * @author burakku
 */
public class MenuRegistro {
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuRegistro() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        String mensaje = "Introduce tu Nick único"; //alternativamente, se pueden usar tres variables. Creas los tres mensajes, luego los insertas. Eso sería más legible, creo yo
        this.mensajes.add(mensaje);
        mensaje = "Introduce tu nombre de usuario";
        this.mensajes.add(mensaje);
        mensaje = "Introduce tu contraseña";
        this.mensajes.add(mensaje);
        mensaje = "¿Qué tipo de usuario quieres crear? (admin/jugador)";
        this.mensajes.add(mensaje);
        mensaje = "¿Quieres crear la cuenta? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Por favor, introduzca un Nick único. Pulse cualquier botón para continuar";
        this.mensajesError.add(mensaje);
        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(int pos) {
        String mensaje = this.mensajes.get(pos);
        System.out.println(mensaje);
        String opcion = this.lector.nextLine();
        return opcion;
    }

    public void mostrarMensajeError(int modo) {
        String mensaje = this.mensajesError.get(modo);
        System.out.println(mensaje);
        (new Scanner(System.in)).nextLine();
    }
}
