/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author marqu
 */
public class Jugador extends Usuario {
    private Personaje personaje;
    
    public Jugador(String nombre, String nick, String contrasenia){
        super(nombre, nick, contrasenia); //se hacía así?
        this.personaje = null;
    }
    public Personaje obtenerPersonaje(){
        return this.personaje;
    }
    //no me tiene sentido implementar aquí estaBaneado, porque necesitarias implementarlo tb arriba
    //y para eso te quedas con la implementación de arriba
    //más sentido me tiene implementarlo arriba y hacer override en Admin
    //por ahora lo hago como he dicho
}