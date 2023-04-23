package baseDeDatos;

import clasesDeJuego.Arma;
import clasesDeJuego.Armadura;
import clasesDeJuego.Esbirro;
import clasesDeJuego.HabilidadEspecial;
import clasesDeJuego.Jugador;
import clasesDeJuego.Modificador;
import clasesDeJuego.NumeroRegistro;
import clasesDeJuego.Personaje;
import clasesDeJuego.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Set;
import sistemas.FabricaPersonajes;

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
    private static AlmacenEquipo almacenEquipo;
    private static AlmacenEsbirros almacenEsbirros;
    private static AlmacenHabilidades almacenHabilidades;
    private static AlmacenModificadores almacenModificadores;
    private static NumeroRegistro ultimoNumRegistro;
    private static FabricaPersonajes fabricaPersonajes;

    private static Usuario usuarioActivo;

    public Estado() {
        Estado.almacenUsuarios = new AlmacenUsuarios();
        Estado.almacenDesafios = new AlmacenDesafios();
        Estado.almacenPersonajes = new AlmacenPersonajes();
        Estado.almacenEquipo = new AlmacenEquipo();
        Estado.almacenEsbirros = new AlmacenEsbirros();
        Estado.almacenHabilidades = new AlmacenHabilidades();
        Estado.almacenModificadores = new AlmacenModificadores();
        cargarNumReg();
        Estado.usuarioActivo = null;
        inicializarFabricaPersonajes();
    }

    public static void quitarPersonajeActivo() {
        try {
            if (Class.forName("clasesDeJuego.Jugador").isInstance(Estado.usuarioActivo)) {
                Jugador j = (Jugador) Estado.usuarioActivo;
                j.ponerPersonaje(null);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Estado.quitarPersonajeActivo() ha dado problemas;");
            System.out.println(ex);
        }
    }

    public static void ponerUsuarioActivo(Usuario u) {
        Estado.usuarioActivo = u;
    }

    private static void guardarNumReg(NumeroRegistro numReg) {
        try {
            String fic = "./archivos/UltimoNumeroDeRegistro.NumeroRegistro";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(numReg);
            salida.close();
        } catch (IOException e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }
    }

    private void cargarNumReg() {
        try {
            String fic = "./archivos/UltimoNumeroDeRegistro.NumeroRegistro";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            Estado.ultimoNumRegistro = (NumeroRegistro) entrada.readObject();
            entrada.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha encontrado el último numero de registro.");
            System.out.println(e);
            Estado.ultimoNumRegistro = new NumeroRegistro();
        }
    }

    public static void ponerNumReg(NumeroRegistro num) {
        Estado.ultimoNumRegistro.copiar(num);
        guardarNumReg(num);
    }

    public static NumeroRegistro obtenerNumeroRegistro() {
        return Estado.ultimoNumRegistro;
    }

    public static Usuario obtenerUsuarioActivo() {
        return Estado.usuarioActivo;
    }

    //cuidado con esta función, podría dar problemas
    public static Personaje obtenerPersonajeActivo() {
        try {
            if (Class.forName("clasesDeJuego.Jugador").isInstance(Estado.usuarioActivo)) {
                Jugador j = (Jugador) Estado.usuarioActivo;
                return j.obtenerPersonaje();
            } else {
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

    public static AlmacenPersonajes obtenerAlmacenPersonajes() {
        return Estado.almacenPersonajes;
    }

    public static AlmacenEquipo obtenerAlmacenEquipo() {
        return Estado.almacenEquipo;
    }

    public static AlmacenEsbirros obtenerAlmacenEsbirros() {
        return Estado.almacenEsbirros;
    }

    public static AlmacenHabilidades obtenerAlmacenHabilidades() {
        return Estado.almacenHabilidades;
    }

    public static AlmacenModificadores obtenerAlmacenModificadores() {
        return Estado.almacenModificadores;
    }

    private void inicializarFabricaPersonajes() {
        Set<Arma> armas = Estado.almacenEquipo.obtenerArmasEjemploVampiro();
        Set<Armadura> armaduras = Estado.almacenEquipo.obtenerArmadurasEjemploVampiro();
        Set<Esbirro> esbirros = Estado.almacenEsbirros.obtenerEsbirrosEjemploVampiro();
        HabilidadEspecial habilidad = Estado.almacenHabilidades.obtenerHabilidadEjemploVampiro();
        List<Modificador> modificadores = Estado.almacenModificadores.obtenerModificadoresEjemploVampiro();
        Estado.fabricaPersonajes.crearModeloVampiro(armas, armaduras, esbirros, habilidad, modificadores);
        armas = Estado.almacenEquipo.obtenerArmasEjemploLicantropo();
        armaduras = Estado.almacenEquipo.obtenerArmadurasEjemploLicantropo();
        esbirros = Estado.almacenEsbirros.obtenerEsbirrosEjemploLicantropo();
        habilidad = Estado.almacenHabilidades.obtenerHabilidadEjemploLicantropo();
        modificadores = Estado.almacenModificadores.obtenerModificadoresEjemploLicantropo();
        Estado.fabricaPersonajes.crearModeloLicantropo(armas, armaduras, esbirros, habilidad, modificadores);
        armas = Estado.almacenEquipo.obtenerArmasEjemploCazador();
        armaduras = Estado.almacenEquipo.obtenerArmadurasEjemploCazador();
        esbirros = Estado.almacenEsbirros.obtenerEsbirrosEjemploCazador();
        habilidad = Estado.almacenHabilidades.obtenerHabilidadEjemploCazador();
        modificadores = Estado.almacenModificadores.obtenerModificadoresEjemploCazador();
        Estado.fabricaPersonajes.crearModeloCazador(armas, armaduras, esbirros, habilidad, modificadores);
    }
}
