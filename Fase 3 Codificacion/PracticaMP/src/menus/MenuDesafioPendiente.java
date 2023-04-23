/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import clasesDeJuego.Desafio;

/**
 *
 * @author Ángel Marqués
 */
public class MenuDesafioPendiente {
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;
    
    
    public MenuDesafioPendiente(){
        this.mensajesError = new ArrayList<>();

        String mensaje = "El valor introducido no es correcto. Introduce a para aceptar, o r para rechazar el combate.";
        this.mensajesError.add(mensaje);
        
        this.lector = new Scanner(System.in);
    }
    
    public String mostrarResumenDesafio(Desafio d) {
        String mensaje = "Te desafía " + d.obtenerJugadorDesafiante().obtenerNick() + ", con una apuesta de " + Integer.toString(d.obtenerOro()) + " piezas de oro.\n" +
                "¿Aceptas(a) o rechazas(r) el desafio? Ten en cuenta que si lo rechazas, deberás pagar " + Integer.toString(d.obtenerOro()/10) + " piezas de oro";
        System.out.println(mensaje);
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

}
