package clasesDeJuego;

import java.io.Serializable;
import sistemas.NumRegOverflowException;

/**
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class NumeroRegistro implements Serializable {

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

    public NumeroRegistro(char caracter1, int numero1, int numero2, char caracter2, char caracter3) {
        this.caracter1 = caracter1;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.caracter2 = caracter2;
        this.caracter3 = caracter3;
    }

    public void copiar(NumeroRegistro numReg) {
        this.caracter1 = numReg.caracter1;
        this.numero1 = numReg.numero1;
        this.numero2 = numReg.numero2;
        this.caracter2 = numReg.caracter2;
        this.caracter3 = numReg.caracter3;
    }

    public void incrementarNumReg() throws NumRegOverflowException {
        incrementarRecursivo(4);
    }

    private void incrementarRecursivo(int pos) throws NumRegOverflowException {
        int num = -1;
        char c = ' ';
        switch (pos) {
            case 0 -> {
                this.caracter1 = incrementarCaracter(this.caracter1);
                c = this.caracter1;
            }
            case 1 -> {
                this.numero1 = incrementarNumero(this.numero1);
                num = this.numero1;
            }
            case 2 -> {
                this.numero2 = incrementarNumero(this.numero2);
                num = this.numero2;
            }
            case 3 -> {
                this.caracter2 = incrementarCaracter(this.caracter2);
                c = this.caracter2;
            }
            case 4 -> {
                this.caracter3 = incrementarCaracter(this.caracter3);
                c = this.caracter3;
            }
            default -> {
            }
        }
        if (num == 0 || c == '0') {
            if (pos != 0) {
                incrementarRecursivo(pos - 1);
            } else {
                this.caracter1 = 'z';
                this.numero1 = 9;
                this.numero2 = 9;
                this.caracter2 = 'z';
                this.caracter3 = 'z';

                throw new NumRegOverflowException();
            }
        }
    }

    private int incrementarNumero(int n) {
        n++;
        if (n == 10) {
            n = 0;
        }
        return n;
    }

    private char incrementarCaracter(char c) {
        int value = c;

        switch (value) {
            case 57 ->
                c += 8;
            case 90 ->
                c += 7;
            case 122 ->
                c = '0';
            default ->
                c += 1;
        }
        return c;
    }

    public boolean sonIguales(NumeroRegistro num) {
        if (num == null) {
            return false;
        }
        boolean sonIguales = true;
        if (this.caracter1 != num.caracter1 || this.caracter2 != num.caracter2 || this.caracter3 != num.caracter3) {
            sonIguales = false;
        } else if (this.numero1 != num.numero1 || this.numero2 != num.numero2) {
            sonIguales = false;
        }
        return sonIguales;
    }
}
