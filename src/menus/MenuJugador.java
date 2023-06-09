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
 */
public class MenuJugador {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;
    private int oro;

    public MenuJugador() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        this.oro = 0;

        String mensaje0 = "";
        String mensaje1 = "¿Seguro que quiere borrar su personaje?";
        String mensaje2 = "¿Seguro que quiere borrar su cuenta?";
        String mensaje3 = "¿Seguro que quiere cerrar sesión?";
        String mensaje4 = "No puede crear un desafio si no tiene personaje.";
        String mensaje5 = "No puede editar su personaje si no tiene un personaje. Cree un personaje y vuelva a intentarlo.";
        String mensaje6 = "No puede crear un desafio, pues no hay jugadores a los que desafiar";
        mensajes.add(mensaje0);
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);
        mensajes.add(mensaje4);
        mensajes.add(mensaje5);
        mensajes.add(mensaje6);

        String mensajeError1 = "Por favor, introduzca un valor correcto. Pulse intro para continuar";
        String mensajeError2 = "No puedes crear un personaje si ya tienes uno. Borra tu personaje y vuelve a intentarlo";
        this.mensajesError.add(mensajeError1);
        this.mensajesError.add(mensajeError2);

        this.lector = new Scanner(System.in);
    }

    public String mostrarMensaje(int pos) {
        if (pos == 0) {
            return mostrarMensaje0();
        }
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }

    private String mostrarMensaje0() {
        String mensaje0 = String.format("""
                          Bienvenido al Menú de Jugador, estas son tus opciones:
                            1. Consultar Ranking
                            2. Cambiar Equipo Activo
                            3. Hacer Desafio (%s)                               
                            4. Consultar Historial de Oro
                            5. Crear Personaje
                            6. Borrar Personaje
                            7. Darse de baja/Borrar cuenta
                            8. Cerrar Sesión""", Integer.toString(oro));
        System.out.println(mensaje0);
        return this.lector.nextLine();
    }

    public void ponerOro(int o) {
        this.oro = o;
    }

}
