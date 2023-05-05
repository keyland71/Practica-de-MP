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
    clasesDeJuego.EquipoTest.class,
    clasesDeJuego.ArmaTest.class,
    clasesDeJuego.ArmaduraTest.class
})
public class EquipoTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Testing all tests for Equipo, Arma, and Armadura");
        System.out.println();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println();
        System.out.println("All tests complete for Equipo, Arma, and Armadura");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
