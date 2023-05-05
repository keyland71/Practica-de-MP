/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clasesDeJuego;

import java.util.ArrayList;
import java.util.List;
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
public class ArmaTest {
    
    public ArmaTest() {
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
    }

    /**
     * Test of fromListToString method, of class Arma.
     */
    @Test
    public void testFromListToString() {
        System.out.println("Empezando test: fromListToString");
        
        List <Arma> armas = new ArrayList<>();
        
        Arma a1 = new Arma("Arma1", 3,3,Variante.dosManos);
        Arma a2 = new Arma("Arma2", 1,2,Variante.unaMano);
        Arma a3 = new Arma("Arma3", 2,0, Variante.unaMano);
        
        armas.add(a1);
        armas.add(a2);
        armas.add(a3);
        
        String expResult = "    1. Arma1 (dosManos)\n" 
                         + "    2. Arma2 (unaMano)\n"
                         + "    3. Arma3 (unaMano)\n";
        
        String result = Arma.fromListToString(armas);
        
        assertEquals(expResult, result);
        System.out.println("Test  completo: fromListToString");
    }

    /**
     * Test of obtenerVariante method, of class Arma.
     */
    @Test
    public void testObtenerVariante() {
        System.out.println("Empezando test: obtenerVariante");
        Arma instance = new Arma("Arma1", 3,3,Variante.dosManos);
        Variante expResult = Variante.dosManos;
        Variante result = instance.obtenerVariante();
        assertEquals(expResult, result);
        
        instance = new Arma("Arma1", 3,3,Variante.unaMano);
        expResult = Variante.unaMano;
        result = instance.obtenerVariante();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerVariante");
    }

    /**
     * Test of toString method, of class Arma.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando test: toString");
        Arma instance = new Arma("Arma1", 3,2,Variante.dosManos);
        String expResult = "        Nombre: Arma1\n"
                         + "        Ataque: 3\n"
                         + "        Defensa: 2\n"
                         + "        Tipo: Dos manos";
        
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance = new Arma("Arma2", 1,0,Variante.unaMano);
        expResult = "        Nombre: Arma2\n"
                         + "        Ataque: 1\n"
                         + "        Defensa: 0\n"
                         + "        Tipo: Una mano";
        
        result = instance.toString();
        assertEquals(expResult, result);
        
        System.out.println("Test  completo: toString");
    }
    
}
