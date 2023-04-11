package controladores;

import menus.MenuInicio;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class ControladorInicio {

    private MenuInicio menuInicio;
    private int modo;

    public ControladorInicio() {
        this.menuInicio = new MenuInicio();
        this.modo = 0;
    }

    public void iniciarControlador() {
        boolean salir = false;
        while (!salir) {
            String opcion = this.menuInicio.mostrarMensaje(this.modo);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuInicio.mostrarMensajeError(this.modo);
            }
        }
    }

    private boolean validarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> {
                return opcion.equals("1") || opcion.equals("2") || opcion.equals("3");
            }
        }
        return false;
        
    }

    private boolean procesarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> {
                switch (opcion) {
                    case "1" ->
                        System.out.println("Iniciar sesión"); // Está a modo de placeholder, aún no está terminado
                    case "2" ->
                        System.out.println("Registrarse"); // Está a modo de placeholder, aún no está terminado
                    default -> {
                        System.out.println("Adiós");
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
