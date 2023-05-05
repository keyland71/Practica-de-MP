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
        System.out.println("Test  completo: fromListToString");
    }   
    
    /**
     * Test of obtenerNombre method, of class Esbirro.
     */
    @Test 
    public void testObtenerNombre() { //Getter 
        System.out.println("Empezando test: obtenerNombre");
        Esbirro instance = new Esbirro("Nombre", 5);
        String expResult = "Nombre";
        String result = instance.obtenerNombre();
        assertEquals(expResult, result);
        
        instance = new Esbirro("juan", 5);
        expResult = "juan";
        result = instance.obtenerNombre();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerNombre");
    }

    /**
     * Test of obtenerVida method, of class Esbirro.
     */
    @Test
    public void testObtenerVida() { //Getter
        System.out.println("Empezando test: obtenerVida");
        Esbirro instance = new Esbirro("Nombre", 5);
        int expResult = 5;
        int result = instance.obtenerVida();
        assertEquals(expResult,result);
        
        instance = new Esbirro("Nombre", 3);
        expResult = 3;
        result = instance.obtenerVida();
        assertEquals(expResult,result);
        
        System.out.println("Test  completo: obtenerVida");
    }

    /**
     * Test of tieneSubordinados method, of class Esbirro.
     */
    @Test
    public void testTieneSubordinados() {
        System.out.println("Empezando test: tieneSubordinados");
        Esbirro instance = new Esbirro("Nombre",(int)(Math.random() * 5));
        boolean expResult = false;
        boolean result = instance.tieneSubordinados();
        assertEquals(expResult, result);
        System.out.println("Test  completo: tieneSubordinados");
    }

    /**
     * Test of tieneHumanos method, of class Esbirro.
     */
    @Test
    public void testTieneHumanos() {
        System.out.println("Empezando test: tieneHumanos");
        Esbirro instance = new Esbirro("Nombre",(int)(Math.random() * 5));
        boolean expResult = false;
        boolean result = instance.tieneHumanos();
        assertEquals(expResult, result);
        System.out.println("Test  completo: tieneHumanos");
    }
}
    
