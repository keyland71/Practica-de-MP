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
    
}
