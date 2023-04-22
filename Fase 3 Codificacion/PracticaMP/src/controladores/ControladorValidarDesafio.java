/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.Estado;
import clasesDeJuego.Combate;
import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import clasesDeJuego.Personaje;
import menus.MenuValidarDesafio;

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

    //se encarga de llevar a cabo el proceso de validación del desafío que reciba en el constructor
    public ControladorValidarDesafio(Desafio d) {
        this.menuDesafio = new MenuValidarDesafio();
        this.p1 = this.desafio.obtenerJugadorDesafiante().obtenerPersonaje();
        this.p2 = this.desafio.obtenerJugadorDesafiado().obtenerPersonaje();
        this.desafio = d;
        this.modo = 0;
    }

    public boolean iniciarControlador() {
        boolean salir = false;
        boolean tramitado = false;
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
        return tramitado; //necesito que devuelva algo para actualizar en ControladorSeleccionarDesafio la lista de desafios pendientes
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        int tam = 0;
        switch (this.modo) {
            case 0 -> { //input válido si es un número del 1 a len(fortalezas)
                tam = this.p1.obtenerFortalezas().size();
                //ponía esto en todas
                //return confirmarValido(opcion, this.p1.obtenerFortalezas().size());   
            }
            case 1 -> { //input válido si es un número del 1 a len(debilidades)
                tam = this.p1.obtenerDebilidades().size();
            }
            case 2 -> { //input válido si es un número del 1 a len(fortalezas)
                tam = this.p2.obtenerFortalezas().size();
            }
            case 3 -> { //input válido si es un número del 1 a len(debilidades)
                tam = this.p2.obtenerDebilidades().size();
            }
            case 4 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        return confirmarValido(opcion, tam); // si no ocurre ninguno en el case, se llama con tam=0, en cual caso devuelve false
    }

    private boolean confirmarValido(String opcion, int tam) { //devuelve true si opcion in range(tam)
        for (int i = 1; i <= tam; i++) {
            if (opcion.equals(Integer.toString(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean procesarEntrada(String entrada, boolean tramitado) {
        int pos = 0;
        if (this.modo != 4){
            pos = Integer.parseInt(entrada);
        }
        Combate c = this.desafio.obtenerCombate();
        
        if (entrada.equalsIgnoreCase("salir")) {
            this.menuDesafio.mostrarMensaje(2); //operacion cancelada
            c.resetearModificadores(); // si se interrumpe el proceso, reseteamos los modificadores
            return true;
        }

        switch (this.modo) { //guardamos en el combate el modificador seleccionado
            case 0 -> { // fortaleza 1
                c.ponerFortalezaP1(pos);
            }
            case 1 -> { // debilidad 1
                c.ponerDebilidadP1(pos);
            }
            case 2 -> { // fortaleza 2
                c.ponerFortalezaP2(pos);
            }
            case 3 -> { // debilidad 2
                c.ponerDebilidadP2(pos);
            }
            case 4 -> {
                if (entrada.equalsIgnoreCase("si")) {
                    this.desafio.cambiarEstado(EstadoDesafio.validado); //realizamos el cambio
                    Estado.obtenerAlmacenDesafios().guardarDesafios();  //guardamos el cambio
                    this.menuDesafio.mostrarMensaje(5); //Desafio validado
                    tramitado = true;
                } else{
                    c.resetearModificadores(); // si no se crea el desafío, reseteamos los modificadores
                }
                return true;
            }
        }
        return false;
        
    }
}
