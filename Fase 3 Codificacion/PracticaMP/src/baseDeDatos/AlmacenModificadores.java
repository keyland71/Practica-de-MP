/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.Modificador;
import clasesDeJuego.TipoModificador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlmacenModificadores implements Serializable{

    private List<Modificador> modificadores;

    public AlmacenModificadores() {
        this.modificadores = new ArrayList<>();
        this.cargarModificadores();

    }
    public List<Modificador> obtenerModificadores(){
        return this.modificadores;
    }

    private void cargarModificadores(){
    File miArchivo = new File("./archivos/Modificadores.csv");
        try {
            Scanner lector = new Scanner(miArchivo);
            String nombre;
            int valor;
            TipoModificador tipo;
            
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] seccionesLinea = linea.split(";");
                
                nombre = seccionesLinea[0];
                valor = Integer.parseInt(seccionesLinea[1]);
                tipo = TipoModificador.valueOf(seccionesLinea[2]);
                
                Modificador mod = new Modificador(nombre, valor, tipo);
                this.modificadores.add(mod);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No existe el archivo Modificadores.csv.");
        }
    }
    
    private void cargarModificadoresViejo() {
        try {
            //Leer modificadores
            BufferedReader br = new BufferedReader(new FileReader("./archivos/Modificadores.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                String[] lineaLeida = linea.split(";");
                String nombre = lineaLeida[0];
                int valor = Integer.parseInt(lineaLeida[1]);
                TipoModificador tipoMod = TipoModificador.valueOf(lineaLeida[2]);
                Modificador mod = new Modificador(nombre, valor, tipoMod);
                this.modificadores.add(mod);
            }
            br.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Problemas con lectura de archivo Modificadores.csv");
        }
    }

    public List<Modificador> obtenerModificadoresEjemploVampiro() {
        Modificador fortaleza1 = this.modificadores.get(3);
        Modificador debilidad1 = this.modificadores.get(4);
        List<Modificador> modificadoresEjemplo = List.of(fortaleza1, debilidad1);
        return modificadoresEjemplo;
    }

    public List<Modificador> obtenerModificadoresEjemploLicantropo() {
        Modificador fortaleza1 = this.modificadores.get(9);
        Modificador debilidad1 = this.modificadores.get(0);
        List<Modificador> modificadoresEjemplo = List.of(fortaleza1, debilidad1);
        return modificadoresEjemplo;
    }

    public List<Modificador> obtenerModificadoresEjemploCazador() {
        Modificador fortaleza1 = this.modificadores.get(5);
        Modificador debilidad1 = this.modificadores.get(6);
        List<Modificador> modificadoresEjemplo = List.of(fortaleza1, debilidad1);
        return modificadoresEjemplo;
    }

}
