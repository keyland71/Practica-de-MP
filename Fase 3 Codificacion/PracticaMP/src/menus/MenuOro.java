/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import baseDeDatos.Estado;
import clasesDeJuego.Combate;
import java.util.List;
import java.util.Scanner;
import practicamp.Juego;

/**
 *
 * @author Ángel Marqués
 */
public class MenuOro {
    private Scanner lector;
    
    public MenuOro(){
        //carga el historial
        this.lector = new Scanner(System.in);
    }
    public String mostrarHistorial(List<Combate> combates){ //no haría falta devolver el input del usuario
        int i = 1;
        for (Combate c:combates){
            mostrarElemento(c, i); //sugiero renombrar a mostrarCombate
            i++; //teniendo cuidado, se podría poner arriba, asegurando que sea post-incremento
        }
        System.out.println("Pulsa intro para volver");
        return this.lector.nextLine();
    }
    
     private void mostrarElemento(Combate combate, int num){
        //obtiene el oro 
        String fecha = combate.obtenerFecha();
        int oro = combate.obtenerOroGanado();
        String vencedor = combate.obtenerVencedor().obtenerNick();
        String oponente = combate.obtenerUDesafiado().obtenerNick();
        if (Juego.estado.obtenerUsuarioActivo().obtenerNick().equalsIgnoreCase(oponente)){
            oponente = combate.obtenerUDesafiante().obtenerNick();
        }
        if (!Juego.estado.obtenerUsuarioActivo().obtenerNick().equals(vencedor)){
            oro = -oro;        
        }
        System.out.println("Combate " + num + ": " + "\n    Oponente: " + oponente + "\n    Oro ganado: " + oro + "\n    Fecha: " + fecha);
     }
}
