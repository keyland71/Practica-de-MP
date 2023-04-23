/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import clasesDeJuego.HabilidadEspecial;
import clasesDeJuego.TipoHabilidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlmacenHabilidades implements Serializable{

    private List<HabilidadEspecial> habilidades;

    public AlmacenHabilidades() {
        this.habilidades = new ArrayList<>();
        this.cargarHabilidades();

    }

    private void cargarHabilidades(){
        File miArchivo = new File("./archivos/HabilidadesEspeciales.csv");
        try {
            Scanner lector = new Scanner(miArchivo);
            String nombre;
            TipoHabilidad tipo;
            int ataque;
            int defensa;
            int coste;
            
            
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] seccionesLinea = linea.split(";");
                
                nombre = seccionesLinea[0];
                tipo = TipoHabilidad.valueOf(seccionesLinea[1]);
                ataque = Integer.parseInt(seccionesLinea[2]);
                defensa = Integer.parseInt(seccionesLinea[3]);
                coste = Integer.parseInt(seccionesLinea[4]);
                
                HabilidadEspecial hab = new HabilidadEspecial(nombre, ataque, defensa, coste, tipo);
                this.habilidades.add(hab);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No existe el archivo HabilidadesEspeciales.csv.");
        }
    }
    
    private void cargarHabilidadesViejo() {
        try {
            //Leer habilidades
            BufferedReader br = new BufferedReader(new FileReader("./archivos/HabilidadesEspeciales.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                String[] lineaLeida = linea.split(";");
                
                String nombre = lineaLeida[0];
                TipoHabilidad tipoHab = TipoHabilidad.valueOf(lineaLeida[1]);
                int valorAtaque = Integer.parseInt(lineaLeida[2]);
                int valorDefensa = Integer.parseInt(lineaLeida[3]);
                int coste = Integer.parseInt(lineaLeida[4]);
                HabilidadEspecial hab = new HabilidadEspecial(nombre, valorAtaque, valorDefensa, coste, tipoHab);
                this.habilidades.add(hab);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Problemas con lectura de archivo HabilidadesEspeciales.csv");
        }
    }

    public List<HabilidadEspecial> obtenerDisciplinas() {
        List<HabilidadEspecial> disc = new ArrayList<>();
        for (int i = 0; i <= this.habilidades.size() - 1; i++) {
            if (this.habilidades.get(i).obtenerTipo() == TipoHabilidad.Disciplina) {
                disc.add(this.habilidades.get(i));
            }
        }
        return disc;
    }

    public List<HabilidadEspecial> obtenerDones() {
        List<HabilidadEspecial> dones = new ArrayList<>();
        for (int i = 0; i <= this.habilidades.size() - 1; i++) {
            if (this.habilidades.get(i).obtenerTipo() == TipoHabilidad.Don) {
                dones.add(this.habilidades.get(i));
            }
        }
        return dones;
    }

    public List<HabilidadEspecial> obtenerTalentos() {
        List<HabilidadEspecial> talentos = new ArrayList<>();
        for (int i = 0; i <= this.habilidades.size() - 1; i++) {
            if (this.habilidades.get(i).obtenerTipo() == TipoHabilidad.Talento) {
                talentos.add(this.habilidades.get(i));
            }
        }
        return talentos;
    }

    public HabilidadEspecial obtenerHabilidadEjemploVampiro() {
        return this.habilidades.get(1);
    }

    public HabilidadEspecial obtenerHabilidadEjemploLicantropo() {
        return this.habilidades.get(3);
    }

    public HabilidadEspecial obtenerHabilidadEjemploCazador() {
        return this.habilidades.get(4);
    }

}
