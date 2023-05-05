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
public class JugadorTest {
    
    public JugadorTest() {
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
     * Test of obtenerPersonaje method, of class Jugador.
     */
    @Test
    public void testObtenerPersonaje() {
        System.out.println("Empezando test: obtenerPersonaje");
        Jugador instance = new Jugador("Nombre", "Nick", "Contrasenia");
        Personaje expResult = null;
        Personaje result = instance.obtenerPersonaje();
        assertEquals(expResult, result);
        expResult = new PersonajeImpl();
        instance.ponerPersonaje(expResult);
        result = instance.obtenerPersonaje();
        assertEquals(expResult, result);
        expResult = new PersonajeImpl();
        instance.ponerPersonaje(expResult);
        result = instance.obtenerPersonaje();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerPersonaje");
    }

    /**
     * Test of ponerPersonaje method, of class Jugador.
     */
    @Test
    public void testPonerPersonaje() {
        System.out.println("Empezando test: ponerPersonaje");
        Jugador instance = new Jugador("Nombre", "Nick", "Contrasenia");
        Personaje p = new PersonajeImpl();
        instance.ponerPersonaje(p);
        Personaje result = instance.obtenerPersonaje();
        assertEquals(p, result);
        p = null;
        instance.ponerPersonaje(p);
        result = instance.obtenerPersonaje();
        assertEquals(p, result);
        System.out.println("Test  completo: ponerPersonaje");
    }

    /**
     * Test of incrementarVictorias method, of class Jugador.
     */
    @Test
    public void testIncrementarVictorias() {
        System.out.println("Empezando test: incrementarVictorias");
        Jugador instance = new Jugador("Nombre", "Nick", "Contrasenia");
        int numVictorias = instance.obtenerVictorias();
        instance.incrementarVictorias();
        int expResult = numVictorias + 1;
        int result = instance.obtenerVictorias();
        assertEquals(expResult, result);
        System.out.println("Test  completo: incrementarVictorias");
    }

    /**
     * Test of obtenerVictorias method, of class Jugador.
     */
    @Test
    public void testObtenerVictorias() {
        System.out.println("Empezando test: obtenerVictorias");
        Jugador instance = new Jugador("Nombre", "Nick", "Contrasenia");
        int expResult = 0;
        int result = instance.obtenerVictorias();
        assertEquals(expResult, result);
        instance.incrementarVictorias();
        instance.incrementarVictorias();
        expResult = 2;
        result = instance.obtenerVictorias();
        assertEquals(expResult, result);
        System.out.println("Test  completo: obtenerVictorias");
    }
    
    private class PersonajeImpl extends Personaje {

        public PersonajeImpl() {
            super("Nombre");
        }

        public void modificarRecurso() {
        }
    }
}
