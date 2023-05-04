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
public class AdministradorTest {
    
    public AdministradorTest() {
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
     * Test of estaBaneado method, of class Administrador.
     */
    @Test
    public void testEstaBaneado() {
        System.out.println("Empezando test: estaBaneado");
        Administrador instance = new Administrador("Nombre", "Nick", "Contrasenia");
        boolean result = instance.estaBaneado();
        assertFalse(result);
        instance.cambiarBaneo(true);
        assertFalse(result);
        System.out.println("Test  completo: estaBaneado");
    }

    /**
     * Test of cambiarBaneo method, of class Administrador.
     */
    @Test
    public void testCambiarBaneo() {
        System.out.println("Empezando test: cambiarBaneo");
        Administrador instance = new Administrador("Nombre", "Nick", "Contrasenia");
        instance.cambiarBaneo(true);
        boolean result = instance.estaBaneado();
        assertFalse(result);
        instance.cambiarBaneo(false);
        result = instance.estaBaneado();
        assertFalse(result);
        System.out.println("Test  completo: cambiarBaneo");
    }
    
}
