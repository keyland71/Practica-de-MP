/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import baseDeDatos.Estado;
import clasesDeJuego.Desafio;
import clasesDeJuego.Jugador;
import clasesDeJuego.Personaje;
import menus.MenuCrearDesafio;

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
                return nickExiste(opcion);
            }
            case 2 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return false;
    }

    private boolean confirmarOro(String o) {
        int oroA = Integer.parseInt(o);
        Jugador j = (Jugador) Estado.obtenerUsuarioActivo();
        Personaje p = j.obtenerPersonaje();
        return p.obtenerOro() > oroA;
    }

    private boolean nickExiste(String nombre) {
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        return almacen.existeUsuario(nombre);
    }

    private boolean procesarEntrada(String entrada) {
        if (entrada.equals("salir")){
            return true;
        }
        String opcion;
        switch (modo) {
            case 0 -> { //guardar el oro apostado
                this.oro = Integer.parseInt(entrada);
            }
            case 1 -> { //guardar el oponente
                this.oponente = (Jugador) Estado.obtenerAlmacenUsuarios().obtenerUsuario(entrada);
            }
            case 2 -> { //crear el desafío y guardarlo
                if (entrada.equalsIgnoreCase("si")){
                    Jugador jActivo = (Jugador) Estado.obtenerUsuarioActivo();
                    Desafio des = new Desafio(jActivo, this.oponente, this.oro);
                    Estado.obtenerAlmacenDesafios().aniadirDesafio(des);
                }
            }

        } //end switch 1
        return false;
    }
}
