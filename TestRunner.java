import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Dex2HexTest.class);
        int fails = 0;
        
        // Loop through failures and count them
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            fails++;
        }
        
        // Check if any tests failed and print result
        if (fails > 0) {
            System.out.println(fails + " tests failed");
            System.exit(1);  // Exit with error code if tests failed
        } else {
            System.out.println("All tests passed: " + result.wasSuccessful());
            System.exit(0);  // Exit with success code if all tests passed
        }
    }
}

