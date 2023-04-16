/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;

/**
 *
 * @author marqu
 */
public class Usuario implements Serializable{
    private String nombre;
    private String nick;
    private String contrasenia;
    private boolean baneado;
    private NumeroRegistro numReg;
    
    public Usuario(String nombre, String nick, String contrasenia){
        this.nombre = nombre;
        this.nick = nick;
        this.contrasenia = encriptarContrasenia(contrasenia);
        this.baneado = false;
    }
    
    public String obtenerNick(){
        return this.nick;
    }
    //this does not work. either encriptarContrasenia es público, o (y considero que es mejor)
    //no ponemos obtenerContrasenia sino compararContrasenia.
    public String obtenerContrasenia(){
        return this.contrasenia;
    }
    //por implementar
    private String encriptarContrasenia(String c){
        return c;
    }
    public boolean esAdministrador(){
        if (this.numReg.equals(this.numReg.obtenerPrimero())){
            return true;
        } else 
            return false;
    }
    public boolean estaBaneado(){
        return this.baneado;
    }
    public void cambiarBaneo(boolean b){
        this.baneado = b;
    }
    
    //de ángel. Esto supone que en el constructor se inicializa numReg (creo que si no no funcionaría)
    // ahora mismo esa suposición no se cumple
    public void ponerNumReg(NumeroRegistro numR){
        this.numReg.copy(numR); 
    }
    
}
