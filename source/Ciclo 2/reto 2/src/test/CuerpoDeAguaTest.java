package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.CuerpoDeAgua;

public class CuerpoDeAguaTest {
    
    /**
     * Test of index method, of class CuerpoDeAgua.
     */
    @Test
    public void testIndex() {
        System.out.println("index");
        String categoryName = "ALTO";
        int expResult = 3;
        int result = CuerpoDeAgua.index(categoryName);
        assertEquals(expResult, result);
    }

    /**
     * Test of nivel method, of class CuerpoDeAgua.
     */
    @Test
    public void testNivel() {
        System.out.println("nivel");
        CuerpoDeAgua instance = new CuerpoDeAgua("Test", 0, "Test 2", 12.5f);
        String expResult = "BAJO";
        String result = instance.nivel();
        assertEquals(expResult, result);
    }
}
