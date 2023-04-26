/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesDeJuego.Modificador;
import clasesDeJuego.Personaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Marqués
 */
public class MenuValidarDesafio {

    private List<String> jugadores;
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    private List<Modificador> fP1;
    private List<Modificador> dP1;
    private List<Modificador> fP2;
    private List<Modificador> dP2;

    public MenuValidarDesafio(Personaje p1, Personaje p2) {
        this.fP1 = p1.obtenerFortalezas();
        this.dP1 = p1.obtenerDebilidades();
        this.fP2 = p2.obtenerFortalezas();
        this.dP2 = p2.obtenerDebilidades();

        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();

        String mensaje = "Elige una fortaleza del personaje 1 que activar";
        this.mensajes.add(mensaje);
        mensaje = "Elige una debilidad del personaje 1 que activar";
        this.mensajes.add(mensaje);
        mensaje = "Elige una fortaleza del personaje 2 que activar";
        this.mensajes.add(mensaje);
        mensaje = "Elige una debilidad del personaje 2 que activar";
        this.mensajes.add(mensaje);
        mensaje = "¿Seguro que quieres validar el desafio? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Desafio validado. Pulsa intro para continuar";
        this.mensajes.add(mensaje);

        mensaje = "El numero introducido no corresponde con una debilidad/fortaleza";
        this.mensajesError.add(mensaje);
        mensaje = "Ha introducido un valor no válido. Los valores válidos son 'si' y 'no'";
        this.mensajesError.add(mensaje);
        mensaje = "Operación cancelada";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(int pos) {
        String mensaje = this.mensajes.get(pos);
        System.out.println(mensaje);

        List<Modificador> elementos;
        switch (pos) {
            case 0 ->
                elementos = this.fP1;
            case 1 ->
                elementos = this.dP1;
            case 2 ->
                elementos = this.fP2;
            case 3 ->
                elementos = this.dP2;
            default ->
                elementos = null;
        }
        if (elementos != null) {
            int i = 1;
            for (Modificador m : elementos) {
                System.out.println("    " + Integer.toString(i) + ". " + m.obtenerNombre());
                i++;
            }
        }

        String opcion = this.lector.nextLine();
        return opcion;
    }

    public void mostrarMensajeError(int pos) {
        String mensaje = this.mensajesError.get(pos == 4 ? 1 : 0);
        System.out.println(mensaje);
        this.lector.nextLine();
    }
}
