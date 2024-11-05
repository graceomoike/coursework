import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

	public Dex2HexTest()
	{}
	Dex2Hex dex2hex;
	
	@Before
	public void setUp() {
	dex2hex = new Dex2Hex();
	}

        @Test 
	public void testWhenNoInput() {
        // Simulate no input scenario
        String[] args = {};
        Dex2Hex.main(args);
        // Validate output message for no input
        assertTrue(getOutput().contains("Error: No input provided"));
    
   	 }
	@Test
    	public void testWhenNonIntegerInput() {
        // Simulate non-integer input scenario
        String[] args = {"abc"};
        Dex2Hex.main(args);
        // Validate output message for non-integer input
        assertTrue(getOutput().contains("Error: Non-integer input provided"));
    	}

	private String getOutput() {
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	PrintStream originalOut = System.out;
    	System.setOut(new PrintStream(outputStream));
    	// Run the code that outputs to console here
    	System.setOut(originalOut);
    	return outputStream.toString();
}

	}
