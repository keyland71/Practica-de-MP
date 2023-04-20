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
    private int claveEncriptacion;
    private boolean baneado;
    private NumeroRegistro numReg;
   
    
    public Usuario(String nombre, String nick, String contrasenia){
        this.nombre = nombre;
        this.nick = nick;
        this.contrasenia = encriptarContrasenia(contrasenia);
        this.baneado = false;
        this.numReg = new NumeroRegistro();
    }
    
    public String obtenerNick(){
        return this.nick;
    }
    
    public String obtenerContrasenia(){
        return this.contrasenia;  
    }
    
    public boolean compararContrasenia(String input){
        return this.contrasenia.equals(encriptarContrasenia(input));
    }
    
    
    private String encriptarContrasenia(String c){
        /*String [] caracteres = c.split("");
        int clave = (int)(((Math.random()*10)+1)*96); //Genera un numero aleatorio entre el 0 y el 96
        if (clave > 126) {
            clave = clave / 2;
        }
        for (int i = 0; i<= c.length(); i++){
           char caracter = caracteres[i].charAt(0);
           int posicionTablaASCII = caracter;
           posicionTablaASCII = (posicionTablaASCII + clave);
           char nuevoCaracter = (char) posicionTablaASCII;
           String nuevoString = nuevoCaracter.toString(0); //REVISAR
           caracteres[i] = nuevoString;
           String contrasenia = contrasenia.concat(caracteres[i]);
        }
        this.claveEncriptacion = clave;*/
        
        return c; //Debería de ser return contrasenia
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
    
  }
