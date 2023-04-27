package baseDeDatos;

import clasesDeJuego.Jugador;
import clasesDeJuego.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import practicamp.Juego;

/**
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
        Juego.estado.guardar();
    }

    public void borrarUsuario(Usuario u) {
        this.usuarios.remove(u.obtenerNick());
        Juego.estado.guardar();
    }

    public List<Jugador> obtenerJugadoresBan(boolean mostrarBaneados) {
        List<Jugador> candidatos = this.obtenerJugadores();
        List<Jugador> result = new ArrayList<>();
        for (Jugador j : candidatos) {
            if (j.estaBaneado() == mostrarBaneados) {
                result.add(j);
            }
        }
        return result;
    }

    public List<Jugador> obtenerRanking() {
        List<Jugador> jugadores = this.obtenerJugadores();
        jugadores.sort((j1, j2) -> -Integer.compare(j1.obtenerVictorias(), j2.obtenerVictorias()));
        return jugadores;
    }

    public int obtenerNumJugadores() {
        return this.obtenerJugadores().size();
    }

    public boolean existeJugador(String nombre) {
        for (Jugador j : this.obtenerJugadores()) {
            if (j.obtenerNick().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
