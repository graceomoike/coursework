import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Dex2HexTest {

    public Dex2HexTest() {}

    Dex2Hex dex2hex;

    @Before
    public void setUp() {
        dex2hex = new Dex2Hex();
    }

    @Test
    public void testWhenValidIntegerInput() {
        // Simulate valid integer input
        String[] args = {"156"};
        String output = getOutput(args);

        // Validate hexadecimal conversion output
        assertTrue(output.contains("Converting the Decimal Value 156 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: FF"));
        assertTrue(output.contains("The number has been converted successfully!"));
    }

    @Test 
    public void testWhenNoInput() {
        // Simulate no input scenario
        String[] args = {};
        String output = getOutput(args);  // Use getOutput to capture console output

        // Validate output message for no input
        assertTrue(output.contains("Error: No input was given"));
    }

    @Test
    public void testWhenNonIntegerInput() {
        // Simulate non-integer input scenario
        String[] args = {"abc"};
        String output = getOutput(args);  // Use getOutput to capture console output

        // Validate output message for non-integer input
        assertTrue(output.contains("Error: Non-integer input was given"));
    }

    // Utility method to capture console output with input arguments
    private String getOutput(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run Dex2Hex with the specified args
        Dex2Hex.main(args);

        // Restore original System.out
        System.setOut(originalOut);

        return outputStream.toString();
    }
}

