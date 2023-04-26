/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clasesDeJuego.Arma;
import clasesDeJuego.Armadura;
import clasesDeJuego.Personaje;
import clasesDeJuego.Variante;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menus.MenuCambiarEquipoActivo;
import menus.MenuVistaArmaduras;
import menus.MenuVistaArmas;
import practicamp.Juego;

/**
 *
 * @author Ángel Marqués
 */
//Muestra al usuario las armas y armadura activas. Se le pregunta al usuario qué quiere cambiar.
//Si quiere cambiar las armas, se le muestra una lista con las armas disponibles.
//Ídem para las armaduras.
public class ControladorCambiarEquipoActivo {

    private int modo;
    private MenuCambiarEquipoActivo menuCambiarEquipo;
    private MenuVistaArmaduras menuArmaduras;
    private MenuVistaArmas menuArmas;
    private Personaje personaje;
    private List<Integer> armasElegidas;
    private final List<Arma> armasDisponibles = new ArrayList<>();
    private final List<Armadura> armadurasDisponibles = new ArrayList<>();

    public ControladorCambiarEquipoActivo(Personaje p) {
        this.menuCambiarEquipo = new MenuCambiarEquipoActivo();
        this.menuArmaduras = new MenuVistaArmaduras();
        this.menuArmas = new MenuVistaArmas();
        this.armasElegidas = new ArrayList<>();
        this.personaje = p;
        this.armasDisponibles.addAll(p.obtenerArmasDisponibles());
        this.armadurasDisponibles.addAll(p.obtenerArmadurasDisponibles());

        this.modo = 0;
    }

    public void iniciarControlador() {
        boolean salir = false;
        do {
            this.modo = 0;
            String opcion = this.menuCambiarEquipo.mostrarEquipoActivo(personaje.obtenerArmasActivas(), personaje.obtenerArmaduraActiva());
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
                this.modo++;
            } else {
                this.menuCambiarEquipo.mostrarMensajeError(0);
            }
        } while (!salir);
    }

    private boolean validarEntrada(String opcion) {
        if (opcion.equalsIgnoreCase("salir")) {
            return true;
        }
        try {
        switch (this.modo) {
            case 0 -> {
                return opcion.equals("1") || opcion.equals("2");
            }
            case 1 -> {
                return Integer.parseInt(opcion) <= this.armasDisponibles.size() && (armasElegidas.isEmpty() || armasElegidas.size() == 1 && this.armasDisponibles.get(Integer.parseInt(opcion)-1).obtenerVariante() == Variante.unaMano);
            }
            case 2 -> {
                return Integer.parseInt(opcion) <= personaje.obtenerArmadurasDisponibles().size();
            }
            case 3 -> {
                return opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no");
            }
        }
        } catch (NumberFormatException e){
            //necesario para poder hacer Integer.parseInt(opcion) sin preocuparse de si opcion representa un numero
        }
        return false;
    }

    private boolean procesarEntrada(String entrada) {
        if (entrada.equalsIgnoreCase("salir")) {
            return true;
        }
        if (entrada.equals("1")) {
            elegirArma();
        } else {
            elegirArmadura();
        }
        return false;
    }

    public void elegirArma() {
        this.modo = 1;
        boolean salir = false;
        String opcion;

        do {
            opcion = this.menuArmas.mostrarArmas(this.armasDisponibles);

            if (opcion.equalsIgnoreCase("salir")) {
                this.armasElegidas.clear();
                return;
            }

            if (validarEntrada(opcion)) {
                int op = Integer.parseInt(opcion) - 1;
                this.armasElegidas.add(op); //se podría añadir directamente el Arma en vez de su índice. Así, cambiarArmas no necesita buscar el arma.
                salir = (this.armasDisponibles.get(op).obtenerVariante() == Variante.dosManos || this.armasElegidas.size() == 2);
            } else {
                this.menuArmas.mostrarMensajeError(0);
            }
        } while (!salir);

        this.modo = 3;
        do {
            opcion = this.menuArmas.mostrarMensaje(0);
            if (validarEntrada(opcion)) {
                salir = true;
                if (opcion.equalsIgnoreCase("si")) {
                    cambiarArmas();
                }
                this.armasElegidas.clear();
            } else {
                this.menuArmas.mostrarMensajeError(0);
            }
        } while (!salir);
    }

    private void cambiarArmas() {
        List<Arma> armas = new ArrayList<>();
        
        Arma arma1 = this.armasDisponibles.get(this.armasElegidas.get(0));
        armas.add(arma1);
        if (this.armasElegidas.size() == 2) {
            Arma arma2 = this.armasDisponibles.get(this.armasElegidas.get(1));
            armas.add(arma2);
        }
        personaje.ponerArmasActivas(armas);
        Juego.estado.guardar();
    }

    public void elegirArmadura() {
        this.modo = 2;
        String opcion;
        int armaduraElegida;
        boolean valido;

        do {
            opcion = this.menuArmaduras.mostrarArmaduras(this.armadurasDisponibles);

            if (opcion.equalsIgnoreCase("salir")) {
                return;
            }
            valido = validarEntrada(opcion);
            if (!valido) {
                this.menuArmaduras.mostrarMensajeError(0); //input inválido
            }
        } while (!valido);
        armaduraElegida = Integer.parseInt(opcion) - 1;

        this.modo = 3;
        do {
            opcion = this.menuArmaduras.mostrarMensaje(0); //seguro que quieres cambiar tu armadura?
            valido = validarEntrada(opcion);
            if (valido) {
                if (opcion.equalsIgnoreCase("si")) {
                    Armadura armadura = this.armadurasDisponibles.get(armaduraElegida);
                    this.personaje.ponerArmaduraActiva(armadura);
                    Juego.estado.guardar();
                }
            } else {
                this.menuArmas.mostrarMensajeError(1);
            }
        } while (!valido);
    }

}
