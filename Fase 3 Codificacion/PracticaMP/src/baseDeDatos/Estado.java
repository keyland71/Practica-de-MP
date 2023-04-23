package baseDeDatos;

import clasesDeJuego.Jugador;
import clasesDeJuego.NumeroRegistro;
import clasesDeJuego.Personaje;
import clasesDeJuego.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    
    public Estado(){
        Estado.almacenUsuarios = new AlmacenUsuarios();
        Estado.almacenDesafios = new AlmacenDesafios();
        Estado.almacenPersonajes = new AlmacenPersonajes();
        //...
        cargarNumReg();
        this.usuarioActivo = null;
    }
    
    public static void quitarPersonajeActivo(){
        try {
            if (Class.forName("clasesDeJuego.Jugador").isInstance(Estado.usuarioActivo)){
                Jugador j = (Jugador) Estado.usuarioActivo;
                j.ponerPersonaje(null);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Estado.quitarPersonajeActivo() ha dado problemas;");
            System.out.println(ex);
        }        
    }
    
    public static void ponerUsuarioActivo(Usuario u){
        Estado.usuarioActivo = u;
    }
    
    private static void guardarNumReg(NumeroRegistro numReg){
        try {
            String fic = "./archivos/UltimoNumeroDeRegistro.NumeroRegistro";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(numReg);
            salida.close();
        } catch (Exception e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }
    } 
    private void cargarNumReg(){
        try {
            String fic = "./archivos/UltimoNumeroDeRegistro.NumeroRegistro";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            Estado.ultimoNumRegistro = (NumeroRegistro) entrada.readObject();
            entrada.close();
        } catch (Exception e) {
            System.out.println("No se ha encontrado el último numero de registro.");
            System.out.println(e);
            Estado.ultimoNumRegistro = new NumeroRegistro();
        }
    }
    
    public static void ponerNumReg(NumeroRegistro num){
        Estado.ultimoNumRegistro.copiar(num);
        guardarNumReg(num);
    }
    public static NumeroRegistro obtenerNumeroRegistro(){
        return Estado.ultimoNumRegistro;
    }
    public static Usuario obtenerUsuarioActivo() {
        return Estado.usuarioActivo;
    }
    //cuidado con esta función, podría dar problemas
    public static Personaje obtenerPersonajeActivo() {
        try {
            if (Class.forName("clasesDeJuego.Jugador").isInstance(Estado.usuarioActivo)){
                Jugador j = (Jugador) Estado.usuarioActivo;
                return j.obtenerPersonaje();
            } else{
                return null;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Estado.obtenerPersonajeActivo() ha dado problemas; ");
            System.out.println(ex);
        }
        return null;
        
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
