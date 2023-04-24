/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import clasesDeJuego.Desafio;
import clasesDeJuego.Jugador;
import clasesDeJuego.Personaje;
import menus.MenuCrearDesafio;
import practicamp.Juego;

/**
 *
 * @author Sergio de Oro
 * @author Marcos Jimenez
 * @author Lucía Dominguez
 * @author Ángel Marqués
 */
public class ControladorCrearDesafío {

    private int modo;
    private MenuCrearDesafio menuDesafio;
    private int oro;
    private Jugador oponente; 
    

    public ControladorCrearDesafío() {
        this.menuDesafio = new MenuCrearDesafio();
        this.modo = 0;
    }

    public void iniciarControlador() {
        boolean salir = false;
        this.modo = 0;
        do {
            String opcion = this.menuDesafio.mostrarMensaje(this.modo);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
                this.modo++;
            } else {
                this.menuDesafio.mostrarMensajeError(this.modo);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")){
            return true;
        }
        switch (this.modo) {
            case 0 -> { //input válido si es un número del 1 al 8, inclusive
                return confirmarOro(opcion);
            }
            case 1 -> {
                return usuarioValido(opcion);
            }
            case 2 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return false;
    }

    private boolean confirmarOro(String o) {
        int oroA = Integer.parseInt(o);
        Personaje p = Juego.estado.obtenerPersonajeActivo();
        return p.obtenerOro() >= oroA && oroA >= 0;
    }

    private boolean usuarioValido(String nombre) {
        AlmacenUsuarios almacen = Juego.estado.obtenerAlmacenUsuarios();
        if (!almacen.existeUsuario(nombre) || Juego.estado.obtenerUsuarioActivo().obtenerNick().equalsIgnoreCase(nombre)){
            return false; //si no existe el usuario o es el usuario activo, devuelve false
        }
        Jugador j = (Jugador) almacen.obtenerUsuario(nombre);
        return j.obtenerPersonaje()!=null;
    }

    private boolean procesarEntrada(String entrada) {
        if (entrada.equalsIgnoreCase("salir")){
            return true;
        }
        String opcion;
        switch (modo) {
            case 0 -> { //guardar el oro apostado
                this.oro = Integer.parseInt(entrada);
            }
            case 1 -> { //guardar el oponente
                this.oponente = (Jugador) Juego.estado.obtenerAlmacenUsuarios().obtenerUsuario(entrada);
            }
            case 2 -> { //crear el desafío y guardarlo
                if (entrada.equalsIgnoreCase("si")){
                    Jugador jActivo = (Jugador) Juego.estado.obtenerUsuarioActivo();
                    jActivo.obtenerPersonaje().sumarOro(-this.oro);
                    Desafio des = new Desafio(jActivo, this.oponente, this.oro);
                    Juego.estado.obtenerAlmacenDesafios().aniadirDesafio(des);
                }
                return true;
            }

        } //end switch 1
        return false;
    }
}
