import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Dex2HexTest {

	public Dex2HexTest();
	{}
	Dex2Hex dex2hex;
	
	@Before
	public void setUp() {
	dex2hex = new Dex2HexTest
	}

        @Test 
	void testWhenNoInput() {
        // Simulate no input scenario
        String[] args = {};
        Dex2Hex.main(args);
        // Validate output message for no input
        assertTrue(getOutput().contains("Error: No input provided"));
    
   	 }
	@Test
    	void testWhenNonIntegerInput() {
        // Simulate non-integer input scenario
        String[] args = {"abc"};
        Dex2Hex.main(args);
        // Validate output message for non-integer input
        assertTrue(getOutput().contains("Error: Non-integer input provided"));
   	 }

	}
