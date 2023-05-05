/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clasesDeJuego;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ángel Marqués
 */
public class DemonioTest {
    
    public DemonioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerVida method, of class Demonio.
     */
    @Test
    public void testObtenerVida() {
        System.out.println("Empezando test: obtenerVida");
        Demonio instance = new Demonio("Nombre", 5, "", null);
        int expResult = 5;
        int result = instance.obtenerVida();
        assertEquals(expResult, result);
        
        Esbirro esb1 = new Esbirro("Esbirro1", 3);
        Esbirro esb2 = new Esbirro("Esbirro1", 2);
        HashSet<Esbirro> esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(esb2);
        instance = new Demonio("Nombre", 5, "", esbirros);
        expResult = 10;
        result = instance.obtenerVida();
        assertEquals(expResult, result);
        
        esb1 = new Esbirro("Esbirro1", 3);
        esb2 = new Esbirro("Esbirro1", 2);
        esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(esb2);
        Demonio dem1 = new Demonio("Pepe", 5, "", esbirros);
        HashSet<Esbirro> esbirros1 = new HashSet();
        esbirros1.add(dem1);
        instance = new Demonio("Nombre", 5, "", esbirros1);
        expResult = 15;
        result = instance.obtenerVida();
        assertEquals(expResult, result);
        
        System.out.println("Test  completo: obtenerVida");
    }

    /**
     * Test of tieneSubordinados method, of class Demonio.
     */
    @Test
    public void testTieneSubordinados() {
        System.out.println("Empezando test: tieneSubordinados");
        Demonio instance = new Demonio("Nombre", 5, "", null);
        boolean expResult = false;
        boolean result = instance.tieneSubordinados();
        assertEquals(expResult, result);
        
        HashSet<Esbirro> esbirros = new HashSet();
        instance = new Demonio("Nombre", 5, "", esbirros);
        expResult = false;
        result = instance.tieneSubordinados();
        assertEquals(expResult, result);
        
        Esbirro esb1 = new Esbirro("Esbirro1", 3);
        Esbirro esb2 = new Esbirro("Esbirro1", 2);
        esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(esb2);
        instance = new Demonio("Nombre", 5, "", esbirros);
        expResult = true;
        result = instance.tieneSubordinados();
        assertEquals(expResult, result);
        
        System.out.println("Test  completo: obtenerVida");
    }

    /**
     * Test of tieneHumanos method, of class Demonio.
     */
    @Test
    public void testTieneHumanos() {
        System.out.println("Empezando test: tieneHumanos");
        
        Demonio instance = new Demonio("Nombre", 5, "", null);
        boolean expResult = false;
        boolean result = instance.tieneHumanos();
        assertEquals(expResult, result);
        
        HashSet<Esbirro> esbirros = new HashSet();
        instance = new Demonio("Nombre", 5, "", esbirros);
        expResult = false;
        result = instance.tieneSubordinados();
        assertEquals(expResult, result);
        
        Esbirro esb1 = new Esbirro("Esbirro1", 3);
        Esbirro esb2 = new Esbirro("Esbirro1", 2);
        esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(esb2);
        instance = new Demonio("Nombre", 5, "", esbirros);
        expResult = false;
        result = instance.tieneHumanos();
        assertEquals(expResult, result);
        
        esb1 = new Esbirro("Esbirro1", 3);
        esb2 = new Esbirro("Esbirro1", 2);
        esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(esb2);
        Demonio dem1 = new Demonio("Pepe", 5, "", esbirros);
        HashSet<Esbirro> esbirros1 = new HashSet();
        esbirros1.add(dem1);
        instance = new Demonio("Nombre", 5, "", esbirros1);
        expResult = false;
        result = instance.tieneHumanos();
        assertEquals(expResult, result);
        
        //probamos con humanos
        esb1 = new Esbirro("Esbirro1", 3);
        Humano h1 = new Humano("Esbirro1", 2, NivelLealtad.ALTA);
        esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(h1);
        instance = new Demonio("Nombre", 5, "", esbirros);
        expResult = true;
        result = instance.tieneHumanos();
        assertEquals(expResult, result);
        
        esb1 = new Esbirro("Esbirro1", 3);
        h1 = new Humano("Esbirro1", 2, NivelLealtad.ALTA);
        esbirros = new HashSet();
        esbirros.add(esb1);
        esbirros.add(h1);
        dem1 = new Demonio("Pepe", 5, "", esbirros);
        esbirros1 = new HashSet();
        esbirros1.add(dem1);
        instance = new Demonio("Nombre", 5, "", esbirros1);
        expResult = true;
        result = instance.tieneHumanos();
        assertEquals(expResult, result);
        

        System.out.println("Test  completo: obtenerVida");
    }
    
}
