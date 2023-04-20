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
 * @author burakku
 */
public class MenuBorrarCuenta {
    private List<String> mensajes;
    private String mensajeError;
    private Scanner lector;
    
    public MenuBorrarCuenta(){
        mensajes = new ArrayList<>();
        
        String mensaje = "¿Seguro que quieres borrar tu cuenta? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Esta accion no podrá ser desecha, y perderás todo tu progreso. ¿Seguro que quieres continuar? (si/no)";
        this.mensajes.add(mensaje);
        mensaje = "Se ha borrado su cuenta. Pulse intro para continuar";
        this.mensajes.add(mensaje);
        mensajeError = "Por favor, introduzca un valor correcto. Pulse intro para continuar";
        
        this.lector = new Scanner(System.in);
    }
    
    public String mostrarMensaje(int pos) {
        System.out.println(this.mensajes.get(pos));
        return this.lector.nextLine();
    }

    public void mostrarMensajeError() {
        System.out.println(this.mensajeError);
        this.lector.nextLine();
    }

}
