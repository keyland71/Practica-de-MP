/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clasesDeJuego;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author Ángel Marqués
 */
public class ArmaduraTest {
    
    public ArmaduraTest() {
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
     * Test of fromListToString method, of class Armadura.
     */
    @Test
    public void testFromListToString() {
        System.out.println("Empezando test: fromListToString");
        
        List <Armadura> armaduras = new ArrayList<>();
        String result = Armadura.fromListToString(armaduras);
        String expResult = "";
        assertEquals(expResult, result);
        
        Armadura a1 = new Armadura("Armadura1", 3,3);
        Armadura a2 = new Armadura("Armadura2", 2,1);
        Armadura a3 = new Armadura("Armadura3", 0,2);
        
        armaduras.add(a1);
        armaduras.add(a2);
        armaduras.add(a3);
        
        expResult = "    1. Armadura1\n" 
                  + "    2. Armadura2\n"
                  + "    3. Armadura3\n";
        
        result = Armadura.fromListToString(armaduras);
        
        assertEquals(expResult, result);
        
        try{
            Armadura.fromListToString(null);
            fail("no ha lanzado error");
        } catch (RuntimeException e){}
        
        System.out.println("Test  completo: fromListToString");
    }

    /**
     * Test of toString method, of class Armadura.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando test: toString");
        Armadura instance = new Armadura("Armadura1", 2,3);
        String expResult = "        Nombre: Armadura1\n"
                         + "        Defensa: 3\n"
                         + "        Ataque: 2";
        
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance = new Armadura("Armadura2", 0,1);
        expResult = "        Nombre: Armadura2\n"
                  + "        Defensa: 1\n"
                  + "        Ataque: 0";
        
        result = instance.toString();
        assertEquals(expResult, result);
        
        System.out.println("Test  completo: toString");
    }
    
}
