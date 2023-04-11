package baseDeDatos;

import clasesDeJuego.NumeroRegistro;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Estado {
    
    private AlmacenUsuarios almacenUsuarios;
    //...
    private NumeroRegistro ultimoNumRegistro;
    
    public Estado(){
        this.almacenUsuarios = new AlmacenUsuarios();
        //...
    }
}
