/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;

/**
 *
 * @author Ángel Marqués García
 */
public class Usuario implements Serializable{
    private String nombre;
    private String nick;
    private String contrasenia;
    private boolean baneado;
    private NumeroRegistro numReg;
    private Personaje personaje;
    
    public Usuario(String nombre, String nick, String contrasenia){
        this.nombre = nombre;
        this.nick = nick;
        this.contrasenia = encriptarContrasenia(contrasenia);
        this.baneado = false;
        this.numReg = new NumeroRegistro();
        this.personaje = null;
    }
    
    public String obtenerNick(){
        return this.nick;
    }
    public boolean compararContrasenia(String input){
        return this.contrasenia.equals(encriptarContrasenia(input));
    }
    //por implementar
    private String encriptarContrasenia(String c){
        return c;
    }
    public boolean esAdministrador(){
        return this.numReg.sonIguales(new NumeroRegistro());
    }
    public boolean estaBaneado(){
        return this.baneado;
    }
    public void cambiarBaneo(boolean b){
        this.baneado = b;
    }
    public void ponerNumReg(NumeroRegistro numR){
        this.numReg.copiar(numR); 
    }
    public void ponerPersonaje(Personaje p){
        this.personaje = p;
    }
}
