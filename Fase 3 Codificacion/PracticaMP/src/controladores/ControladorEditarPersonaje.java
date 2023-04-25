/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clasesDeJuego.Personaje;
import java.util.List;
import menus.MenuDetallePersonaje;

/**
 *
 * @author Ángel Marqués
 */
public class ControladorEditarPersonaje {
    private MenuDetallePersonaje menuPj;
    private Personaje personaje;
    private int modo;

    public ControladorEditarPersonaje(Personaje pj) {
        this.menuPj = new MenuDetallePersonaje(pj);
        this.personaje = pj;
        
    }

    void iniciarControlador() {
        this.menuPj.mostrarPersonaje();
    }
    
}
