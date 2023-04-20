/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import menus.MenuCrearPersonaje;

/**
 *
 * @author Marcos, Lucía
 */

public class ControladorCrearPersonaje {
    
    private MenuCrearPersonaje menuCrearPersonaje;
    private int modo; //0 introducir nombre, 1 introducir tipo de personaje
    
    
    public ControladorCrearPersonaje(){
        this.menuCrearPersonaje = new MenuCrearPersonaje();
    }
    
    public void iniciarControlador(){
        boolean salir = false;
        do{
            this.modo = 0;
            String opcion = this.menuCrearPersonaje.mostrarMensaje(0);
            
        }
        while(true); //Cambiar true por valor que corresponda
    }
}
