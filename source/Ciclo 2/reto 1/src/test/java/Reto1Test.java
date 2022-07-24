package test.java;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.reto1;

public class Reto1Test {
    String[] categories = { "SIN RIESGO", "BAJO", "MEDIO", "ALTO", "INVIABLE SANITARIAMENTE" };

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
    public void testCategory() {

        // Test "SIN RIESGO"
        assertEquals(0, reto1.category(4.5f));
        // Test "BAJO"
        assertEquals(1, reto1.category(10.5f));
        // Test "MEDIO"
        assertEquals(2, reto1.category(15.6f));
        // Test "ALTO"
        assertEquals(3, reto1.category(36.3f));
        // Test "INVIABLE SANITARIAMENTE"
        assertEquals(4, reto1.category(100f));
    }

    @Test
    public void testGetCategoryName() {
        for (int i = 0; i < categories.length; i++) {
            assertEquals(categories[i], reto1.getCategoryName(i));
        }
    }

    @Test
    public void testMain() throws Exception {
        final String testInput = "6\n5.1 36 25 70 55 18";
        provideInput(testInput);
        reto1.main(new String[0]);
        assertEquals("""
                MEDIO\r
                34.85\r
                ALTO\r
                """, outContent.toString());
    }
}
