/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Duoc UC
 */
public class RegistroIT {
    
    public RegistroIT() {
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
     * Test of buscarpeliculastexto method, of class Registro.
     */
    @Test
    public void testBuscarpeliculastexto() {
        System.out.println("buscarpeliculastexto");
        String texto = "consulta"; // 2 registros con id [55555, 666666]
        Registro instance = new Registro();
        int[] expResult = null;
        int[] result = instance.buscarpeliculastexto(texto);
        
        System.out.println(Arrays.toString(expResult));
        System.out.println(Arrays.toString(result));
         
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
