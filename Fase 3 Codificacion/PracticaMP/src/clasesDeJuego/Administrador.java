/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author Ángel Marqués García
 */
public class Administrador extends Usuario {

    public Administrador(String nombre, String nick, String contrasenia) {
        super(nombre, nick, contrasenia);
    }

    //habría que ver estas dos si se dejan así o si se hace al revés. Esta implementación en Usuario, y que Jugador le haga override
    //está explicado en Jugador por qué lo he hecho así
    @Override
    public boolean estaBaneado() {
        return false;
    }

    @Override
    public void cambiarBaneo(boolean b) {
    }
}
