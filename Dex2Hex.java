import java.util.logging.Logger;
import java.util.logging.Level;


 class Dex2Hex {
    public static void main(String args[]) {

        private static final Logger logger = Logger.getLogger(Dex2Hex.class.getName());


	// Check if no input is provided
        public static void main(String[] args) {
        if (args.length == 0) {
            logger.severe("Error: No input provided. Please enter an integer value.");
            System.exit(1); // Exit or handle as appropriate
        }

        int arg1;
        try {
            // Attempt to parse the input as an integer
            arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Non-integer input provided. Please enter a valid integer value.");
            return;
        }

        // Proceed with the hex conversion if input is valid
        char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rem, num = arg1;
        String hexadecimal = "";

        System.out.println("Converting the Decimal Value " + num + " to Hex...");

        while (num != 0) {
            rem = num % 16;
            hexadecimal = ch[rem] + hexadecimal;
            num = num / 16;
        }

        System.out.println("Hexadecimal representation is: " + hexadecimal);
        
    }
}

