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
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import sistemas.FabricaPersonajes;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class Estado implements Serializable {

    private AlmacenUsuarios almacenUsuarios;
    private AlmacenDesafios almacenDesafios;
    private AlmacenPersonajes almacenPersonajes;
    private AlmacenEquipo almacenEquipo;
    private AlmacenEsbirros almacenEsbirros;
    private AlmacenHabilidades almacenHabilidades;
    private AlmacenModificadores almacenModificadores;

    private NumeroRegistro ultimoNumRegistro;
    private FabricaPersonajes fabricaPersonajes;
    private Usuario usuarioActivo;
    private static final String UTF8_BOM = "\uFeFF";

    public Estado() {
        this.ultimoNumRegistro = new NumeroRegistro();
        cargar();
    }

    private void cargar() {
        Estado estadoLeido;
        try {
            String fic = "./archivos/Estado.Estado";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            estadoLeido = (Estado) entrada.readObject();
            this.copia(estadoLeido);
            entrada.close();
        } catch (IOException | ClassNotFoundException e) {
            this.almacenUsuarios = new AlmacenUsuarios();
            this.almacenDesafios = new AlmacenDesafios();
            this.almacenPersonajes = new AlmacenPersonajes();
            this.almacenEquipo = new AlmacenEquipo();
            this.almacenEsbirros = new AlmacenEsbirros();
            this.almacenHabilidades = new AlmacenHabilidades();
            this.almacenModificadores = new AlmacenModificadores();
            this.usuarioActivo = null;
            this.fabricaPersonajes = new FabricaPersonajes();
            inicializarFabricaPersonajes();

        }
    }

    private void copia(Estado estadoLeido) {

        this.almacenUsuarios = estadoLeido.obtenerAlmacenUsuarios();
        this.almacenDesafios = estadoLeido.obtenerAlmacenDesafios();
        this.almacenPersonajes = estadoLeido.obtenerAlmacenPersonajes();
        this.almacenEquipo = estadoLeido.obtenerAlmacenEquipo();
        this.almacenEsbirros = estadoLeido.obtenerAlmacenEsbirros();
        this.almacenHabilidades = estadoLeido.obtenerAlmacenHabilidades();
        this.almacenModificadores = estadoLeido.obtenerAlmacenModificadores();

        this.usuarioActivo = estadoLeido.obtenerUsuarioActivo();
        this.fabricaPersonajes = estadoLeido.obtenerFabricaPersonajes();
        this.ultimoNumRegistro.copiar(estadoLeido.obtenerNumeroRegistro());
    }

    public void guardar() {
        try {
            String fic = "./archivos/Estado.Estado";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(this);
            salida.close();
        } catch (IOException e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }
    }

    public void quitarPersonajeActivo() {
        try {
            if (Class.forName("clasesDeJuego.Jugador").isInstance(this.usuarioActivo)) {
                Jugador j = (Jugador) this.usuarioActivo;
                j.ponerPersonaje(null);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Estado.quitarPersonajeActivo() ha dado problemas;");
            System.out.println(ex);
        }
    }

    public void ponerUsuarioActivo(Usuario u) {
        this.usuarioActivo = u;
    }

    public void ponerNumReg(NumeroRegistro num) {
        this.ultimoNumRegistro.copiar(num);
        this.guardar();
    }

    public NumeroRegistro obtenerNumeroRegistro() {
        return this.ultimoNumRegistro;
    }

    public Usuario obtenerUsuarioActivo() {
        return this.usuarioActivo;
    }

    public Personaje obtenerPersonajeActivo() {
        try {
            if (Class.forName("clasesDeJuego.Jugador").isInstance(this.usuarioActivo)) {
                Jugador j = (Jugador) this.usuarioActivo;
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

    public AlmacenUsuarios obtenerAlmacenUsuarios() {
        return this.almacenUsuarios;
    }

    public AlmacenDesafios obtenerAlmacenDesafios() {
        return this.almacenDesafios;
    }

    public AlmacenPersonajes obtenerAlmacenPersonajes() {
        return this.almacenPersonajes;
    }

    public AlmacenEquipo obtenerAlmacenEquipo() {
        return this.almacenEquipo;
    }

    public AlmacenEsbirros obtenerAlmacenEsbirros() {
        return this.almacenEsbirros;
    }

    public AlmacenHabilidades obtenerAlmacenHabilidades() {
        return this.almacenHabilidades;
    }

    public AlmacenModificadores obtenerAlmacenModificadores() {
        return this.almacenModificadores;
    }

    public FabricaPersonajes obtenerFabricaPersonajes() {
        return this.fabricaPersonajes;
    }

    /**
     * En esta función se crean los personajes de ejemplo de la fábrica de
     * personajes, que serviran como modelo para crear otros personajes. Primero
     * se crea el vampiro de ejemplo, luego el licántropo y, por último, el
     * cazador
     */
    private void inicializarFabricaPersonajes() {

        Set<Arma> armas = this.almacenEquipo.obtenerArmasEjemploVampiro();
        Set<Armadura>armaduras = this.almacenEquipo.obtenerArmadurasEjemploVampiro();
        Set<Esbirro> esbirros = this.almacenEsbirros.obtenerEsbirrosEjemploVampiro();
        HabilidadEspecial habilidad = this.almacenHabilidades.obtenerHabilidadEjemploVampiro();
        List<Modificador> modificadores = this.almacenModificadores.obtenerModificadoresEjemploVampiro();
        this.fabricaPersonajes.crearModeloVampiro(armas, armaduras, esbirros, habilidad, modificadores);

        armas = this.almacenEquipo.obtenerArmasEjemploLicantropo();
        armaduras = this.almacenEquipo.obtenerArmadurasEjemploLicantropo();
        esbirros = this.almacenEsbirros.obtenerEsbirrosEjemploLicantropo();
        habilidad = this.almacenHabilidades.obtenerHabilidadEjemploLicantropo();
        modificadores = this.almacenModificadores.obtenerModificadoresEjemploLicantropo();
        this.fabricaPersonajes.crearModeloLicantropo(armas, armaduras, esbirros, habilidad, modificadores);

        armas = this.almacenEquipo.obtenerArmasEjemploCazador();
        armaduras = this.almacenEquipo.obtenerArmadurasEjemploCazador();
        esbirros = this.almacenEsbirros.obtenerEsbirrosEjemploCazador();
        habilidad = this.almacenHabilidades.obtenerHabilidadEjemploCazador();
        modificadores = this.almacenModificadores.obtenerModificadoresEjemploCazador();
        this.fabricaPersonajes.crearModeloCazador(armas, armaduras, esbirros, habilidad, modificadores);
    }

    /**
     * Esta función quita de una string el carácter de inicio de los archivos .csv ("\uFeFF")
     * @param s String a la que se le quita el carácter de inicio indicado
     * @return String inicial sin el carácter de inicio indicado
     */
    public static String quitarCaracterInicioCSV(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

}
