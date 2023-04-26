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
                         3) Banear usuarios
                         4) Desbanear usuarios
                         5) Darse de baja/Borrar cuenta
                         6) Cerrar sesión""";
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
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError(int pos) {
        System.out.println(this.mensajesError.get(pos));
        this.lector.nextLine();
    }
}

