package com.uninorte.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuerpoDeAguaTest {

    /**
     * Test of index method, of class CuerpoDeAgua.
     */
    @Test
    public void testIndex() {
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
        CuerpoDeAgua instance = new CuerpoDeAgua("Test", 0, "Test 2", "Test 3","Test 4", 12.5f);
        String expResult = "BAJO";
        String result = instance.nivel();
        assertEquals(expResult, result);
    }
}