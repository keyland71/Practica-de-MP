/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Arma;
import clasesDeJuego.Armadura;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuCambiarEquipoActivo {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuCambiarEquipoActivo() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "El valor introducido no corresponde a ninguna opcion. Introduce 1 para cambiar tus armas, o 2 para cambiar tu armadura";
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

    public String mostrarEquipoActivo(Collection<Arma> armas, Armadura armadura) {

        System.out.println("Armas Equipadas:");
        int i = 1;
        for (Arma a : armas) {
            System.out.println("    Arma " + Integer.toString(i) + ":\n" + a.toString());
            i += 1;
        }
        System.out.println("Armadura Equipada:");
        System.out.println(armadura.toString());
        System.out.println("¿Quieres cambiar tus armas(1) o tu armadura(2)? Si estás satisfecho con los cambios que has hecho, puedes escribir 'salir' para guardar los cambios");
        return this.lector.nextLine();
    }

}
