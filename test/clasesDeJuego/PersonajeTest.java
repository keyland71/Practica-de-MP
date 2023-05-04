/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clasesDeJuego;

import java.util.Collection;
import java.util.List;
import java.util.Set;
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
public class PersonajeTest {
    
    public PersonajeTest() {
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
     * Test of obtenerArmasActivas method, of class Personaje.
     */
    @Test
    public void testObtenerArmasActivas() {
        System.out.println("obtenerArmasActivas");
        Personaje instance = null;
        List<Arma> expResult = null;
        List<Arma> result = instance.obtenerArmasActivas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArmaduraActiva method, of class Personaje.
     */
    @Test
    public void testObtenerArmaduraActiva() {
        System.out.println("obtenerArmaduraActiva");
        Personaje instance = null;
        Armadura expResult = null;
        Armadura result = instance.obtenerArmaduraActiva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNombre method, of class Personaje.
     */
    @Test
    public void testObtenerNombre() {
        System.out.println("obtenerNombre");
        Personaje instance = null;
        String expResult = "";
        String result = instance.obtenerNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDescripcion method, of class Personaje.
     */
    @Test
    public void testObtenerDescripcion() {
        System.out.println("obtenerDescripcion");
        Personaje instance = null;
        String expResult = "";
        String result = instance.obtenerDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerModificadores method, of class Personaje.
     */
    @Test
    public void testObtenerModificadores() {
        System.out.println("obtenerModificadores");
        Personaje instance = null;
        List<Modificador> expResult = null;
        List<Modificador> result = instance.obtenerModificadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerFortalezas method, of class Personaje.
     */
    @Test
    public void testObtenerFortalezas() {
        System.out.println("obtenerFortalezas");
        Personaje instance = null;
        List<Modificador> expResult = null;
        List<Modificador> result = instance.obtenerFortalezas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDebilidades method, of class Personaje.
     */
    @Test
    public void testObtenerDebilidades() {
        System.out.println("obtenerDebilidades");
        Personaje instance = null;
        List<Modificador> expResult = null;
        List<Modificador> result = instance.obtenerDebilidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVida method, of class Personaje.
     */
    @Test
    public void testObtenerVida() {
        System.out.println("obtenerVida");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerVida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPoder method, of class Personaje.
     */
    @Test
    public void testObtenerPoder() {
        System.out.println("obtenerPoder");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerPoder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerEsbirros method, of class Personaje.
     */
    @Test
    public void testObtenerEsbirros() {
        System.out.println("obtenerEsbirros");
        Personaje instance = null;
        Set<Esbirro> expResult = null;
        Set<Esbirro> result = instance.obtenerEsbirros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArmasDisponibles method, of class Personaje.
     */
    @Test
    public void testObtenerArmasDisponibles() {
        System.out.println("obtenerArmasDisponibles");
        Personaje instance = null;
        Set<Arma> expResult = null;
        Set<Arma> result = instance.obtenerArmasDisponibles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArmadurasDisponibles method, of class Personaje.
     */
    @Test
    public void testObtenerArmadurasDisponibles() {
        System.out.println("obtenerArmadurasDisponibles");
        Personaje instance = null;
        Set<Armadura> expResult = null;
        Set<Armadura> result = instance.obtenerArmadurasDisponibles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerHabilidadEspecial method, of class Personaje.
     */
    @Test
    public void testObtenerHabilidadEspecial() {
        System.out.println("obtenerHabilidadEspecial");
        Personaje instance = null;
        HabilidadEspecial expResult = null;
        HabilidadEspecial result = instance.obtenerHabilidadEspecial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerRecurso method, of class Personaje.
     */
    @Test
    public void testObtenerRecurso() {
        System.out.println("obtenerRecurso");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerRecurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAtaqueArmadura method, of class Personaje.
     */
    @Test
    public void testObtenerAtaqueArmadura() {
        System.out.println("obtenerAtaqueArmadura");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerAtaqueArmadura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDefensaArmadura method, of class Personaje.
     */
    @Test
    public void testObtenerDefensaArmadura() {
        System.out.println("obtenerDefensaArmadura");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerDefensaArmadura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAtaqueArmas method, of class Personaje.
     */
    @Test
    public void testObtenerAtaqueArmas() {
        System.out.println("obtenerAtaqueArmas");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerAtaqueArmas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDefensaArmas method, of class Personaje.
     */
    @Test
    public void testObtenerDefensaArmas() {
        System.out.println("obtenerDefensaArmas");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerDefensaArmas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerOro method, of class Personaje.
     */
    @Test
    public void testObtenerOro() {
        System.out.println("obtenerOro");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerOro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerSumaRecurso method, of class Personaje.
     */
    @Test
    public void testObtenerSumaRecurso() {
        System.out.println("obtenerSumaRecurso");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerSumaRecurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerMaxRecurso method, of class Personaje.
     */
    @Test
    public void testObtenerMaxRecurso() {
        System.out.println("obtenerMaxRecurso");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.obtenerMaxRecurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerPuntosRecurso method, of class Personaje.
     */
    @Test
    public void testPonerPuntosRecurso() {
        System.out.println("ponerPuntosRecurso");
        int recurso = 0;
        Personaje instance = null;
        instance.ponerPuntosRecurso(recurso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerArmasActivas method, of class Personaje.
     */
    @Test
    public void testPonerArmasActivas() {
        System.out.println("ponerArmasActivas");
        Collection<Arma> armas = null;
        Personaje instance = null;
        instance.ponerArmasActivas(armas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerArmaduraActiva method, of class Personaje.
     */
    @Test
    public void testPonerArmaduraActiva() {
        System.out.println("ponerArmaduraActiva");
        Armadura armadura = null;
        Personaje instance = null;
        instance.ponerArmaduraActiva(armadura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerEsbirros method, of class Personaje.
     */
    @Test
    public void testPonerEsbirros() {
        System.out.println("ponerEsbirros");
        Set<Esbirro> esbirros = null;
        Personaje instance = null;
        instance.ponerEsbirros(esbirros);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerHabilidadEspecial method, of class Personaje.
     */
    @Test
    public void testPonerHabilidadEspecial() {
        System.out.println("ponerHabilidadEspecial");
        HabilidadEspecial hab = null;
        Personaje instance = null;
        instance.ponerHabilidadEspecial(hab);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumarOro method, of class Personaje.
     */
    @Test
    public void testSumarOro() {
        System.out.println("sumarOro");
        int i = 0;
        Personaje instance = null;
        int expResult = 0;
        int result = instance.sumarOro(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumarRecurso method, of class Personaje.
     */
    @Test
    public void testSumarRecurso() {
        System.out.println("sumarRecurso");
        int recurso = 0;
        Personaje instance = null;
        instance.sumarRecurso(recurso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularPotencialAtaque method, of class Personaje.
     */
    @Test
    public void testCalcularPotencialAtaque() {
        System.out.println("calcularPotencialAtaque");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.calcularPotencialAtaque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularPotencialDefensa method, of class Personaje.
     */
    @Test
    public void testCalcularPotencialDefensa() {
        System.out.println("calcularPotencialDefensa");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.calcularPotencialDefensa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularVida method, of class Personaje.
     */
    @Test
    public void testCalcularVida() {
        System.out.println("calcularVida");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.calcularVida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of puedeUsarHabilidad method, of class Personaje.
     */
    @Test
    public void testPuedeUsarHabilidad() {
        System.out.println("puedeUsarHabilidad");
        Personaje instance = null;
        boolean expResult = false;
        boolean result = instance.puedeUsarHabilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usarHabilidad method, of class Personaje.
     */
    @Test
    public void testUsarHabilidad() {
        System.out.println("usarHabilidad");
        Personaje instance = null;
        instance.usarHabilidad();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarRecurso method, of class Personaje.
     */
    @Test
    public void testModificarRecurso() {
        System.out.println("modificarRecurso");
        Personaje instance = null;
        instance.modificarRecurso();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recibirDanio method, of class Personaje.
     */
    @Test
    public void testRecibirDanio() {
        System.out.println("recibirDanio");
        Personaje instance = null;
        instance.recibirDanio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hacerDanio method, of class Personaje.
     */
    @Test
    public void testHacerDanio() {
        System.out.println("hacerDanio");
        Personaje instance = null;
        instance.hacerDanio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reestablecerPersonaje method, of class Personaje.
     */
    @Test
    public void testReestablecerPersonaje() {
        System.out.println("reestablecerPersonaje");
        Personaje instance = null;
        instance.reestablecerPersonaje();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerNombre method, of class Personaje.
     */
    @Test
    public void testPonerNombre() {
        System.out.println("ponerNombre");
        String n = "";
        Personaje instance = null;
        instance.ponerNombre(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerDescripcion method, of class Personaje.
     */
    @Test
    public void testPonerDescripcion() {
        System.out.println("ponerDescripcion");
        String d = "";
        Personaje instance = null;
        instance.ponerDescripcion(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerVida method, of class Personaje.
     */
    @Test
    public void testPonerVida() {
        System.out.println("ponerVida");
        int v = 0;
        Personaje instance = null;
        instance.ponerVida(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerPoder method, of class Personaje.
     */
    @Test
    public void testPonerPoder() {
        System.out.println("ponerPoder");
        int p = 0;
        Personaje instance = null;
        instance.ponerPoder(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerArmasDisponibles method, of class Personaje.
     */
    @Test
    public void testPonerArmasDisponibles() {
        System.out.println("ponerArmasDisponibles");
        List<Arma> armas = null;
        Personaje instance = null;
        instance.ponerArmasDisponibles(armas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerArmadurasDisponibles method, of class Personaje.
     */
    @Test
    public void testPonerArmadurasDisponibles() {
        System.out.println("ponerArmadurasDisponibles");
        List<Armadura> armaduras = null;
        Personaje instance = null;
        instance.ponerArmadurasDisponibles(armaduras);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerModificadores method, of class Personaje.
     */
    @Test
    public void testPonerModificadores() {
        System.out.println("ponerModificadores");
        List<Modificador> mods = null;
        Personaje instance = null;
        instance.ponerModificadores(mods);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Personaje.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PersonajeImpl extends Personaje {

        public PersonajeImpl() {
            super("", null);
        }

        public void modificarRecurso() {
        }
    }
    
}
