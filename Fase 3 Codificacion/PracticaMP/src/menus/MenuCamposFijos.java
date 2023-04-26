/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;


import clasesDeJuego.Personaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Ángel Marqués
 */
public class MenuCamposFijos {
    
    private List<String> mensajes;
    private List<String> mensajesError;
    private Personaje personaje;
    private Scanner lector;

    public MenuCamposFijos(Personaje p) {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        this.personaje = p;
        
        String mensaje = "";
        this.mensajes.add(mensaje);
        
        mensaje = "El valor introducido no es un valor válido para el campo que quiere modificar. Procure introducir el numero de alguno de los elementos.";
        this.mensajesError.add(mensaje);

        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(String campo, String valores) {
        System.out.println("Estos son los valores posibles para el campo seleccionado: '" + campo + "':\n" + valores);
        System.out.println("Introduce la posición del valor que guardar, 'guardar' para guardar los cambios, o 'salir' para cancelar.");
        System.out.println("Ten en cuenta que para poder guardar, debes haber seleccionado al menos un elemento.");
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int modo) {
        System.out.println(this.mensajesError.get(modo));
        this.lector.nextLine();
    }
}
