class Dex2Hex {

    public static void main(String[] args) {

        // Check if no input is provided
        if (args.length == 0) {
            System.out.println("Error: No input provided. Please enter an integer value.");
            return; // Exit or handle as appropriate
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
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        // Separate declaration of "num"
        int num = arg1;
        int rem;

        // Use StringBuilder for hexadecimal construction
        StringBuilder hexadecimal = new StringBuilder();

        // Print conversion start with formatted message
        System.out.println(String.format("Converting the Decimal Value %d to Hex...", num));

        while (num != 0) {
            rem = num % 16;
            hexadecimal.insert(0, ch[rem]);  // Prepend the character to the StringBuilder
            num = num / 16;
        }

        // Print the final hexadecimal result
        System.out.println(String.format("Hexadecimal representation is: %s", hexadecimal.toString()));
    }
}



