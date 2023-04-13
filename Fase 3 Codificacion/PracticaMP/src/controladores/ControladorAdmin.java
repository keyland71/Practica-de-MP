/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import menus.MenuAdmin;

/**
 * @authos marcos
 * @author lucia
 */
public class ControladorAdmin {
    private MenuAdmin menuAdministrador;
    //private 
    private int modo; //0 selección
   
    
 public ControladorAdmin(){
     this.menuAdministrador = new MenuAdmin();
     this.modo = 0; 
 }
   
    
public void iniciarControlador(){
    boolean salir= false;
    while (!salir) {
        this.modo=0;
        String opcion= this.menuAdministrador.mostrarMensaje(0);
        boolean valido = validarEntrada (opcion);
        if (valido) {
                salir = procesarEntrada(opcion);
          } else {
        this.menuAdministrador.mostrarMensajeError(0);
    }
  }
 }

private boolean validarEntrada (String opcion){
    switch (this.modo){
        case 0 -> { 
         return opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals ("4") || opcion.equals ("5");   
    }   
        case 1 -> {
            //lista personajes -> Habría que comprobar que el valor introducido esté entre 0 y la length ppersonajes-1
           
        }
        case 2 ->{
           //lista desafios a validar -> lo mismo que arriba
        }
        case 3 ->{
            //lista usuarios baneados -> lo mismo que arriba
        }
        case 4 -> {
            return opcion.equals ("si") || opcion.equals ("no");
        }
        case 5 -> {
             return opcion.equals("si") || opcion.equals("no");
        } 
        }
     return false;
    }


private boolean procesarEntrada (String opcion){
    switch (this.modo){
        case 0 -> {
            switch (opcion){
                case "1" -> {
                     //se llama a controlador editar personajes; 
                     //ControladorEditarPersonaje nombre = new ControladorEditarPersonaje(); //editar personajes es privado, por lo que habría que llamarlo desde su constructor
            }
                case "2" -> {
                     //se llama a controlador de validar desafio;
                      //ControladorValidarDesafio nombre = new ControladorValidarDesafio(); //lo mismo que arriba
                }
                case "3" -> {
                 //se llama a controlador de baneos
                  //ControladorBaneos nombre = new ControladorBaneos(); //lo mismo que arriba
                }
                case "4" -> {
                    darseDeBaja();
                }
                default -> {
                        String optSalir = this.menuAdministrador.mostrarMensaje(3);
                        this.modo = 3;
                        boolean valido = validarEntrada(optSalir);
                        if (valido) {
                            return optSalir.equals("si");
                        }
                    }
            }
        }
    }

return false;
}


private void darseDeBaja(){
    //deberá de borrarse en usuario en la base de datos;
    
    System.out.println ("todavía no implementado");
}
}





