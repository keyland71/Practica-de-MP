/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas;

import clasesDeJuego.Administrador;
import clasesDeJuego.Jugador;
import clasesDeJuego.NumeroRegistro;
import java.util.logging.Level;
import java.util.logging.Logger;
import practicamp.Juego;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class FabricaUsuarios {

    private String nick;
    private String contrasenia;
    private String nombre;

    public FabricaUsuarios() {
    }

    /**
     * @param nick the nick to set
     */
    public void ponerNick(String nick) {
        this.nick = nick;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void ponerContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @param nombre the nombre to set
     */
    public void ponerNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador crearJugador() {
        try {
            Jugador j = new Jugador(this.nombre, this.nick, this.contrasenia);
            ponerNumeroRegistro(j);
            return j;
        } catch (NumRegOverflowException ex) {
            System.out.println("Ha habido un error al crear el jugador. No se ha creado el jugador");
            return null;
        } 
    }

    public Administrador crearAdministrador() {
        Administrador admin = new Administrador(this.nombre, this.nick, this.contrasenia);
        return admin;
    }

    private void ponerNumeroRegistro(Jugador j) throws NumRegOverflowException {
        NumeroRegistro num = Juego.estado.obtenerNumeroRegistro();
        num.incrementarNumReg();
        j.ponerNumReg(num);
        Juego.estado.ponerNumReg(num);
    }
}
