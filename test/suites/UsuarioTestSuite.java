/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package suites;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ángel Marqués
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    clasesDeJuego.JugadorTest.class,
    clasesDeJuego.UsuarioTest.class,
    clasesDeJuego.AdministradorTest.class
})
public class UsuarioTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Testing all tests for Usuario, Jugador, and Administrador");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("All tests complete for Usuario, Jugador, and Administrador");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
