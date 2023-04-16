/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas;

import baseDeDatos.AlmacenUsuarios;
import baseDeDatos.Estado;
import clasesDeJuego.Administrador;
import clasesDeJuego.Jugador;
import clasesDeJuego.NumeroRegistro;
import clasesDeJuego.Usuario;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class FabricaUsuarios {
    //en el diseño pone que tiene como atributo un Jugador y un Admin
    //aunque las flechas dicen que sólo los usa
    //no veo qué ganas teniéndolos como atributo, así que no los pongo
    public FabricaUsuarios(){
    }
    public Jugador crearJugador(String nombre, String nick, String contrasenia){
        Jugador j =new Jugador(nombre, nick, contrasenia);
        ponerNumeroRegistro(j);
        return j;
    }
    public Administrador crearAdministrador(String nombre, String nick, String contrasenia){
        Administrador admin =new Administrador(nombre, nick, contrasenia);
        return admin;
    }
    private void ponerNumeroRegistro(Jugador j){
        NumeroRegistro num = Estado.obtenerNumeroRegistro();
        num = num.incrementarNumReg();
        j.ponerNumReg(num);
        Estado.ponerNumReg(num);
    }
}
