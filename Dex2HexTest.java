import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.*;
import org.junit.*;

public class Dex2HexTest {
    private static final Logger logger = Logger.getLogger(Dex2HexTest.class.getName());
    private ByteArrayOutputStream logStream;
    private StreamHandler testHandler;

    @Before
    public void setUp() {
        logStream = new ByteArrayOutputStream();

        // Custom formatter to capture only the message
        testHandler = new StreamHandler(new PrintStream(logStream), new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord logRecord) {
                return logRecord.getMessage() + "\n";
            }
        });

        // Add handler to both Dex2HexTest logger and Dex2Hex logger to capture both
        Logger dex2HexLogger = Logger.getLogger(Dex2Hex.class.getName());
        dex2HexLogger.addHandler(testHandler);
        dex2HexLogger.setUseParentHandlers(false); // Avoids duplicate logs

        logger.addHandler(testHandler);
        logger.setUseParentHandlers(false);
    }

    @After
    public void tearDown() {
        logger.removeHandler(testHandler);
        Logger.getLogger(Dex2Hex.class.getName()).removeHandler(testHandler);
    }

    @Test
    public void testHexadecimalConversion() {
        String[] args = {"255"};
        captureLoggerOutput(() -> Dex2Hex.main(args));

        // Check if the correct log messages appear for a valid conversion
        String output = logStream.toString().trim();
        assertTrue(output.contains("Converting the Decimal Value 255 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: FF"));
    }

    @Test
    public void testNonIntegerInputError() {
        String[] args = {"abc"};
        captureLoggerOutput(() -> Dex2Hex.main(args));

        // Check for the appropriate error message for non-integer input
        String output = logStream.toString().trim();
        assertTrue(output.contains("Error: Non-integer input provided. Please enter a valid integer value."));
    }

    @Test
    public void testNoInputError() {
        String[] args = {};
        captureLoggerOutput(() -> Dex2Hex.main(args));

        // Check for the appropriate error message when no input is provided
        String output = logStream.toString().trim();
        assertTrue(output.contains("Error: No input provided. Please enter an integer value."));
    }

    private void captureLoggerOutput(Runnable action) {
        testHandler.flush(); // Ensure previous logs are flushed
        logStream.reset(); // Clear the log stream
        action.run();
        testHandler.flush(); // Ensure all logs are captured
    }
}
