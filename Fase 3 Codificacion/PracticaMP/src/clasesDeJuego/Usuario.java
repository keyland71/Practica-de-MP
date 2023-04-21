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
        this.contrasenia = this.encriptarContrasenia(contrasenia);
        this.claveEncriptacion = 0;
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
    
    
    public String encriptarContrasenia(String c){ //Funciona (probado aparte)
        String [] caracteres = c.split("");
        int clave = (int)((Math.random()*126)+33); //Genera un numero aleatorio entre el 33 y el 126 (caracteres imprimibles de la tabla ASCII)
        
        String contraseniaEncriptada = "";
        for (int i = 0; i<= c.length()-1; i++){
           char caracter = caracteres[i].charAt(0);
           int posicionTablaASCII = caracter;
           while (posicionTablaASCII + clave > 126){ //Para que la suma del entero ASCII mas la clave de encriptacion siempre sea un caracter imprimible de la tabla ASCII
               clave = clave / 2;
           }
           posicionTablaASCII = (posicionTablaASCII + clave);
           char nuevoCaracter = (char) posicionTablaASCII;
           String nuevoString = Character.toString(nuevoCaracter);
           caracteres[i] = nuevoString;
           contraseniaEncriptada = contraseniaEncriptada + (caracteres[i] == null ? "" : caracteres[i]);  
        }
        this.claveEncriptacion = clave;
        return contraseniaEncriptada; 
    }
    
    public String desencriptarContrasenia(String c){ //Funciona (probado aparte)
        String [] caracteres = c.split("");
        String contraseniaDesencriptada = "";
        for (int i = 0; i<= c.length()-1; i++){
           char caracter = caracteres[i].charAt(0);
           int posicionTablaASCII = caracter;
           posicionTablaASCII = (posicionTablaASCII - this.claveEncriptacion);
           char nuevoCaracter = (char) posicionTablaASCII;
           String nuevoString = Character.toString(nuevoCaracter);
           caracteres[i] = nuevoString;
           contraseniaDesencriptada = contraseniaDesencriptada + (caracteres[i] == null ? "" : caracteres[i]);  
        }
        this.claveEncriptacion = 0;
        return contraseniaDesencriptada; 
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
