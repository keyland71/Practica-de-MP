/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Armadura;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués
 */
public class MenuVistaArmaduras {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuVistaArmaduras() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "¿Seguro que quieres cambiar tu armadura activa a la seleccionada?";
        this.mensajes.add(mensaje);

        mensaje = "El valor introducido no corresponde a una armadura. Introduce un numero que corresponda a una armadura, o salir para cancelar la operación";
        this.mensajesError.add(mensaje);
        mensaje = "Debes introducir si o no";
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

    public String mostrarArmaduras(List<Armadura> armaduras) {
        System.out.println("Armaduras Disponibles:");
        for (int i = 0; i < armaduras.size(); i++) {
            System.out.println("    Armadura " + Integer.toString(i + 1) + ":\n" + armaduras.get(i).toString());
        }
        System.out.println("Introduce el número de la armadura que te quieras equipar, o 'salir' si no quieres cambiar tu armadura");
        return this.lector.nextLine();
    }
}
