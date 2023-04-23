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
import java.io.IOException;
import java.util.List;
import java.util.Set;

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
        } catch (IOException | NumberFormatException e) {
            System.out.println("Problemas con lectura de archivo Armas.csv o Armaduras.csv");
        }
    }

    public List<Arma> obtenerArmas() {
        return this.armas;
    }

    public List<Armadura> obtenerArmaduras() {
        return this.armaduras;
    }

    public Set<Arma> obtenerArmasEjemploVampiro() {
        Arma arma1 = this.armas.get(0);
        Arma arma2 = this.armas.get(1);
        Arma arma3 = this.armas.get(15);
        Set<Arma> armasEjemploVampiro = Set.of(arma1, arma2, arma3);
        return armasEjemploVampiro;
    }

    public Set<Arma> obtenerArmasEjemploLicantropo() {
        Arma arma1 = this.armas.get(3);
        Arma arma2 = this.armas.get(5);
        Arma arma3 = this.armas.get(11);
        Set<Arma> armasEjemplo = Set.of(arma1, arma2, arma3);
        return armasEjemplo;
    }

    public Set<Arma> obtenerArmasEjemploCazador() {
        Arma arma1 = this.armas.get(2);
        Arma arma2 = this.armas.get(4);
        Arma arma3 = this.armas.get(10);
        Set<Arma> armasEjemplo = Set.of(arma1, arma2, arma3);
        return armasEjemplo;
    }

    public Set<Armadura> obtenerArmadurasEjemploVampiro() {
        Armadura armadura1 = this.armaduras.get(0);
        Armadura armadura2 = this.armaduras.get(1);
        Armadura armadura3 = this.armaduras.get(2);
        Set<Armadura> armadurasEjemplo = Set.of(armadura1, armadura2, armadura3);
        return armadurasEjemplo;
    }

    public Set<Armadura> obtenerArmadurasEjemploLicantropo() {
        Armadura armadura1 = this.armaduras.get(3);
        Armadura armadura2 = this.armaduras.get(4);
        Armadura armadura3 = this.armaduras.get(5);
        Set<Armadura> armadurasEjemplo = Set.of(armadura1, armadura2, armadura3);
        return armadurasEjemplo;
    }

    public Set<Armadura> obtenerArmadurasEjemploCazador() {
        Armadura armadura1 = this.armaduras.get(6);
        Armadura armadura2 = this.armaduras.get(7);
        Armadura armadura3 = this.armaduras.get(8);
        Set<Armadura> armadurasEjemplo = Set.of(armadura1, armadura2, armadura3);
        return armadurasEjemplo;
    }

}
