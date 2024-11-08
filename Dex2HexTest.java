import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.util.logging.*;

public class Dex2HexTest {

    private final Logger logger = Logger.getLogger(Dex2Hex.class.getName());
    private ByteArrayOutputStream logOutput;
    private StreamHandler logHandler;

    @Before
    public void setUp() {
        logOutput = new ByteArrayOutputStream();
        logHandler = new StreamHandler(logOutput, new SimpleFormatter());
        logger.addHandler(logHandler);
    }

    @Test
    public void testWhenValidIntegerInput() {
        String[] args = {"156"};
        runDex2HexWithArgs(args);

        String output = getLoggerOutput();
        assertTrue(output.contains("Converting the Decimal Value 156 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: 9C"));
    }

    @Test 
    public void testWhenNoInput() {
        String[] args = {};
        runDex2HexWithArgs(args);

        String output = getLoggerOutput();
        assertTrue(output.contains("Error: No input provided. Please enter an integer value."));
    }

    @Test
    public void testWhenNonIntegerInput() {
        String[] args = {"abc"};
        runDex2HexWithArgs(args);

        String output = getLoggerOutput();
        assertTrue(output.contains("Error: Non-integer input provided. Please enter a valid integer value."));
    }

    // Helper method to run Dex2Hex and capture logger output
    private void runDex2HexWithArgs(String[] args) {
        logOutput.reset(); // Clear the previous log output
        Dex2Hex.main(args);
        logHandler.flush(); // Ensure all log messages are written to the stream
    }

    // Method to retrieve the logger output as a String
    private String getLoggerOutput() {
        return logOutput.toString();
    }
}



