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
 * @author lucia
 */
public class MenuAdmin {
    private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;


public MenuAdmin(){
  this.mensajes = new ArrayList<>();
  this.mensajesError = new ArrayList<>();
        String mensaje = """
                         Bienvenido administrador.
                         Por favor, elija una opcion:
                         1) Editar Personajes
                         2) Validar desafios
                         3) Banerar/desbanear usuarios
                         4) Darse de baja
                         5) Salir""";
        this.mensajes.add(mensaje);
        mensaje = "¿Esta seguro de que quiere borrar su cuenta?";
        this.mensajes.add(mensaje);
        mensaje = "¿Esta seguro de que desea salir?";
        this.mensajes.add(mensaje);
        mensaje = "Por favor, introduzca un valor correcto. Pulse cualquier boton para continuar";
        this.mensajesError.add(mensaje);
        
        this.lector = new Scanner(System.in);
    }
 public String mostrarMensaje(int pos) {
        String mensaje = this.mensajes.get(pos);
        System.out.println(mensaje);
        String opcion = this.lector.nextLine();
        return opcion;
    }

    public void mostrarMensajeError(int modo) {
        String mensaje = this.mensajesError.get(modo);
        System.out.println(mensaje);
        this.lector.nextLine();
    }
}

