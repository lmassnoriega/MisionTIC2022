package com.uninorte.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Locke
 */
public class Reto3Test {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final InputStream systemIn = System.in;

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void tearDown() {
        System.setOut(originalOut);
        System.setIn(systemIn);
    }

    public void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Test of main method, of class reto3.
     */
    @Test
    public void testMain() throws Exception {
        final String testInput = "2\nMallorquin 0 Barranquilla Cienaga Dulce 30\nMagdalena 1 Barranquilla Rio Dulce 45.3";
        provideInput(testInput);
        reto3.main(new String[0]);
        assertEquals("30.00\n45.30\n0.00\nNA\n37.65\n", outContent.toString());
    }

}