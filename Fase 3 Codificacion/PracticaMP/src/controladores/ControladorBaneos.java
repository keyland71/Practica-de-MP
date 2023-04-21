/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import baseDeDatos.AlmacenUsuarios;
import baseDeDatos.Estado;
import clasesDeJuego.Jugador;
import java.util.ArrayList;
import java.util.List;
import menus.MenuBaneo;

/**
 *
 * @author Ángel Marqués García
 */
public class ControladorBaneos {

    private MenuBaneo menuBan;
    private boolean mostrarBaneados; //será true cuando estemos DESbaneando. Para desbanear necesitas ver los baneados, para banear los no baneados
    private List<Jugador> jugadores;
    private int modo;
    private int pagActual;
    public static int tamPag = 5;

    public ControladorBaneos(boolean mostrarBan) {
        this.menuBan = new MenuBaneo();
        this.pagActual = 0;
        this.mostrarBaneados = mostrarBan;
        this.modo = 0;
        this.jugadores = new ArrayList<>();
    }

    public void cargarJugadores(){
        AlmacenUsuarios almacen = Estado.obtenerAlmacenUsuarios();
        List<Jugador> candidatos = almacen.obtenerJugadores();
        
        for (Jugador j:candidatos){
            if (j.estaBaneado() == this.mostrarBaneados){
                this.jugadores.add(j);
            }
        }
    }
    
    public void iniciarControlador() {
        cargarJugadores();
        this.menuBan.ponerJugadores(this.jugadores);
        if (this.jugadores.isEmpty()){
            this.menuBan.mostrarMensaje(mostrarBaneados ? 5:4);
            return;
        }
        
        boolean salir = false;

        do {
            this.modo = 0;
            if (this.pagActual*tamPag>this.jugadores.size()-1){ //this is some confusing logic
                if (this.pagActual != 0){
                    this.pagActual--;
                } else{
                    this.menuBan.mostrarMensaje(mostrarBaneados ? 5:4);
                    return;
                }
            }
            String opcion = this.menuBan.mostrarPagina(pagActual, mostrarBaneados);
            if (validarEntrada(opcion)) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuBan.mostrarMensajeError(0);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {   
        switch (this.modo) {
            case 0 -> { //salir, s, a, 1, 2, ..., tamPag
                //si decide salir, siguiente o anterior página, es válido
                //si no decide eso, hay varias opciones.
                //si el número de elementos es múltiplo del tamaño de página, todas las páginas tendrán 5 elementos, por lo que 1-5 serán válidos independientemente de pagActual
                //En caso contrario, última página tendrá menos opciones. Si sólo muestra 4 opciones, 5 no es un input válido
                //por tanto comprobamos si estamos en la última página. Si no estamos, vale 1-5
                //Si estamos en la última página, valen los números del 1 al último que muestre la página
                double ultimaPagina = Math.ceil((double) jugadores.size() / tamPag)-1;
                if (opcion.equalsIgnoreCase("salir") || opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("a")){
                    return true;
                }
                int mod = jugadores.size() % tamPag; 
                if (mod==0 || this.pagActual != ultimaPagina){ // si la última página tiene tamPag elementos o no estamos en la última página
                    for (int i=1;i<=tamPag;i++){ //el for hace lo mismo que los or, pero dinámico. Permite que los válidos dependan de tamPag
                    if (opcion.equals(Integer.toString(i))){
                        return true;
                    }
                }
                    //return opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("5");
                }
                // Si estamos en la última página, y esta tiene menos de tamPag elementos
                for (int i=1;i<=mod;i++){
                    if (opcion.equals(Integer.toString(i))){
                        return true;
                    }
                }
                return false;
                
            }
            case 1 -> {
                return opcion.equals("si") || opcion.equals("no");
            }
        }
        return false;
    }

    private boolean procesarEntrada(String entrada) {
        boolean valido;
        String opcion;
        switch (entrada) {
            case "1", "2", "3", "4", "5"  -> {
                do {
                    this.modo = 1; //el modo es para que de por valido "si" y "no"
                    opcion = this.menuBan.mostrarMensaje(2); //seguro que lo quieres banear?
                    valido = validarEntrada(opcion);
                    if (!valido) {
                        this.menuBan.mostrarMensajeError(1);
                    }
                } while (!valido);
                if (opcion.equalsIgnoreCase("si")){
                    int pos = Integer.parseInt(entrada) + this.pagActual*ControladorBaneos.tamPag;
                    pos--; //para que sea el índice real
                    
                    this.jugadores.get(pos).cambiarBaneo(!mostrarBaneados); //realizamos el cambio
                    Estado.obtenerAlmacenUsuarios().guardarUsuarios();      //guardamos el cambio
                    
                    this.jugadores.remove(pos);         //actualizamos nuestra lista
                    this.menuBan.quitarJugador(pos);    //actualizamos la lista del menú
                    
                    this.menuBan.mostrarMensaje(3); // usuario baneado
                }
            }
            case "s" -> { //suma 1 a la página actual si no estamos en la última. 
                //Para saber si estamos en la última, divide el tamaño de la lista entre el tamaño de página (redondeando hacia arriba), y lo compara con la página actual
                if (this.pagActual != Math.ceil((double) jugadores.size() / tamPag)-1) {
                    this.pagActual++;
                } else {
                    this.menuBan.mostrarMensajeError(2);
                }
            }
            case "a" -> {
                if (this.pagActual != 0) {
                    this.pagActual--;
                } else {
                    this.menuBan.mostrarMensajeError(2);
                }
            }
            case "salir" -> {
                return true;
            } //end if
            } //end case 5

        return false;
    }
}
