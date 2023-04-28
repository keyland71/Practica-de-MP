package controladores;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menus.MenuInicio;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 *
 * Este controlador gestiona el inicio de la aplicación. Para la gestión de este
 * proceso contamos con las funciones de "validarEntrada" y "procesarEntrada".
 * Ambas dependen del estado interno del controlador (variable "modo"). En
 * función del modo, el controlador realizará unas acciones u otras. Los
 * distintos modos son: 0: Selección en el menú de inicio. 1: Sí / No
 */
public class ControladorInicio {

    private MenuInicio menuInicio;
    private int modo;
    private Set<String> opcionesDisponibles;

    public ControladorInicio() {
        this.menuInicio = new MenuInicio();
        this.modo = 0;
        this.opcionesDisponibles = new HashSet(Arrays.asList("1", "2", "3"));
    }

    public void iniciarControlador() {
        boolean salir = false;
        while (!salir) {
            this.modo = 0;
            String opcion = this.menuInicio.mostrarMensaje(0);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuInicio.mostrarMensajeError(0);
            }
        }
    }

    private boolean validarEntrada(String opcion) {
        if (this.modo == 0) {
            return this.opcionesDisponibles.contains(opcion);
        }
        return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
    }

    private boolean procesarEntrada(String opcion) {
        if (this.modo == 0) {
            return procesarInicio(opcion);
        }
        return opcion.equalsIgnoreCase("si");

    }

    private boolean procesarInicio(String opcion) {
        switch (opcion) {
            case "1" ->
                iniciarSesion();
            case "2" ->
                registrarse();
            default -> {
                while (true) {
                    String optSalir = this.menuInicio.mostrarMensaje(1);
                    this.modo = 1;
                    boolean valido = validarEntrada(optSalir);
                    if (valido) {
                        return procesarEntrada(optSalir);
                    } else {
                        this.menuInicio.mostrarMensajeError(0);
                    }
                }
            }
        }
        return false;
    }

    private void iniciarSesion() {
        ControladorInicioSesion controladorInicioSesion = new ControladorInicioSesion();
        controladorInicioSesion.iniciarControlador();
    }

    private void registrarse() {
        ControladorRegistro controladorRegistro = new ControladorRegistro();
        controladorRegistro.iniciarControlador();
    }

}
