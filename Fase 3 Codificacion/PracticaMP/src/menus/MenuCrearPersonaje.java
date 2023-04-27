/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCrearPersonaje {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuCrearPersonaje() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        this.lector = new Scanner(System.in);

        String mensaje = "Introduce el nombre del personaje: ";
        this.mensajes.add(mensaje);
        mensaje = "Introduce el tipo de personaje (vampiro, licantropo, cazador): ";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres crear ese personaje?";
        this.mensajes.add(mensaje);

        mensaje = "Has introducido un nombre invalido. El nombre de los personajes debe ser único. Pulse cualquier boton para continuar";
        this.mensajesError.add(mensaje);
        mensaje = "Has introducido un tipo invalido. Pulse cualquier boton para continuar";
        this.mensajesError.add(mensaje);
        mensaje = "Has introducido un valor invalido. Debes escribir si o no. Pulse cualquier boton para continuar";
        this.mensajesError.add(mensaje);
    }

    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

}
