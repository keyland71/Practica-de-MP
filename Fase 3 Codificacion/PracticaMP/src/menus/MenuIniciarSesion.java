/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 *
 * Este menú contiene los mensajes referidos al inicio de sesión en la
 * aplicación. También contiene los mensajes de error convenientes por cada paso
 * de la ejecución y, además, un mensaje de error para cuando no hay usuarios en
 * la base de datos, indicando al usuario que debe registrarse primero.
 */
public class MenuIniciarSesion {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuIniciarSesion() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "Introduce tu nick: (escriba \"salir\" si desea salir al menú principal)";
        this.mensajes.add(mensaje);
        mensaje = "Introduce tu contrasenia:";
        this.mensajes.add(mensaje);
        mensaje = "No existe un usuario con el nick introducido, o bien el usuario está baneado. Pulse cualquier boton para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "Por favor, introduzca una contrasenia valida. Pulse cualquier boton para continuar.";
        this.mensajesError.add(mensaje);
        mensaje = "No existen usuarios. Por favor, registrese primero y luego vuelva aqui. Pulse cualquier boton para continuar.";
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
