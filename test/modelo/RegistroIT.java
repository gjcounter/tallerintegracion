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

    @Test
    public void testAgregar() {
        System.out.println("agregar");
        int codigo = 123456;
        int categoria = 3;
        String nombre = "Pelicula de Prueba";
        int precio = 5000;
        String formato4k = "N"; // "S" ó "N"
        Registro instance = new Registro();
        boolean expResult = true; // true si se realiza exitosamente
        boolean result = instance.agregar(codigo, categoria, nombre, precio, formato4k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
	
	@Test
    public void testAgregarcategoria() {
        System.out.println("agregarcategoria");
        String descripcion = "Papitas Fritas";
        Registro instance = new Registro();
        boolean expResult = true; // true si es exitoso
        boolean result = instance.agregarcategoria(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
	
	 @Test
    public void testBuscarpeliculastexto() {
        System.out.println("buscarpeliculastexto");
        String texto = "consulta"; // 2 registros -> "Pelicula de Consulta 5" y "Prueba de consulta 2" con id [55555, 666666]
        Registro instance = new Registro();
        int[] expResult = {55555, 666666}; // resultado esperado
        int[] result = instance.buscarpeliculastexto(texto);
        
        System.out.println("----mis outputs-----");
        System.out.println(Arrays.toString(expResult));
        System.out.println(Arrays.toString(result));
         
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
	
	 @Test
    public void testBuscarpeliculacategoria() {
        System.out.println("buscarpeliculacategoria");
        String descripcion = "Largometraje"; // categoria 1
        Registro instance = new Registro();
        int[] expResult = {10001, 10002}; //  The Martian -> id 10001  y Old Boy -> id 10002
        int[] result = instance.buscarpeliculacategoria(descripcion);
        
        System.out.println("----mis outputs-----");
        System.out.println(Arrays.toString(expResult));
        System.out.println(Arrays.toString(result));
        
        
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
	
 
   

    /**
     * Test of cambiarcategoria method, of class Registro.
     */
    @Test
    public void testCambiarcategoria() {
        System.out.println("cambiarcategoria");
        int codigopelicula = 70002; // titanic
        String descripcion = "Nueva Categoria"; // descripcion de categoria 
        Registro instance = new Registro();
        boolean expResult = false; // true si la categoria existe, false si no existe
        boolean result = instance.cambiarcategoria(codigopelicula, descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
  

   

    
}
