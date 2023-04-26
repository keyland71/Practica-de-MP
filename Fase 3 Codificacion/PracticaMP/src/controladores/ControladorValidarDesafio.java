/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clasesDeJuego.Combate;
import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import clasesDeJuego.Personaje;
import menus.MenuValidarDesafio;
import practicamp.Juego;

/**
 *
 * @author Ángel Marqués
 */
public class ControladorValidarDesafio {

    private int modo;
    private MenuValidarDesafio menuDesafio;
    private Desafio desafio;
    private Personaje p1;
    private Personaje p2;

    /**
     * se encarga de llevar a cabo el proceso de validación del desafío que
     * reciba en el constructor
     *
     * @param d desafío a validar
     */
    public ControladorValidarDesafio(Desafio d) {
        this.desafio = d;
        this.p1 = this.desafio.obtenerJugadorDesafiante().obtenerPersonaje();
        this.p2 = this.desafio.obtenerJugadorDesafiado().obtenerPersonaje();
        this.menuDesafio = new MenuValidarDesafio(p1, p2);
        this.modo = 0;
    }

    public boolean iniciarControlador() {
        boolean salir = false;
        boolean tramitado[] = {false};
        this.modo = 0;
        do {
            String opcion = this.menuDesafio.mostrarMensaje(this.modo);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion, tramitado);
                this.modo++;
            } else {
                this.menuDesafio.mostrarMensajeError(this.modo);
            }
        } while (!salir);
        return tramitado[0];
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        int tam = 0;
        switch (this.modo) {
            case 0 -> {
                tam = this.p1.obtenerFortalezas().size();   
            }
            case 1 -> {
                tam = this.p1.obtenerDebilidades().size();
            }
            case 2 -> {
                tam = this.p2.obtenerFortalezas().size();
            }
            case 3 -> {
                tam = this.p2.obtenerDebilidades().size();
            }
            case 4 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return confirmarValido(opcion, tam);
    }

    private boolean confirmarValido(String opcion, int tam) {
        for (int i = 1; i <= tam; i++) {
            if (opcion.equals(Integer.toString(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean procesarEntrada(String entrada, boolean[] tramitado) {

        Combate c = this.desafio.obtenerCombate();
        if (entrada.equalsIgnoreCase("salir")) {
            this.menuDesafio.mostrarMensaje(2);
            c.resetearModificadores();
            return true;
        }

        int pos = 0;
        if (this.modo != 4) {
            pos = Integer.parseInt(entrada);
        }

        switch (this.modo) {
            case 0 -> {
                c.ponerFortalezaP1(pos);
            }
            case 1 -> {
                c.ponerDebilidadP1(pos);
            }
            case 2 -> {
                c.ponerFortalezaP2(pos);
            }
            case 3 -> {
                c.ponerDebilidadP2(pos);
            }
            case 4 -> {
                if (entrada.equalsIgnoreCase("si")) {
                    this.desafio.cambiarEstado(EstadoDesafio.validado);
                    Juego.estado.guardar();
                    this.menuDesafio.mostrarMensaje(5);
                    tramitado[0] = true;
                } else {
                    c.resetearModificadores();
                }
                return true;
            }
        }
        return false;

    }
}
