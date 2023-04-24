/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clasesDeJuego.Combate;
import java.util.List;
import menus.MenuCombateTerminado;
import menus.MenuDesafioPendiente;
import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import clasesDeJuego.Jugador;
import clasesDeJuego.Personaje;
import practicamp.Juego;
import sistemas.DirectorCombate;

/**
 *
 * @author Ángel Marqués García
 */
//te muestra los desafíos que tengas pendientes por aceptar, o si algún desafío tuyo se ha completado, te lo muestra también
public class ControladorNotificaciones {

    private MenuDesafioPendiente menuDesafio;
    private MenuCombateTerminado menuCombate;
    private List<Desafio> desafiosPendientes;
    private List<Desafio> desafiosCompletados;
    private int modo;
    private Desafio desafioActual;

    public ControladorNotificaciones() {
        this.desafiosPendientes = Juego.estado.obtenerAlmacenDesafios().obtenerDesafiosPendientesAceptar(Juego.estado.obtenerUsuarioActivo().obtenerNick());
        this.desafiosCompletados = Juego.estado.obtenerAlmacenDesafios().obtenerDesafiosNoMostrados(Juego.estado.obtenerUsuarioActivo().obtenerNick());
        this.menuDesafio = new MenuDesafioPendiente();
        this.menuCombate = new MenuCombateTerminado();
    }

    public void iniciarControlador() {
        String opcion;
        boolean inputValido = false;
        this.modo = 0;
        for (Desafio d : this.desafiosPendientes) {
            this.desafioActual = d;
            do {
                opcion = this.menuDesafio.mostrarResumenDesafio(d);
                inputValido = validarEntrada(opcion);
                if (inputValido) {
                    procesarEntrada(opcion);
                } else {
                    this.menuDesafio.mostrarMensajeError(0);
                }
            } while (!inputValido);
        }

        for (Desafio d : this.desafiosCompletados) {
            this.menuCombate.mostrarCombate(d.obtenerCombate());
            d.cambiarEstado(EstadoDesafio.completado);
        }
        Juego.estado.guardar();
    }

    private boolean validarEntrada(String opcion) {
        if (modo == 0) {
            return opcion.equalsIgnoreCase("a") || opcion.equalsIgnoreCase("r");
        }
        return false;

    }

    private void procesarEntrada(String entrada) { //había un switch case 0, pero sólo con ese caso. En teoría nunca habrá más, lo he quitado por los indents 
        if (entrada.equalsIgnoreCase("a")) {
            Combate c = this.desafioActual.obtenerCombate();
            int oroDesafiado = c.obtenerUDesafiado().obtenerPersonaje().sumarOro(-this.desafioActual.obtenerOro());
            
            DirectorCombate director = new DirectorCombate(c);
            director.realizarCombate();
            
            Jugador vencedor = c.obtenerVencedor();
            if (vencedor == null){ //si es empate
                c.ponerOro(0);
                c.obtenerUDesafiado().obtenerPersonaje().sumarOro(oroDesafiado);
                this.desafioActual.devolverOro();
                return;
            }
            
            //si no es empate
            c.ponerOro(this.desafioActual.obtenerOro());
            
            vencedor.incrementarVictorias();
            
            //mensajes para el debug. Si bien es cierto que el primero de todos puede estar guay escribirlo
            Personaje p = Juego.estado.obtenerPersonajeActivo();
            
            System.out.println("Ha ganado " + vencedor.obtenerNick() + ", obtiene " + Integer.toString(this.desafioActual.obtenerOro() + oroDesafiado + DirectorCombate.oroFijo) + " de oro. Parte de " + Integer.toString(vencedor.obtenerPersonaje().obtenerOro()));
            System.out.println("Oro del personaje activo antes: " + Integer.toString(p.obtenerOro()));
            vencedor.obtenerPersonaje().sumarOro(this.desafioActual.obtenerOro() + oroDesafiado + DirectorCombate.oroFijo);
            System.out.println("Oro del personaje activo despues: " + Integer.toString(p.obtenerOro()));
            System.out.println("Y ha llegado a " + Integer.toString(vencedor.obtenerPersonaje().obtenerOro()));
            
            this.desafioActual.cambiarEstado(EstadoDesafio.aceptado);
            this.menuCombate.mostrarCombate(this.desafioActual.obtenerCombate());
            
        } else if (entrada.equalsIgnoreCase("r")) {
            combateRechazado();
        }
    }

    private void combateRechazado() {
        this.desafioActual.cambiarEstado(EstadoDesafio.rechazado); //cambia el estado a rechazado
        this.desafioActual.obtenerJugadorDesafiado().obtenerPersonaje().sumarOro(-this.desafioActual.obtenerOro() / 10); //penaliza al que rechaza
        this.desafioActual.devolverOro(); //devuelve el oro al que desafió
    }

}
