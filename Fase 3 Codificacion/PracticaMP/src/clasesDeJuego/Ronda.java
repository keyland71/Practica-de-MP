/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeJuego;

/**
 *
 * @author lucia
 */
public class Ronda {
    private int vidaInicialA;
    private int vidaInicialB;
    private int vidaFinalA;
    private int vidaFinalB;
    private int valorAtaqueFinalA;
    private int valorAtaqueFinalB;
    private int valorDefensaA;
    private int valorDefensaB;
    
    
    public Ronda (int vidaIniA) {
        this.vidaInicialA = vidaIniA;
        this.vidaInicialB = 0; //valor por defecto
        this.vidaFinalA = 0;   //valor por defecto
        this.vidaFinalB =0;    //alor por defecto
        this.valorAtaqueFinalA =0; //valor por defecto
        this.valorAtaqueFinalB=0; //valor por defecto
        this.valorDefensaA=0; //valor por defecto;
        this.valorDefensaB=0; //valor por defecto;
 
    }
    
   public String toStringRonda (){
      String ronda=  "Ronda{" +
            "vidaInicialA=" + vidaInicialA +
            ", vidaInicialB=" + vidaInicialB +
            ", vidaFinalA=" + vidaFinalA +
            ", vidaFinalB=" + vidaFinalB +
            ", valorAtaqueFinalA=" + valorAtaqueFinalA +
            ", valorAtaqueFinalB=" + valorAtaqueFinalB +
            ", valorDefensaA=" + valorDefensaA +
            ", valorDefensaB=" + valorDefensaB +
            '}';
      return ronda;
   }
    
    
}
