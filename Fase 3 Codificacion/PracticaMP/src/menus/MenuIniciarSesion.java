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
public class MenuIniciarSesion {
     private List<String> mensajes;
    private List<String> mensajesError;
    private Scanner lector;   
    
 public MenuIniciarSesion(){
   this.mensajes= new ArrayList<>();
   this.mensajesError = new ArrayList<>();
   
   String mensaje = "Introduce tu nick unico";
   this.mensajes.add(mensaje);
   mensaje = "Introduce tu contrasenia";
   this.mensajes.add(mensaje);
     mensaje = " ¿Desa iniciar sesion ?";
   this.mensajes.add(mensaje);
   mensaje = "Por favor, introduzca un nick valido. Pulse cualquier boton para continuar";
   this.mensajesError.add(mensaje);
   mensaje = "Por favor, introduzca una contraseña válida. Pulse cualquier botón para continuar";
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
        (new Scanner(System.in)).nextLine();
    }
 
 
 
}
