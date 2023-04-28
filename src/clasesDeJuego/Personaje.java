
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public abstract class Personaje implements Serializable {

    private String nombre;
    private String descripcion;
    private int vida;
    private int poder;
    private HabilidadEspecial habilidadEspecial;
    private List<Arma> armasActivas = new ArrayList<>();
    private Set<Arma> armasDisponibles = new HashSet<>();
    private Armadura armaduraActiva;
    private Set<Armadura> armadurasDisponibles = new HashSet<>();
    private List<Modificador> modificadores;
    private Set<Esbirro> esbirros;
    private int oro = 100;
    private int puntosRecurso = 0;
    private int sumaRecurso;
    private int maxRecurso;

    public Personaje(HabilidadEspecial hab, Set<Arma> armas, Set<Armadura> armaduras, Set<Esbirro> esbirros, int vida, int poder, List<Modificador> mods, String desc, int puntosRec, int sumaRec, int maxRec) {
        this.nombre = "Modelo Personaje";
        ponerHabilidadEspecial(hab);
        this.armasDisponibles.addAll(armas);
        this.armadurasDisponibles.addAll(armaduras);
        ponerEsbirros(esbirros);
        this.vida = vida;
        this.poder = poder;
        this.modificadores = mods;
        this.descripcion = desc;
        this.puntosRecurso = puntosRec;
        this.armasActivas.add((Arma) armas.toArray()[0]);
        this.armaduraActiva = ((Armadura) armaduras.toArray()[0]);
        this.sumaRecurso = sumaRec;
        this.maxRecurso = maxRec;
    }

    public Personaje(String nombre, Personaje personajeModelo) {
        this.nombre = nombre;
        this.habilidadEspecial = personajeModelo.obtenerHabilidadEspecial();
        for (Arma arma : personajeModelo.obtenerArmasDisponibles()) {
            this.armasDisponibles.add(arma);
        }
        for (Armadura armadura : personajeModelo.obtenerArmadurasDisponibles()) {
            this.armadurasDisponibles.add(armadura);
        }
        this.esbirros = new HashSet<>();
        for (Esbirro esbirro : personajeModelo.obtenerEsbirros()) {
            this.esbirros.add(esbirro);
        }
        this.vida = personajeModelo.obtenerVida();
        this.poder = personajeModelo.obtenerPoder();
        this.modificadores = new ArrayList<>();
        for (Modificador mod : personajeModelo.obtenerModificadores()) {
            this.modificadores.add(mod);
        }
        this.descripcion = personajeModelo.obtenerDescripcion();

        this.armasActivas.add((Arma) this.armasDisponibles.toArray()[0]);
        this.armaduraActiva = ((Armadura) this.armadurasDisponibles.toArray()[0]);
        this.sumaRecurso = personajeModelo.obtenerSumaRecurso();
        this.maxRecurso = personajeModelo.obtenerMaxRecurso();

    }

    public List<Arma> obtenerArmasActivas() {
        return this.armasActivas;
    }

    public Armadura obtenerArmaduraActiva() {
        return this.armaduraActiva;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public String obtenerDescripcion() {
        return this.descripcion;
    }

    public List<Modificador> obtenerModificadores() {
        return this.modificadores;
    }

    public List<Modificador> obtenerFortalezas() {
        List<Modificador> fortalezas = new ArrayList<>();
        for (Modificador fortaleza : this.modificadores) {
            if (fortaleza.obtenerTipo() == TipoModificador.Fortaleza) {
                fortalezas.add(fortaleza);
            }
        }
        return fortalezas;
    }

    public List<Modificador> obtenerDebilidades() {
        List<Modificador> debilidades = new ArrayList<>();
        for (Modificador debilidad : this.modificadores) {
            if (debilidad.obtenerTipo() == TipoModificador.Debilidad) {
                debilidades.add(debilidad);
            }
        }
        return debilidades;
    }

    public int obtenerVida() {
        return this.vida;
    }

    public int obtenerPoder() {
        return this.poder;
    }

    public Set<Esbirro> obtenerEsbirros() {
        return this.esbirros;
    }

    public Set<Arma> obtenerArmasDisponibles() {
        return this.armasDisponibles;
    }

    public Set<Armadura> obtenerArmadurasDisponibles() {
        return this.armadurasDisponibles;
    }

    public HabilidadEspecial obtenerHabilidadEspecial() {
        return this.habilidadEspecial;
    }

    public int obtenerRecurso() {
        return this.puntosRecurso;
    }

    public int obtenerAtaqueArmadura() {
        return this.armaduraActiva.obtenerAtaque();
    }

    public int obtenerDefensaArmadura() {
        return this.armaduraActiva.obtenerDefensa();
    }

    public int obtenerAtaqueArmas() {
        int ataqueTotal = 0;
        for (Arma arma : this.armasActivas) {
            ataqueTotal += arma.obtenerAtaque();
        }
        return ataqueTotal;
    }

    public int obtenerDefensaArmas() {
        int defensaTotal = 0;
        for (Arma arma : this.armasActivas) {
            defensaTotal = arma.obtenerDefensa();
        }
        return defensaTotal;
    }

    public int obtenerOro() {
        return this.oro;
    }

    public int obtenerSumaRecurso() {
        return this.sumaRecurso;
    }

    public int obtenerMaxRecurso() {
        return this.maxRecurso;
    }

    public void ponerPuntosRecurso(int recurso) {
        this.puntosRecurso = recurso;
    }

    public void ponerArmasActivas(Collection<Arma> armas) {
        this.armasActivas.clear();
        this.armasActivas.addAll(armas);
    }

    public void ponerArmaduraActiva(Armadura armadura) {
        this.armaduraActiva = armadura;
    }

    public void ponerEsbirros(Set<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public void ponerHabilidadEspecial(HabilidadEspecial hab) {
        this.habilidadEspecial = hab;
    }

    /**
     * Suma la cantidad de oro pasada como parámetro al personaje sobre quien se
     * llame, y devuelve la cantidad de oro que se le haya quitado/sumado al
     * usuario (siempre devuelve un número positivo)
     *
     * @param i
     * @return
     */
    public int sumarOro(int i) {
        if (this.oro + i >= 0) {
            this.oro += i;
        } else {
            i = this.oro;
            this.oro = 0;
        }
        return (i > 0 ? i : -i);
    }

    public void sumarRecurso(int recurso) {
        this.puntosRecurso += recurso;

    }

    private int calcularEfectoModificadores() {
        int result = 0;
        for (Modificador m : this.modificadores) {
            if (m.obtenerEstaActivo()) {
                result += m.obtenerValor();
            }
        }
        return result;
    }

    public int calcularPotencialAtaque() {
        int promedioModificadores = calcularEfectoModificadores();

        int potencialAtaque = this.obtenerPoder() + this.obtenerAtaqueArmas() + this.obtenerAtaqueArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialAtaque += this.obtenerHabilidadEspecial().obtenerAtaque();
        }
        return potencialAtaque;
    }

    public int calcularPotencialDefensa() {
        int promedioModificadores = calcularEfectoModificadores();

        int potencialDefensa = this.obtenerDefensaArmas() + this.obtenerDefensaArmadura() + promedioModificadores;
        if (this.puedeUsarHabilidad()) {
            potencialDefensa += this.obtenerHabilidadEspecial().obtenerDefensa();

        }
        return potencialDefensa;
    }

    public int calcularVida() {
        int vidaTotal = this.vida;
        for (Esbirro esbirro : this.esbirros) {
            vidaTotal += esbirro.obtenerVida();
        }
        return vidaTotal;
    }

    public boolean puedeUsarHabilidad() {
        return this.puntosRecurso >= this.habilidadEspecial.obtenerCoste();
    }

    /**
     * Este metodo sera reimplementado en las clases hijas. Por defecto no se
     * realiza ninguna acción
     */
    public void usarHabilidad() {
    }

    public abstract void modificarRecurso();

    /**
     * Este metodo sera reimplementado en las clases hijas. Por defecto no se
     * realiza ninguna acción
     */
    public void recibirDanio() {
    }

    /**
     * Este metodo sera reimplementado en las clases hijas. Por defecto no se
     * realiza ninguna acción
     */
    public void hacerDanio() {
    }

    public void reestablecerPersonaje() {
        this.puntosRecurso = 0;
    }

    public void ponerNombre(String n) {
        this.nombre = n;
    }

    public void ponerDescripcion(String d) {
        this.descripcion = d;
    }

    public void ponerVida(int v) {
        this.vida = v;
    }

    public void ponerPoder(int p) {
        this.poder = p;
    }

    public void ponerArmasDisponibles(List<Arma> armas) {
        this.armasDisponibles.clear();
        this.armasDisponibles.addAll(armas);
        this.armasActivas.clear();
        this.armasActivas.add(armas.get(0));
    }

    public void ponerArmadurasDisponibles(List<Armadura> armaduras) {
        this.armadurasDisponibles.clear();
        this.armadurasDisponibles.addAll(armaduras);
        this.armaduraActiva = armaduras.get(0);
    }

    public void ponerModificadores(List<Modificador> mods) {
        this.modificadores.clear();
        this.modificadores.addAll(mods);
    }

    @Override
    public String toString() {
        List<Equipo> aAc = new ArrayList<>(armasActivas);
        List<Equipo> aDisp = new ArrayList<>(armasDisponibles);
        List<Equipo> adDisp = new ArrayList<>(armadurasDisponibles);

        String result = "1. Nombre: " + nombre + "\n"
                + "2. Descripcion: " + descripcion + "\n"
                + "3. Vida: " + Integer.toString(vida) + "\n"
                + "4. Poder: " + Integer.toString(poder) + "\n"
                + "5. Habilidad: " + habilidadEspecial.obtenerNombre() + "\n"
                + "6. Armas Activas: " + eqToString(aAc) + "\n"
                + "7. Armas Disponibles" + "\n    " + eqToString(aDisp) + "\n"
                + "8. Armadura Activa: " + armaduraActiva.obtenerNombre() + "\n"
                + "9. Armaduras Disponibles: " + "\n    " + eqToString(adDisp) + "\n"
                + "10. Modificadores: " + modToString(this.modificadores) + "\n"
                + "11. Esbirros: " + esbToString(this.esbirros) + "\n";
        return result;
    }

    private String eqToString(List<Equipo> e) {
        String result = null;
        for (Equipo eq : e) {
            if (result == null) {
                result = eq.obtenerNombre();
            } else {
                result += ", " + eq.obtenerNombre();
            }
        }
        return result;
    }

    private String modToString(List<Modificador> m) {
        String result = null;
        for (Modificador mod : m) {
            if (result == null) {
                result = mod.obtenerNombre() + (mod.obtenerTipo() == TipoModificador.Fortaleza ? "(F)" : "(D)");
            } else {
                result += ", " + mod.obtenerNombre() + (mod.obtenerTipo() == TipoModificador.Fortaleza ? "(F)" : "(D)");
            }
        }
        return result;
    }

    private String esbToString(Set<Esbirro> esbirros) {
        String result = null;
        for (Esbirro esb : esbirros) {
            if (result == null) {
                result = esb.obtenerNombre();
            } else {
                result += ", " + esb.obtenerNombre();
            }
        }
        return result;
    }

}
