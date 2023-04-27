/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sergio de Oro
 * @author Marcos Jimenez
 * @author Lucía Dominguez
 * @author Ángel Marqués
 */
public class MenuCrearDesafio {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuCrearDesafio() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "¿Cuanto Oro quieres apostar?";
        this.mensajes.add(mensaje);
        mensaje = "¿A quien quieres desafiar (introduce su nick)?";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres crear el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Si te equivocas, en cualquier momento puedes escribir 'salir', que te devolvera al menu anterior y cancelara el desafio";
        this.mensajes.add(mensaje);
        mensaje = "El desafio ha sido creado. Ahora queda a la espera de que lo valide un administrador. Una vez validado, se le mostrara a tu oponente, y cuando responda se te notificara";
        this.mensajes.add(mensaje);

        mensaje = "No puedes apostar esa cantidad";
        this.mensajesError.add(mensaje);
        mensaje = "No existe un usuario con ese nick, el usuario no tiene un personaje activo, o el nick introducido es el tuyo";
        this.mensajesError.add(mensaje);
        mensaje = "No has introducido un valor valido. Vuelve a intentarlo!";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
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
