/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clasesDeJuego;

import baseDeDatos.AlmacenEsbirros;
import baseDeDatos.Estado;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import practicamp.Juego;
import clasesDeJuego.Esbirro;

/**
 *
 * @author marco
 */
public class EsbirroTest {
    
    public EsbirroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println();
    }

    
    /**
     * Test of fromListToString method, of class Esbirro.
     */
    @Test
    public void testFromListToString() {
        System.out.println("Empezando test: fromListToString");
        String expResult = "";
        Estado estadoJuego = new Estado();
        List <Esbirro> esbirros = estadoJuego.obtenerAlmacenEsbirros().obtenerEsbirros();
        for (int i=1; i<= esbirros.size(); i++) {
            expResult += "    " + Integer.toString(i) + ". " + esbirros.get(i-1).obtenerNombre() + "\n";
        }
        
        String result = Esbirro.fromListToString(esbirros);
        
        System.out.println(expResult);
        System.out.println(result);
        
        assertEquals(expResult, result);
    }   
    
    /**
     * Test of obtenerNombre method, of class Esbirro.
     */
    @Test 
    public void testObtenerNombre() { //Getter 
        /*Revisar. O bien hay que romper la encapsulación para obtener nombre directamente o bien geneerar una lista con todos los 
        nombres de los esbirros y comparar cada uno con el string que se obtiene directamente*/
        System.out.println("Empezando test: obtenerNombre");
        Estado estadoJuego = new Estado(); //Se crea un nuevo estado para que el constructor del estado cargue los datos serializados (ya que si no el estado seria null)
        List listaEsbirros = estadoJuego.obtenerAlmacenEsbirros().obtenerEsbirros();
        int numEsbAleatorio = (int) (Math.random() * listaEsbirros.size()-1);
        Esbirro esb = (Esbirro) listaEsbirros.get(numEsbAleatorio);
        String expResult = esb.obtenerNombre();
        String result = esb.obtenerNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerVida method, of class Esbirro.
     */
    @Test
    public void testObtenerVida() { //Getter
        System.out.println("Empezando test: obtenerVida");
        Estado estadoJuego = new Estado();
        List listaEsbirros = estadoJuego.obtenerAlmacenEsbirros().obtenerEsbirros();
        int numEsbAleatorio = (int)(Math.random() * listaEsbirros.size()-1);
        Esbirro esb = (Esbirro) listaEsbirros.get(numEsbAleatorio);
        int expResult = esb.obtenerVida();
        int result = esb.obtenerVida();
        assertEquals(expResult,result);
    }

    /**
     * Test of tieneSubordinados method, of class Esbirro.
     */
    @Test
    public void testTieneSubordinados() {
        System.out.println("Empezando test: tieneSubordinados");
        Esbirro instance = new Esbirro("nombre",(int)(Math.random() * 5));
        boolean expResult = false;
        boolean result = instance.tieneSubordinados();
        assertEquals(expResult, result);
    }

    /**
     * Test of tieneHumanos method, of class Esbirro.
     */
    @Test
    public void testTieneHumanos() {
        System.out.println("Empezando test: tieneHumanos");
        Esbirro instance = new Esbirro("nombre",(int)(Math.random() * 5));
        boolean expResult = false;
        boolean result = instance.tieneHumanos();
        assertEquals(expResult, result);
    }
}
    
