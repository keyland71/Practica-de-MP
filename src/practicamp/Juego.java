package practicamp;

import baseDeDatos.Estado;
import controladores.ControladorInicio;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Juego {

    public static Estado estado;

    public void run() {
        Juego.estado = new Estado();
        ControladorInicio iniControlador = new ControladorInicio();
        iniControlador.iniciarControlador();

    }

}
