/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package baseDeDatos;


import clasesDeJuego.Modificador;
import clasesDeJuego.TipoModificador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class AlmacenModificadores {

    private List<Modificador> modificadores;

    public AlmacenModificadores() {
        this.cargarModificadores();

    }

    private void cargarModificadores() {
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
        }
        catch(Exception e){
            System.out.println("Problemas con lectura de archivo Modificadores.csv");
        }
    }
}