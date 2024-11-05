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
	 public void testMainWithNoInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {};  // No arguments provided
        Dex2Hex.main(args);

        String expectedOutput = "Error: No input provided Please provide an integer input.\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
