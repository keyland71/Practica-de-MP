/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenDesafios;
import baseDeDatos.AlmacenPersonajes;
import baseDeDatos.Estado;
import clasesDeJuego.Combate;
import clasesDeJuego.Desafio;
import clasesDeJuego.Usuario;
import java.util.ArrayList;
import java.util.List;
import menus.MenuBorrarPersonaje;
import menus.MenuJugador;
import menus.MenuOro;
import menus.MenuRanking;

/**
 *
 * @author Ángel Marqués
 */
public class ControladorJugador { //ojo cuidao con las notificaciones
    private Usuario usuario; //esto es necesario? 
    private MenuJugador menuJugador;
    private MenuRanking menuRanking;
    private MenuOro menuOro;
    private MenuBorrarPersonaje menuBorrarPersonaje;
    private int modo;  //0 selección de opción, 1 borrarPersonaje (si/no)
    
    public ControladorJugador(){
        this.menuBorrarPersonaje = new MenuBorrarPersonaje();
        this.menuJugador = new MenuJugador();
        this.menuRanking = new MenuRanking(); 
        this.menuOro = new MenuOro();
        
        this.usuario = Estado.obtenerUsuarioActivo(); //si el usuario activo fuera publico, no haría falta
        this.modo = 0;
    }
    
    public void iniciarControlador(){
        boolean salir = false;
        do {
            this.modo = 0;
            String opcion = this.menuJugador.mostrarMensaje(0);
            if (validarEntrada(opcion)) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuJugador.mostrarMensajeError(0);
            }
        } while (!salir);
    }
    
    private boolean validarEntrada(String opcion){
        switch (this.modo){
            case 0 -> { //input válido si es un número del 1 al 8, inclusive
                return opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("5") || opcion.equals("6") || opcion.equals("7") || opcion.equals("8");
            }
            case 1 -> {
                return opcion.equals("si") || opcion.equals("no");
            }
        }
        return false;
    }
    
    private boolean procesarEntrada(String entrada){
        String opcion;
        switch (this.modo){
            case 0 -> {
                switch (entrada){
                    case "1" -> { //consultar ranking
                        this.menuRanking.mostrarRanking();
                    }
                    case "2" -> { // cambiar equipo
                        ControladorCambiarEquipo cCamEq = new ControladorCambiarEquipo();
                        cCamEq.iniciarControlador();
                    }
                    case "3" -> { // hacer desafío
                        ControladorCrearDesafío cCrearDes = new ControladorCrearDesafío();
                        cCrearDes.iniciarControlador();
                    }
                    case "4" -> { // consultar historial de oro
                        //según pone en el diseño, en este case habría que:
                        // 1. traer el almacén de desafíos y el usuario activo del estado
                        // 2. buscar entre los desafíos aquellos en los que esté el usuarioActivo
                        // 3. quedarse con los COMBATES de aquellos desafíos en los que esté el usuario
                        // 4. enviar los combates con menuOro.mostrarHistorial(listaDeDesafios)
                        //según yo entiendo, eso ocurriría en mostrarMenuOro()
                        
                        //yo (ángel) sugiero que todo eso ocurra en el menuOro al llamar a su constructor.
                        //this.menuOro.mostrarHistorial();
                        mostrarMenuOro();
                    }
                    case "5" -> { // crear personaje
                        ControladorCrearPersonaje cCrearPers = new ControladorCrearPersonaje();
                        cCrearPers.iniciarControlador();
                    }
                    case "6" -> { // borrar personaje
                        boolean valido;
                        do {
                            this.modo = 1;
                            opcion = this.menuBorrarPersonaje.mostrarMensaje(0); //seguro que lo quieres borrar?
                            valido = validarEntrada(opcion);
                            if (!valido){
                                this.menuBorrarPersonaje.mostrarMensajeError(0);
                            }
                        } while (!valido);
                        if (opcion.equals("si")){
                            AlmacenPersonajes almacen = Estado.obtenerAlmacenPersonajes();
                            almacen.borrarPersonaje(Estado.obtenerPersonajeActivo());
                            this.menuBorrarPersonaje.mostrarMensaje(1); //borrado correctamente
                        }
                    }
                    case "7" -> { // borrar cuenta
                        //preguntar si está seguro
                        //luego obtener el almacén de usuarios, y eliminar el usuario con el nombre del usuario activo
                    }
                    case "8" -> { // cerrar sesión
                        String optSalir = this.menuJugador.mostrarMensaje(3);
                        this.modo = 1;
                        if (validarEntrada(optSalir)) {
                            return optSalir.equals("si");
                        } //end if
                    } // end case "8"
                } //end switch 1
            } //end case 0
        } //end switch 2
        return false;
    }

    private void mostrarMenuOro() {
        AlmacenDesafios almacen = Estado.obtenerAlmacenDesafios();
        List<Desafio> desafios = almacen.obtenerDesafiosCompletados();
        List<Combate> combates = new ArrayList<>();
        for (Desafio desafio:desafios) {
            combates.add(desafio.obtenerCombate());
        }
        this.menuOro.mostrarHistorial(combates);
    }
}
