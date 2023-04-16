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
public class MenuJugador { //se ocupa de Ranking, Oro, Borrar personaje, y ¿Crear Personaje?
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;
    
    public MenuJugador(){
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        
        String mensaje0 = """
                          1. Consultar Ranking
                          2. Cambiar Equipo Activo
                          3. Hacer Desafío
                          4. Consultar Historial de Oro
                          5. Crear Personaje
                          6. Borrar Personaje
                          7. Borrar Cuenta
                          8. Cerrar Sesión
                          """;
        String mensaje1 = "¿Seguro que quiere borrar su personaje?";
        String mensaje2 = "¿Seguro que quiere borrar su cuenta?";
        String mensaje3 = "¿Seguro que quiere cerrar sesión?";
        mensajes.add(mensaje0);
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);
        
        String mensajeError1 = "Por favor, introduzca un valor correcto. Pulse intro para continuar";
        this.mensajesError.add(mensajeError1);
        
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