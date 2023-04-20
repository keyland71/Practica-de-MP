package clasesDeJuego;

import java.io.Serializable;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class NumeroRegistro implements Serializable { //debe implementar equals

    private char caracter1;
    private int numero1;
    private int numero2;
    private char caracter2;
    private char caracter3;

    public NumeroRegistro() {
        this.caracter1 = '0';
        this.caracter2 = '0';
        this.caracter3 = '0';
        this.numero1 = 0;
        this.numero2 = 0;
    }

    //lucia
    public NumeroRegistro(char caracter1, int numero1, int numero2, char caracter2, char caracter3) {
        this.caracter1 = caracter1;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.caracter2 = caracter2;
        this.caracter3 = caracter3;
    }

    //de angel
    public void copiar(NumeroRegistro numReg) {
        this.caracter1 = numReg.caracter1;
        this.numero1 = numReg.numero1;
        this.numero2 = numReg.numero2;
        this.caracter2 = numReg.caracter2;
        this.caracter3 = numReg.caracter3;
    }

    public NumeroRegistro obtenerNumReg() {
        return new NumeroRegistro(caracter1, numero1, numero2, caracter2, caracter3);
    }

    public NumeroRegistro incrementarNumReg() {
        int nuevoNumero1 = this.numero1 + 1;  //incrementa en 1 el numero de registro y crea uno nuevo con ese incremento
        return new NumeroRegistro(this.caracter1, nuevoNumero1, this.numero2, this.caracter2, this.caracter3);
    }

    public boolean sonIguales(NumeroRegistro num) {
        boolean sonIguales = true;
        if (this.caracter1 != num.caracter1 || this.caracter2 != num.caracter2 || this.caracter3 != num.caracter3) {
            sonIguales = false;
        } else if (this.numero1 != num.numero1 || this.numero2 != num.numero2) {
            sonIguales = false;
        }
        return sonIguales;
    }
}
