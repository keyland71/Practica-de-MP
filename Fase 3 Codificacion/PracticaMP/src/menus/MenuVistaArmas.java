/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Arma;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuVistaArmas {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuVistaArmas() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "¿Seguro que quieres cambiar tu arma activa a las armas seleccionadas?";
        this.mensajes.add(mensaje);

        mensaje = "El valor introducido no corresponde a un arma. Introduce un numero que corresponda a un arma, o salir para cancelar la operacion";
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

    public String mostrarArmas(List<Arma> armas) {
        System.out.println("Armas Disponibles:");
        for (int i = 0; i < armas.size(); i++) {
            System.out.println("    Arma " + Integer.toString(i + 1) + ":\n" + armas.get(i).toString());
        }
        System.out.println("Introduce el numero del arma que te quieras equipar, o 'salir' si no quieres cambiar tu arma");

        return this.lector.nextLine();
    }
}
