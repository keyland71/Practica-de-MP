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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AlmacenEsbirros implements Serializable{

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
        for (String nombre:nombres){
            for (Esbirro esbirro:this.esbirros){
                String n = esbirro.obtenerNombre();
                if (n.equals(nombre)){
                    esbirrosSubordinados.add(esbirro);
                    break; //los nombres son únicos. Cuando coincida uno salimos.
                }
            }
        }
    }

    private void cargarEsbirrosViejo() {
        try {
            List<Esbirro> listaEsbirros = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("./archivos/Esbirros.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) { //continua hasta encontrar una línea que sea null
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
