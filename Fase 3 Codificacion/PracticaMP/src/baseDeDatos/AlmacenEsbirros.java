/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package baseDeDatos;

import clasesDeJuego.Esbirro;
import clasesDeJuego.Ghoul;
import clasesDeJuego.Humano;
import clasesDeJuego.NivelLealtad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class AlmacenEsbirros {
    
    private List<Esbirro> esbirros;
    
    private void cargarEsbirros() {
        try {
            //Leer esbirros
            List<Esbirro> listaEsbirros = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("./archivos/Esbirros.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                String[] lineaLeida = linea.split(";");
                String nombre = lineaLeida[0];
                int vida = Integer.parseInt(lineaLeida[1]);
                String tipo = lineaLeida[2];
                
                switch(tipo) {
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
                    /*case "Demonio" -> {
                        String pacto = lineaLeida[3];
                        //Bucle for que lea y cree cada esbirro dependiendo de los datos de la columna 5 de Esbirros.csv (y los añada al conjunto conjEsb)
                        //Tras haber creado el conjunto, pasarlo al constructor de Demonio, tal y como se define debajo
                        Demonio esbD = new Demonio(nombre, vida, pacto, conjEsbirros);
                        listaEsbirros.add(esbD);
                    }  */                     
                }
            }
            br.close();
            this.esbirros = listaEsbirros;
        }
        catch(Exception e){
            System.out.println("Problemas con lectura de archivo Esbirros.csv");
        }
    }
    
    

}