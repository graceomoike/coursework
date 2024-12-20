package com.devops;

import java.util.logging.Logger;

class Dex2Hex {

    // Initialise  logger instance for Dex2Hex class
    private static final Logger logger = Logger.getLogger(Dex2Hex.class.getName());

    public static void main(String[] args) {

        // Check if no input is provided
        if (args.length == 0) {
            logger.severe("Error: No input provided. Please enter an integer value.");
            return;
        }
	// Try to parse the input argument as  integer
        int arg1;
        try {
            arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.severe("Error: Non-integer input provided. Please enter a valid integer value."); // Log an error if the input is not a valid integer
            return; // Exit the program if  input is invalid
        }

        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int num = arg1;
        int rem; // Variable to store remainder during conversion

        // Use StringBuilder for hexadecimal construction
        StringBuilder hexadecimal = new StringBuilder();

        // Conditionally log conversion start message
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Converting the Decimal Value %d to Hex...", num));
        }
 	// Perform the decimal to hexadecimal conversion
        while (num != 0) {
            rem = num % 16;
            hexadecimal.insert(0, ch[rem]);
            num = num / 16;
        }

        // Conditionally log final hexadecimal result
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Hexadecimal representation is: %s", hexadecimal.toString()));
        }
    }
}
