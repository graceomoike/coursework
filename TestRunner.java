import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.Exception;


public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Dex2HexTest.class);
        int fails = 0;
	try{        
        // Loop through failures and count them
       		 for (Failure failure : result.getFailures()) {
            		System.out.println(failure.toString());
            		fails++;
         	}
        	if (fails > 0)
			throw new Exception();
		System.out.println(result.wasSuccessful());
	}
	catch(Exception e)
        {
            System.out.println("" + fails + " tests failed");
            System.exit(1);  // Exit with error code if tests failed
        } 
            System.exit(0);  // Exit with success code if all tests passed
        
    }
}

