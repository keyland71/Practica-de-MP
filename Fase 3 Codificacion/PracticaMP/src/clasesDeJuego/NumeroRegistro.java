package clasesDeJuego;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class NumeroRegistro { //debe implementar equals
    
    private char caracter1;
    private int numero1;
    private int numero2;
    private char caracter2;
    private char caracter3;

    public NumeroRegistro obtenerPrimero() {
        return null; //devuelve el primero numReg, el de los Admin
    }
    
    //de angel
    public void copy(NumeroRegistro numReg){
        this.caracter1 = numReg.caracter1;
        this.numero1 = numReg.numero1;
        this.numero2 = numReg.numero2;
        this.caracter2 = numReg.caracter2;
        this.caracter3 = numReg.caracter3;
    }
    
    
     public NumeroRegistro(char caracter1, int numero1, int numero2, char caracter2, char caracter3) {
        this.caracter1 = caracter1;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.caracter2 = caracter2;
        this.caracter3 = caracter3;
    }
    public NumeroRegistro obtenerNumReg() {
        return new NumeroRegistro(caracter1, numero1, numero2, caracter2, caracter3);
    }
    
     public NumeroRegistro incrementarNumReg() {
        int nuevoNumero1 = this.numero1 + 1;
        return new NumeroRegistro(this.caracter1, nuevoNumero1, this.numero2, this.caracter2, this.caracter3);
    }
    
}
