/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clasesDeJuego.Arma;
import clasesDeJuego.Armadura;
import clasesDeJuego.Esbirro;
import clasesDeJuego.HabilidadEspecial;
import clasesDeJuego.Modificador;
import clasesDeJuego.Personaje;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menus.MenuCamposFijos;
import menus.MenuCamposLibres;
import menus.MenuDetallePersonaje;
import practicamp.Juego;

/**
 *
 * @author Ángel Marqués
 */
public class ControladorEditarPersonaje {

    private MenuDetallePersonaje menuPj;
    private MenuCamposLibres menuLibres;
    private MenuCamposFijos menuFijos;
    private Personaje personaje;
    private List<Integer> elegidos;

    public ControladorEditarPersonaje(Personaje pj) {
        this.menuPj = new MenuDetallePersonaje(pj);
        this.menuLibres = new MenuCamposLibres();
        this.menuFijos = new MenuCamposFijos(pj);
        this.elegidos = new ArrayList<>();
        this.personaje = pj;

    }

    void iniciarControlador() {
        boolean salir = false;
        do {
            String opcion = this.menuPj.mostrarPersonaje();
            if (validarEntrada(opcion)) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuPj.mostrarMensajeError();
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        return opcion.equalsIgnoreCase("salir") || opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("5") || opcion.equals("6") || opcion.equals("7") || opcion.equals("8") || opcion.equals("9") || opcion.equals("10") || opcion.equals("11");
    }

    private boolean procesarEntrada(String entrada) {
        if (entrada.equalsIgnoreCase("salir")) {
            return true;
        }
        switch (entrada) {
            case "1" -> {
                editarCampoLibre("nombre");
            }
            case "2" -> {
                editarCampoLibre("descripcion");
            }
            case "3" -> {
                editarCampoLibre("vida");
            }
            case "4" -> {
                editarCampoLibre("poder");
            }
            case "5" -> {
                editarCampoFijo("habilidad");
            }
            case "6" -> {
                editarCampoActivo("armasActivas");
            }
            case "7" -> {
                editarCampoFijo("armasDisponibles");
            }
            case "8" -> {
                editarCampoActivo("armaduraActiva");
            }
            case "9" -> {
                editarCampoFijo("armadurasDisponibles");
            }
            case "10" -> {
                editarCampoFijo("modificadores");
            }
            case "11" -> {
                editarCampoFijo("esbirros");
            }
        }
        this.elegidos.clear();
        Juego.estado.guardar();
        return false;
    }

    private void editarCampoFijo(String campo) {
        String opcion;
        boolean salir;

        do {
            salir = false;
            opcion = this.menuFijos.mostrarMensaje(campo, obtenerValores(campo, elegidos));
            if (validarCampoFijo(campo, opcion)) {
                if ((!opcion.equalsIgnoreCase("salir") && !opcion.equalsIgnoreCase("guardar"))) {
                    this.elegidos.add(Integer.parseInt(opcion) - 1);
                } else {
                    salir = true;
                }
            } else {
                this.menuFijos.mostrarMensajeError(0);
            }
        } while ((!salir || (this.elegidos.isEmpty() && opcion.equalsIgnoreCase("guardar"))) && !(campo.equalsIgnoreCase("habilidad") && !this.elegidos.isEmpty()));
        if (opcion.equalsIgnoreCase("salir")) {
            return;
        }

        cambiarCampoFijo(campo);
    }

    private String obtenerValores(String campo, List<Integer> elegidos) {
        String valores = null;
        switch (campo) {
            case "habilidad" -> {
                List<HabilidadEspecial> habilidades = Juego.estado.obtenerAlmacenHabilidades().obtenerHabilidades(this.personaje.obtenerHabilidadEspecial().obtenerTipo());
                valores = HabilidadEspecial.fromListToString(habilidades);
            }
            case "armasDisponibles" -> {
                List<Arma> armas = new ArrayList<>(Juego.estado.obtenerAlmacenEquipo().obtenerArmas());
                for (int i : elegidos) {
                    armas.remove(i);
                }
                valores = Arma.fromListToString(armas);
            }
            case "armadurasDisponibles" -> {
                List<Armadura> armaduras = new ArrayList<>(Juego.estado.obtenerAlmacenEquipo().obtenerArmaduras());
                for (int i : elegidos) {
                    armaduras.remove(i);
                }
                valores = Armadura.fromListToString(armaduras);
            }
            case "modificadores" -> {
                List<Modificador> modificadores = new ArrayList<>(Juego.estado.obtenerAlmacenModificadores().obtenerModificadores());
                for (int i : elegidos) {
                    modificadores.remove(i);
                }
                valores = Modificador.fromListToString(modificadores);
            }
            case "esbirros" -> {
                List<Esbirro> esbirros = new ArrayList<>(Juego.estado.obtenerAlmacenEsbirros().obtenerEsbirros());
                for (int i : elegidos) {
                    esbirros.remove(i);
                }
                valores = Esbirro.fromListToString(esbirros);
            }
        }
        return valores;
    }

    private void cambiarCampoFijo(String campo) {
        switch (campo) {
            case "habilidad" -> {
                List<HabilidadEspecial> habilidades = Juego.estado.obtenerAlmacenHabilidades().obtenerHabilidades(this.personaje.obtenerHabilidadEspecial().obtenerTipo());
                this.personaje.ponerHabilidadEspecial(habilidades.get(elegidos.get(0)));
            }
            case "armasDisponibles" -> {
                List<Arma> armas = new ArrayList<>(Juego.estado.obtenerAlmacenEquipo().obtenerArmas());
                List<Arma> armasElegidas = new ArrayList<>();
                for (int i : elegidos) {
                    armasElegidas.add(armas.remove(i));
                }
                this.personaje.ponerArmasDisponibles(armasElegidas);
            }
            case "armadurasDisponibles" -> {
                List<Armadura> armaduras = new ArrayList<>(Juego.estado.obtenerAlmacenEquipo().obtenerArmaduras());
                List<Armadura> armadurasElegidas = new ArrayList<>();
                for (int i : elegidos) {
                    armadurasElegidas.add(armaduras.remove(i));
                }
                this.personaje.ponerArmadurasDisponibles(armadurasElegidas);
            }
            case "modificadores" -> {
                List<Modificador> mods = new ArrayList<>(Juego.estado.obtenerAlmacenModificadores().obtenerModificadores());
                List<Modificador> modificadoresElegidos = new ArrayList<>();
                for (int i : elegidos) {
                    modificadoresElegidos.add(mods.remove(i));
                }
                this.personaje.ponerModificadores(modificadoresElegidos);
            }
            case "esbirros" -> {
                List<Esbirro> esbirros = new ArrayList<>(Juego.estado.obtenerAlmacenEsbirros().obtenerEsbirros());
                Set<Esbirro> esbirrosElegidos = new HashSet<>();
                for (int i : elegidos) {
                    esbirrosElegidos.add(esbirros.remove(i));
                }
                this.personaje.ponerEsbirros(esbirrosElegidos);
            }
        }
    }

    private boolean validarCampoFijo(String campo, String opcion) {
        if (opcion.equalsIgnoreCase("guardar") || opcion.equalsIgnoreCase("salir")) {
            return true;
        }

        int tam = 0;
        switch (campo) {
            case "habilidad" ->
                tam = Juego.estado.obtenerAlmacenHabilidades().obtenerHabilidades(this.personaje.obtenerHabilidadEspecial().obtenerTipo()).size();
            case "armasDisponibles" ->
                tam = Juego.estado.obtenerAlmacenEquipo().obtenerArmas().size();
            case "armadurasDisponibles" ->
                tam = Juego.estado.obtenerAlmacenEquipo().obtenerArmaduras().size();
            case "modificadores" ->
                tam = Juego.estado.obtenerAlmacenModificadores().obtenerModificadores().size();
            case "esbirros" ->
                tam = Juego.estado.obtenerAlmacenEsbirros().obtenerEsbirros().size();
            default -> {
                return false;
            }
        }

        tam -= elegidos.size();
        try {
            int op = Integer.parseInt(opcion);
            return op <= tam && op > 0;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private void editarCampoLibre(String campo) {
        String opcion;
        boolean valido;
        do {
            opcion = this.menuLibres.mostrarMensaje(campo);
            valido = validarCampoLibre(campo, opcion);
            if (!valido) {
                this.menuLibres.mostrarMensajeError(0);
            }
        } while (!valido);
        if (opcion.equalsIgnoreCase("salir")) {
            return;
        }

        switch (campo) {
            case "nombre" -> {
                this.personaje.ponerNombre(opcion);
            }
            case "descripcion" -> {
                this.personaje.ponerDescripcion(opcion);
            }
            case "vida" -> {
                this.personaje.ponerVida(Integer.parseInt(opcion));
            }
            case "poder" -> {
                this.personaje.ponerPoder(Integer.parseInt(opcion));
            }
        }
    }

    private boolean validarCampoLibre(String campo, String opcion) {
        boolean result = false;
        switch (campo) {
            case "nombre" -> {
                return !Juego.estado.obtenerAlmacenPersonajes().existePersonaje(opcion);
            }
            case "descripcion" -> {
                return true;
            }
            case "vida", "poder" -> {
                return opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("5");
            }
        }

        return result;
    }

    private void editarCampoActivo(String armaOarmadura) {
        ControladorCambiarEquipoActivo c = new ControladorCambiarEquipoActivo(this.personaje);
        if (armaOarmadura.equals("armasActivas")) {
            c.elegirArma();
        } else {
            c.elegirArmadura();
        }
    }

}
