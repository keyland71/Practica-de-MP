/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package baseDeDatos;

import clasesDeJuego.Arma;
import clasesDeJuego.Armadura;
import java.io.BufferedReader;
import java.io.FileReader;
import clasesDeJuego.Variante;
import java.util.List;

public class AlmacenEquipo {

    private List<Arma> armas;
    private List<Armadura> armaduras;

    public AlmacenEquipo() {
        this.cargarEquipo();

    }

    private void cargarEquipo() {
        try {
            String nombre;
            int modificadorAtaque;
            int modificadorDefensa;
            
            //Leer armas
            BufferedReader br = new BufferedReader(new FileReader("./archivos/Armas.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                String[] lineaLeida = linea.split(";");
                nombre = lineaLeida[0];
                modificadorAtaque = Integer.parseInt(lineaLeida[1]);
                modificadorDefensa = Integer.parseInt(lineaLeida[2]);
                Variante tipo = Variante.valueOf(lineaLeida[3]);
                Arma nuevaArma = new Arma(nombre, modificadorAtaque, modificadorDefensa, tipo);
                this.armas.add(nuevaArma);
            }
            br.close();

            //Leer armaduras
            br = new BufferedReader(new FileReader("./archivos/Armaduras.csv"));
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                String[] lineaLeida = linea.split(";");
                nombre = lineaLeida[0];
                modificadorAtaque = Integer.parseInt(lineaLeida[1]);
                modificadorDefensa = Integer.parseInt(lineaLeida[2]);
                Armadura nuevaArmadura = new Armadura(nombre, modificadorAtaque, modificadorDefensa);
                this.armaduras.add(nuevaArmadura);
            }
            br.close();
        }
        catch(Exception e){
            System.out.println("Problemas con lectura de archivo Armas.csv o Armaduras.csv");
        }
    }
}
