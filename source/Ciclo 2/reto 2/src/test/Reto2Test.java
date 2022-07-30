package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.reto2;

public class Reto2Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final InputStream systemIn = System.in;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testMain() throws Exception {
        final String testInput = "2\nMallorquin 0 Barranquilla 30\nMagdalena 1 Barranquilla 45.3";
        provideInput(testInput);
        reto2.main(new String[0]);
        assertEquals("""
                30.00\r
                45.30\r
                0.00\r
                NA\r
                37.65\r
                """, outContent.toString());
    }
}
