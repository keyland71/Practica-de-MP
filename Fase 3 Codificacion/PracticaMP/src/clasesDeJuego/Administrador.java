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
public class Administrador extends Usuario {

    public Administrador(String nombre, String nick, String contrasenia) {
        super(nombre, nick, contrasenia);
    }

    @Override
    public boolean estaBaneado() {
        return false;
    }

    @Override
    public void cambiarBaneo(boolean b) {
    }
}
