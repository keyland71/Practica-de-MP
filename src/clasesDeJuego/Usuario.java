/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Usuario implements Serializable {

    private String nombre;
    private String nick;
    private String contrasenia;
    private int claveEncriptacion;
    private boolean baneado;
    private NumeroRegistro numReg;

    public Usuario(String nombre, String nick, String contrasenia) {
        this.nombre = nombre;
        this.nick = nick;
        this.contrasenia = this.encriptarContrasenia(contrasenia, true);
        this.baneado = false;
        this.numReg = new NumeroRegistro();
    }

    public String obtenerNick() {
        return this.nick;
    }

    public boolean compararContrasenia(String input) {
        return this.contrasenia.equals(encriptarContrasenia(input, false));
    }

    private final String encriptarContrasenia(String c, boolean generarClave) {
        int clave;
        String[] caracteres = c.split("");
        if (generarClave) {
            clave = (int) ((Math.random() * 126) + 33);
        } else {
            clave = this.claveEncriptacion;
        }
        this.claveEncriptacion = clave;

        String contraseniaEncriptada = "";
        for (int i = 0; i <= c.length() - 1; i++) {
            char caracter = caracteres[i].charAt(0);
            int posicionTablaASCII = caracter;
            while (posicionTablaASCII + clave > 126) {
                clave = clave / 2;
            }
            posicionTablaASCII = (posicionTablaASCII + clave);
            char nuevoCaracter = (char) posicionTablaASCII;
            String nuevoString = Character.toString(nuevoCaracter);
            caracteres[i] = nuevoString;
            contraseniaEncriptada = contraseniaEncriptada + (caracteres[i] == null ? "" : caracteres[i]);
        }

        return contraseniaEncriptada;
    }

    public boolean esAdministrador() {
        return this.numReg.sonIguales(new NumeroRegistro());
    }

    public boolean estaBaneado() {
        return this.baneado;
    }

    public void cambiarBaneo(boolean b) {
        this.baneado = b;
    }

    public void ponerNumReg(NumeroRegistro numR) {
        this.numReg.copiar(numR);
    }
    
    public boolean compararNumReg(NumeroRegistro numR) {
        return this.numReg.sonIguales(numR);
    }

}
