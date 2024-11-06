import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail; 

class Dex2Hex
{
public static int Arg1;
    public static void main(String args[])    {

	 if (args.length == 0) {
            System.out.println("Error: No input provided. Please enter an integer value.");
            return;
        }

        try {
            Arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Non-integer input provided. Please enter a valid integer value.");
            return;
        }

        Arg1 = Integer.parseInt(args[0]);
        char ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem, num;
        num = Arg1;
        String hexadecimal="";
        System.out.println("Converting the Decimal Value " + num + " to Hex...");

        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }

        System.out.println("Hexadecimal representation is: " + hexadecimal);
	System.out.println("The number has been converted succesfully!");
    }
}
