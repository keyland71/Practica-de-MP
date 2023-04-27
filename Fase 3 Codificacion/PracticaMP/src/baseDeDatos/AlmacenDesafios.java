/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Desafio;
import clasesDeJuego.EstadoDesafio;
import clasesDeJuego.Jugador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import practicamp.Juego;

/**
 *
 * @author Marcos Jiménez
 * @author Lucia Dominguez
 * @author Ángel Marqués
 */
public class AlmacenDesafios implements Serializable {

    private List<Desafio> desafios;

    public AlmacenDesafios() {
        this.desafios = new ArrayList<>();
    }

    public void aniadirDesafio(Desafio des) {
        desafios.add(des);
        Juego.estado.guardar();
    }

    public void borrarDesafio(Desafio des) {
        desafios.remove(des);
        Juego.estado.guardar();
    }

    public List<Desafio> obtenerDesafios() {
        return this.desafios;
    }

    public List<Desafio> obtenerDesafiosCompletados(String nick) {
        Jugador j = (Jugador) Juego.estado.obtenerAlmacenUsuarios().obtenerUsuario(nick);

        List<Desafio> desafiosCompletados = new ArrayList<>();
        for (Desafio d : this.desafios) {
            if (d.obtenerEstado() == EstadoDesafio.completado || d.obtenerEstado().equals(EstadoDesafio.aceptado) && (d.obtenerJugadorDesafiado().obtenerNick().equals(j.obtenerNick()) || d.obtenerJugadorDesafiante().obtenerNick().equals(j.obtenerNick()))) {
                desafiosCompletados.add(d);
            }
        }
        return desafiosCompletados;
    }

    public List<Desafio> obtenerDesafiosAvalidar() {
        List<Desafio> desafiosAvalidar = new ArrayList<>();
        for (Desafio d : this.desafios) {
            if (d.obtenerEstado() == EstadoDesafio.pendienteValidar) {
                desafiosAvalidar.add(d);
            }
        }
        return desafiosAvalidar;
    }

    public List<Desafio> obtenerDesafiosPendientesAceptar(String nick) {
        List<Desafio> desafiosPendientes = new ArrayList<>();
        for (Desafio d : this.desafios) {
            if (d.obtenerEstado() == EstadoDesafio.validado && (d.obtenerJugadorDesafiado().obtenerNick().equals(nick))) {
                desafiosPendientes.add(d);
            }
        }
        return desafiosPendientes;
    }

    public List<Desafio> obtenerDesafiosNoMostrados(String nick) {
        List<Desafio> desafiosPendientes = new ArrayList<>();
        for (Desafio d : this.desafios) {
            if ((d.obtenerEstado() == EstadoDesafio.aceptado || d.obtenerEstado() == EstadoDesafio.rechazado || d.obtenerEstado() == EstadoDesafio.cancelado) && (d.obtenerJugadorDesafiante().obtenerNick().equals(nick))) {
                desafiosPendientes.add(d);
            }
        }
        return desafiosPendientes;
    }

}
