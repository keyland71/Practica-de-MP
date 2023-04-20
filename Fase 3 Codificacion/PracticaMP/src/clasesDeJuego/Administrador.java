/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author marqu
 */
public class Administrador extends Usuario{
    
    public Administrador(String nombre, String nick, String contrasenia){
        super(nombre, nick, contrasenia); //se hacía así?
    }
    
    public boolean estaBaneado(){
        return false;
    }
    public void cambiarBaneo(boolean b){
    }
}
