package baseDeDatos;

import clasesDeJuego.NumeroRegistro;
import clasesDeJuego.Personaje;
import clasesDeJuego.Usuario;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Estado {

    private static AlmacenUsuarios almacenUsuarios;
    private static AlmacenDesafios almacenDesafios;
    private static AlmacenPersonajes almacenPersonajes;
    //...
    private static NumeroRegistro ultimoNumRegistro;
    
    private static Usuario usuarioActivo;
    private static Personaje personajeActivo;
    
    public Estado(){
        Estado.almacenUsuarios = new AlmacenUsuarios();
        Estado.almacenDesafios = new AlmacenDesafios();
        Estado.almacenPersonajes = new AlmacenPersonajes();
        //...
    }
    
    
    public static Usuario obtenerUsuarioActivo() {
        return Estado.usuarioActivo;
    }
    public static Personaje obtenerPersonajeActivo() {
        return Estado.personajeActivo;
    }
    public static AlmacenUsuarios obtenerAlmacenUsuarios() {
        return Estado.almacenUsuarios;
    }
    public static AlmacenDesafios obtenerAlmacenDesafios() {
        return Estado.almacenDesafios;
    }
    public static AlmacenPersonajes obtenerAlmacenPersonajes(){
        return Estado.almacenPersonajes;
    }
}
