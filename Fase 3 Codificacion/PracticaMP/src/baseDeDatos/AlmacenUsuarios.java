package baseDeDatos;

import clasesDeJuego.Jugador;
import clasesDeJuego.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import practicamp.Juego;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class AlmacenUsuarios implements Serializable {

    private Map<String, Usuario> usuarios;

    public AlmacenUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public List<Jugador> obtenerJugadores() {
        List<Jugador> result = new ArrayList<>();
        try {
            for (Usuario u : usuarios.values()) {
                if (Class.forName("clasesDeJuego.Jugador").isInstance(u)) {
                    Jugador j = (Jugador) u;
                    result.add(j);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("AlmacenUsuarios.obtenerJugadores() ha dado problemas;");
            System.out.println(ex);
        }

        return result;
    }

    public Usuario obtenerUsuario(String nick) {
        return this.usuarios.get(nick);
    }

    public boolean existeUsuario(String nick) {
        return this.usuarios.containsKey(nick);
    }

    public Map<String, Usuario> obtenerUsuarios() {
        return this.usuarios;
    }

    public int obtenerNumUsuarios() {
        return this.usuarios.keySet().size();
    }

    public void aniadirUsuario(Usuario u) {
        this.usuarios.put(u.obtenerNick(), u);
        Juego.estado.guardar(); //antes llamaba a guardarUsuarios()
    }

    public void borrarUsuario(Usuario u) {
        this.usuarios.remove(u.obtenerNick());
        Juego.estado.guardar();
    }

    //inutil
    private void cargarUsuarios() {
        AlmacenUsuarios almacenLeido = null;
        try {
            String fic = "./archivos/AlmacenUsuarios.AlmacenUsuarios";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            almacenLeido = (AlmacenUsuarios) entrada.readObject();
            this.usuarios = almacenLeido.obtenerUsuarios();
            entrada.close();
        } catch (Exception e) {
            System.out.println("No se ha encontrado el almacén, así que se ha creado uno nuevo");
            System.out.println(e);
            this.usuarios = new HashMap<>();
        }
    }

    //inutil
    public void guardarUsuarios() {
        try {
            String fic = "./archivos/AlmacenUsuarios.AlmacenUsuarios";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(this);
            salida.close();
        } catch (Exception e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }
    }

    public List<Jugador> obtenerJugadoresBan(boolean mostrarBaneados) {
        List<Jugador> candidatos = this.obtenerJugadores();
        List<Jugador> result = new ArrayList<>();
        for (Jugador j:candidatos){
            if (j.estaBaneado() == mostrarBaneados){
                result.add(j);
            }
        }
        return result;
    }

    public List<Jugador> obtenerRanking(){
        List<Jugador> jugadores = this.obtenerJugadores();
        jugadores.sort((j1, j2) -> -Integer.compare(j1.obtenerVictorias(), j2.obtenerVictorias()));
        return jugadores;
    }

    public int obtenerNumJugadores() {
        return this.obtenerJugadores().size();
    }

    public boolean existeJugador(String nombre) {
        for (Jugador j:this.obtenerJugadores()){
            if (j.obtenerNick().equalsIgnoreCase(nombre))
                return true;
        }
        return false;
    }
}