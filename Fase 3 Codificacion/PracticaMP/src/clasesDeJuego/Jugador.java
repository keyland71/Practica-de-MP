/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Jugador extends Usuario {

    private Personaje personaje;
    private int victorias;

    public Jugador(String nombre, String nick, String contrasenia) {
        super(nombre, nick, contrasenia);
        this.victorias = 0;
        this.personaje = null;
    }

    public Personaje obtenerPersonaje() {
        return this.personaje;
    }

    public void ponerPersonaje(Personaje p) {
        this.personaje = p;
    }
    
    public void incrementarVictorias() {
        this.victorias++;
    }

    public int obtenerVictorias() {
        return this.victorias;
    }
}
