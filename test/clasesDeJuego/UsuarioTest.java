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
public class UsuarioTest {
    private final String nombre = "Nombre";
    private final String nick = "Nick";
    private final String contrasenia = "Contrasenia";
    private final NumeroRegistro numReg = new NumeroRegistro('a',1,2,'b','c');
    
    public UsuarioTest() {
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
     * Test of obtenerNick method, of class Usuario.
     */
    @Test
    public void testObtenerNick() {
        System.out.println("Empezando test: obtenerNick");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        String expResult = nick;
        String result = instance.obtenerNick();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerNick");
    }

    /**
     * Test of compararContrasenia method, of class Usuario.
     */
    @Test
    public void testCompararContrasenia() {
        System.out.println("Empezando test: compararContrasenia");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        boolean result = instance.compararContrasenia(contrasenia);
        assertTrue(result);
        System.out.println("Test  completo: compararContrasenia");
    }

    /**
     * Test of esAdministrador method, of class Usuario.
     */
    @Test
    public void testEsAdministrador() {
        System.out.println("Empezando test: esAdministrador");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        boolean result = instance.esAdministrador();
        assertTrue(result);
        instance.ponerNumReg(numReg);
        result = instance.esAdministrador();
        assertFalse("Si falla podría ser por ponerNumReg, o por numReg.sonIguales()", result);
        System.out.println("Test  completo: esAdministrador");
    }

    /**
     * Test of estaBaneado method, of class Usuario.
     */
    @Test
    public void testEstaBaneado() {
        System.out.println("Empezando test: estaBaneado");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        boolean result = instance.estaBaneado();
        assertFalse(result);
        instance.cambiarBaneo(true);
        result = instance.estaBaneado();
        assertTrue("El fallo podria estar en  cambiarBaneo()", result);
        System.out.println("Test completo: estaBaneado");
    }

    /**
     * Test of cambiarBaneo method, of class Usuario.
     */
    @Test
    public void testCambiarBaneo() {
        System.out.println("Empezando test: cambiarBaneo");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        boolean result = instance.estaBaneado();
        assertFalse(result);
        instance.cambiarBaneo(true);
        result = instance.estaBaneado();
        assertTrue("El fallo podria estar en  estaBaneado()", result);
        instance.cambiarBaneo(false);
        result = instance.estaBaneado();
        assertFalse("El fallo podria estar en  estaBaneado()", result);
        System.out.println("Test  completo: cambiarBaneo");
    }

    /**
     * Test of ponerNumReg method, of class Usuario.
     */
    @Test
    public void testPonerNumReg() {
        System.out.println("Empezando test: ponerNumReg");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        boolean result = instance.compararNumReg(numReg);
        assertFalse(result);
        instance.ponerNumReg(numReg);
        result = instance.compararNumReg(numReg);
        assertTrue(result);
        System.out.println("Test  completo: ponerNumReg");
    }
    
    /**
     * Test of compararNumReg method, of class Usuario.
     */
    @Test
    public void testCompararNumReg() {
        System.out.println("Empezando test: ponerNumReg");
        Usuario instance = new Usuario(nombre, nick, contrasenia);
        boolean result = instance.compararNumReg(new NumeroRegistro());
        assertTrue(result);
        result = instance.compararNumReg(numReg);
        assertFalse(result);
        System.out.println("Test  completo: ponerNumReg");
    }
    
}
