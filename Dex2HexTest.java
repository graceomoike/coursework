import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

public class Dex2HexTest {

    private static final Logger logger = Logger.getLogger(Dex2HexTest.class.getName());

    @Before
    public void setUp() {
        // No instantiation of Dex2Hex required if we're only testing its static main method
    }

    @Test
    public void testWhenValidIntegerInput() {
        String[] args = {"156"};
        String output = getOutput(args);

        assertTrue(output.contains("Converting the Decimal Value 156 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: 9C"));
    }

    @Test 
    public void testWhenNoInput() {
        String[] args = {};
        String output = getOutput(args);

        assertTrue(output.contains("Error: No input provided. Please enter an integer value."));
    }

    @Test
    public void testWhenNonIntegerInput() {
        String[] args = {"abc"};
        String output = getOutput(args);

        assertTrue(output.contains("Error: Non-integer input provided. Please enter a valid integer value."));
    }

    // Utility method to capture console output with input arguments
    private String getOutput(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));  // Temporarily redirect System.out

        try {
            Dex2Hex.main(args);  // Run main with redirected output
        } finally {
            System.setOut(originalOut);  // Restore original System.out
        }

        return outputStream.toString();
    }
}


