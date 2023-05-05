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
import sistemas.NumRegOverflowException;

/**
 *
 * @author marqu
 */
public class NumeroRegistroTest {
    
    public NumeroRegistroTest() {
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
     * Test of copiar method, of class NumeroRegistro.
     */
    @Test
    public void testCopiar() {
        System.out.println("Empezando test: copiar");
        NumeroRegistro base = new NumeroRegistro('a',1,2,'b','c');
        NumeroRegistro testCase = new NumeroRegistro();
        testCase.copiar(base);
        assertTrue(base.sonIguales(testCase));
        System.out.println("Test  completo: estaBaneado");
    }

    /**
     * Test of incrementarNumReg method, of class NumeroRegistro.
     */
    @Test
    public void testIncrementarNumReg() {
        NumeroRegistro instance = null;
        NumeroRegistro expectedValue;
        try {
            System.out.println("Empezando test: incrementarNumReg");
            
            instance = new NumeroRegistro();
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',0,0,'0','1');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',0,0,'0','9');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',0,0,'0','A');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',0,0,'0','Z');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',0,0,'0','a');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',0,0,'0','z');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',0,0,'1','0');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',0,0,'z','z');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',0,1,'0','0');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',0,1,'z','z');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',0,2,'0','0');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',0,9,'z','z');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('0',1,0,'0','0');
            assertTrue(expectedValue.sonIguales(instance));
            
            instance = new NumeroRegistro('0',9,9,'z','z');
            instance.incrementarNumReg();
            expectedValue = new NumeroRegistro('1',0,0,'0','0');
            assertTrue(expectedValue.sonIguales(instance));
        } catch (NumRegOverflowException ex) {
            fail("Ha lanzado una excepción cuando no debía");
        }
        try {    
            instance = new NumeroRegistro('z',9,9,'z','z');
            instance.incrementarNumReg();
            fail("No ha lanzado la excepción");
        } catch (NumRegOverflowException ex) {
            expectedValue = new NumeroRegistro('z',9,9,'z','z');
            assertTrue(expectedValue.sonIguales(instance));
        }
            
        System.out.println("Test  completo: incrementarNumReg");
        
    }

    /**
     * Test of sonIguales method, of class NumeroRegistro.
     */
    @Test
    public void testSonIguales() {
        System.out.println("Empezando test: sonIguales");
        NumeroRegistro num = new NumeroRegistro();
        NumeroRegistro instance = new NumeroRegistro();
        boolean result = instance.sonIguales(num);
        assertTrue(result);
        
        num = new NumeroRegistro('a',1,2,'b','c');
        instance = new NumeroRegistro('a',1,2,'b','c');
        result = instance.sonIguales(num);
        assertTrue(result);
        
        num = new NumeroRegistro();
        instance = new NumeroRegistro('a',1,2,'b','c');
        result = instance.sonIguales(num);
        assertFalse(result);
        
        num = null;
        instance = new NumeroRegistro('a',1,2,'b','c');
        result = instance.sonIguales(num);
        assertFalse(result);
        
        System.out.println("Test  completo: sonIguales");
    }
}
