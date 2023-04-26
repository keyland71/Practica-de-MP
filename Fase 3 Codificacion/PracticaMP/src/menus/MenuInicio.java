package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class MenuInicio {

    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;

    public MenuInicio() {
        this.mensajes = new ArrayList<>();
        this.mensajesError = new ArrayList<>();
        String mensaje = """
                         Bienvenido a MP (Majestuosas Peleas).
                         Por favor, elija una opcion:
                         1) Iniciar sesion
                         2) Registrarse
                         3) Salir""";
        this.mensajes.add(mensaje);
        mensaje = "¿Está seguro de que desea salir?";
        this.mensajes.add(mensaje);
        mensaje = "Por favor, introduzca un valor correcto. Pulse cualquier boton para continuar.";
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

}
