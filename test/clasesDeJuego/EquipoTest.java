/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clasesDeJuego;

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
public class EquipoTest {
    
    public EquipoTest() {
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
     * Test of obtenerAtaque method, of class Equipo.
     */
    @Test
    public void testObtenerAtaque() {
        System.out.println("Empezando test: obtenerAtaque");
        Equipo instance = new Equipo("Equipo1",3,2);
        int expResult = 3;
        int result = instance.obtenerAtaque();
        assertEquals(expResult, result);
        
        instance = new Equipo("Equipo2",0,1);
        expResult = 0;
        result = instance.obtenerAtaque();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerAtaque");
    }

    /**
     * Test of obtenerDefensa method, of class Equipo.
     */
    @Test
    public void testObtenerDefensa() {
        System.out.println("Empezando test: obtenerDefensa");
               Equipo instance = new Equipo("Equipo1",3,2);
        int expResult = 2;
        int result = instance.obtenerDefensa();
        assertEquals(expResult, result);
        
        instance = new Equipo("Equipo2",0,1);
        expResult = 1;
        result = instance.obtenerDefensa();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerDefensa");
    }

    /**
     * Test of obtenerNombre method, of class Equipo.
     */
    @Test
    public void testObtenerNombre() {
        System.out.println("Empezando test: obtenerNombre");
                Equipo instance = new Equipo("Equipo1",3,2);
        String expResult = "Equipo1";
        String result = instance.obtenerNombre();
        assertEquals(expResult, result);
        
        instance = new Equipo("Equipo2",0,1);
        expResult = "Equipo2";
        result = instance.obtenerNombre();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerNombre");
    }
    
}
