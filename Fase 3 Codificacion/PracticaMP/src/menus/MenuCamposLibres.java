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
 * @author Ángel Marqués
 */
public class MenuCamposLibres {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuCamposLibres() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "";
        this.mensajes.add(mensaje);

        mensaje = """
                  El valor introducido no es un valor v\u00e1lido para el campo que quiere modificar.
                   Tenga en cuenta que los campos vida y poder s\u00f3lo aceptan valores entre 1 y 5, y el nombre del personaje debe ser \u00fanico""";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(String campo) {
        System.out.println("Introduzca el nuevo valor para el campo '" + campo + "':");
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int modo) {
        System.out.println(this.mensajesError.get(modo));
        this.lector.nextLine();
    }
}
