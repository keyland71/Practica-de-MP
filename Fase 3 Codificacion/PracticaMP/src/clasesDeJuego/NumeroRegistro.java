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

    //para eso sería mejor hacer return this, no? And that's a kinda pointless operation, is it not?
    //en todo caso, si fuera abstracta obtenerNumReg, todavía.
    public NumeroRegistro obtenerNumReg() {
        return new NumeroRegistro(caracter1, numero1, numero2, caracter2, caracter3);
    }

    public void incrementarNumReg() {
        //esta función se encarga de empezar el proceso recursivo
        incrementarRecursivo(4);
    }

    private void incrementarRecursivo(int pos) {
        //esta función hace lo siguiente:
        //  1. incrementa en 1 el valor en la posición pasada
        //  2. guarda el valor en una variable
        //  3. Si el nuevo valor es un 0 o '0', se llama a si misma con la siguiente posicion
        //  4. Si el nuevo valor es un '0', Y la posición también es 0, avisa de que ha habido overflow
        int num = -1;
        char c = ' ';
        switch (pos) {
            case 0 -> {
                this.caracter1 = incrementarCaracter(this.caracter1);
                c = this.caracter1;
            } case 1 -> {
                this.numero1 = incrementarNumero(this.numero1);
                num = this.numero1;
            } case 2 -> {
                this.numero2 = incrementarNumero(this.numero2);
                num = this.numero2;
            } case 3 -> {
                this.caracter2 = incrementarCaracter(this.caracter2);
                c = this.caracter2;
            } case 4 -> {
                this.caracter3 = incrementarCaracter(this.caracter3);
                c = this.caracter3;
            } default -> {
            }
        }
        if (num == 0 || c == '0') {
            if (pos != 0) {
                incrementarRecursivo(pos - 1);
                return; // el return es para ahorrarse un else
            }
            System.out.print("Error: Overflow en el número de registro"); //no se debería dar esto nunca. Lo correcto sería lanzar una excepción y usar logger, pero no sé hacer lo uno ni lo otro
        }
    }

    

    private int incrementarNumero(int n) {
        n++;//igual se podría poner con pre incremento en el if
        if (n == 10) {
            n = 0;
        }
        return n;
    }

    private char incrementarCaracter(char c) {
        //queremos aumentar el caracter c. si está en 57, saltamos a 65. Si está en 90, saltamos a 97. Si está en 122, saltamos a 48.
        //esto va saltando de numeros a mayúsculas a minúsculas, a números de nuevo. Esta hecho así para evitar carácteres especiales.
        int value = c;
        //lo prefiero como cadena de if, si lo quereis poner como switch no me importa
        if (value == 57) {
            c += 8; // si es '9', pasa a 'A'
        } else if (value == 90) {
            c += 7; // si es 'Z', pasa a 'a'
        } else if (value == 122) {
            c = '0'; // si es 'z', pasa a '0'
        } else {
            c += 1; //en cualquier otro caso, pasa al siguiente
        }
        return c;
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
