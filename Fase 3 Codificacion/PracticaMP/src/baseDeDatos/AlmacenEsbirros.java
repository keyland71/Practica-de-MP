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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlmacenEsbirros {

    private List<Esbirro> esbirros;

    private void cargarEsbirros() {
        try {
            List<Esbirro> listaEsbirros = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("./archivos/Esbirros.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                String[] lineaLeida = linea.split(";");
                String nombre = lineaLeida[0];
                int vida = Integer.parseInt(lineaLeida[1]);
                String tipo = lineaLeida[2];

                switch (tipo) {
                    case "Humano" -> {
                        NivelLealtad lealtad = NivelLealtad.valueOf(lineaLeida[3]);
                        Humano esbH = new Humano(nombre, vida, lealtad);
                        listaEsbirros.add(esbH);
                    }
                    case "Ghoul" -> {
                        String dep = lineaLeida[3];
                        int dependencia = Integer.parseInt(dep);
                        Ghoul esbG = new Ghoul(nombre, vida, dependencia);
                        listaEsbirros.add(esbG);
                    }
                    case "Demonio" -> {
                        String pacto = lineaLeida[3];
                        String[] listaNomEsbirros = lineaLeida[4].split(",");
                        List<Esbirro> listaEsbActuales = this.obtenerEsbirros();
                        Set<Esbirro> listaEsbDemonio = new HashSet<>();
                        for (int i = 0; i < listaNomEsbirros.length; i++) {
                            for (int j = 0; j < listaEsbActuales.size(); j++) {
                                if (listaNomEsbirros[i].equals(listaEsbActuales.get(j).obtenerNombre())) {
                                    listaEsbDemonio.add(listaEsbActuales.get(j));
                                }
                            }
                        }
                        /*Como se ha contemplado que pueda haber más de un esbirro con el mismo nombre, hay que buscar en las listas completas (no se puede parar cuando encuentre un esbirro con el mismo nombre)
                          Otra opción para ahorrar la búsqueda en ambas listas sería ordenar las listas de esbirros por el nombre*/
                        Demonio esbD = new Demonio(nombre, vida, pacto, listaEsbDemonio);
                        listaEsbirros.add(esbD);
                    }
                }
            }
            br.close();
            this.esbirros = listaEsbirros;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Problemas con lectura de archivo Esbirros.csv");
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
