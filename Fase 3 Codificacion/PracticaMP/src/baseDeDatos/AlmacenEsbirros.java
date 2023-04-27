/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Demonio;
import clasesDeJuego.Esbirro;
import clasesDeJuego.Ghoul;
import clasesDeJuego.Humano;
import clasesDeJuego.NivelLealtad;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AlmacenEsbirros implements Serializable {

    private List<Esbirro> esbirros;

    public AlmacenEsbirros() {
        this.esbirros = new ArrayList<>();
        this.cargarEsbirros();
    }

    private void cargarEsbirros() {
        File miArchivo = new File("./archivos/Esbirros.csv");
        try {
            Scanner lector = new Scanner(miArchivo);
            String nombre;
            String tipo;
            int vida;
            this.esbirros = new ArrayList<>();

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                linea = Estado.quitarCaracterInicioCSV(linea);
                String[] seccionesLinea = linea.split(";");

                nombre = seccionesLinea[0];
                vida = Integer.parseInt(seccionesLinea[1]);
                tipo = seccionesLinea[2];

                switch (tipo) {
                    case "Humano" -> {
                        NivelLealtad lealtad = NivelLealtad.valueOf(seccionesLinea[3]);
                        Humano esbH = new Humano(nombre, vida, lealtad);
                        this.esbirros.add(esbH);
                    }
                    case "Ghoul" -> {
                        int dependencia = Integer.parseInt(seccionesLinea[3]);
                        Ghoul esbG = new Ghoul(nombre, vida, dependencia);
                        this.esbirros.add(esbG);
                    }
                    case "Demonio" -> {
                        String pacto = seccionesLinea[3];
                        String[] nombres = seccionesLinea[4].split(",");
                        Set<Esbirro> esbirrosSubordinados = new HashSet<>();
                        obtenerEsbirrosDemonio(nombres, esbirrosSubordinados);
                        Demonio esbD = new Demonio(nombre, vida, pacto, esbirrosSubordinados);
                        this.esbirros.add(esbD);
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No existe el archivo Esbirros.csv.");
        }
    }

    private void obtenerEsbirrosDemonio(String[] nombres, Set<Esbirro> esbirrosSubordinados) {
        for (String nombre : nombres) {
            for (Esbirro esbirro : this.esbirros) {
                String n = esbirro.obtenerNombre();
                if (n.equals(nombre)) {
                    esbirrosSubordinados.add(esbirro);
                    break; //los nombres son únicos. Cuando coincida uno salimos.
                }
            }
        }
    }

    public List<Esbirro> obtenerEsbirros() {
        return this.esbirros;
    }

    public Set<Esbirro> obtenerEsbirrosEjemploVampiro() {
        Esbirro esbirro1 = this.esbirros.get(1);
        Esbirro esbirro2 = this.esbirros.get(4);
        Set<Esbirro> esbirrosEjemplo = Set.of(esbirro1, esbirro2);
        return esbirrosEjemplo;
    }

    public Set<Esbirro> obtenerEsbirrosEjemploLicantropo() {
        Esbirro esbirro1 = this.esbirros.get(0);
        Esbirro esbirro2 = this.esbirros.get(5);
        Set<Esbirro> esbirrosEjemplo = Set.of(esbirro1, esbirro2);
        return esbirrosEjemplo;
    }

    public Set<Esbirro> obtenerEsbirrosEjemploCazador() {
        Esbirro esbirro1 = this.esbirros.get(3);
        Set<Esbirro> esbirrosEjemplo = Set.of(esbirro1);
        return esbirrosEjemplo;
    }

}
