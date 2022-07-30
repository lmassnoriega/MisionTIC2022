package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import main.reto3;

/**
 *
 * @author Locke
 */
public class Reto3Test {

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

    /**
     * Test of main method, of class reto3.
     */
    @Test
    public void testMain() throws Exception {
        final String testInput = "2\nMallorquin 0 Barranquilla Cienaga Dulce 30\nMagdalena 1 Barranquilla Rio Dulce 45.3";
        provideInput(testInput);
        reto3.main(new String[0]);
        assertEquals("""
                30.00\r
                45.30\r
                0.00\r
                NA\r
                37.65\r
                """, outContent.toString());
    }

}
