import org.junit.*;
import java.lang.Exception;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.logging.Logger;
import java.util.logging.Level;

private static final Logger logger = Logger.getLogger(YourClassName.class.getName());


public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Dex2HexTest.class);
		int fails = 0;
		try {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
				fails++;

		    }
			if (fails > 0) {
			    logger.severe(fails + " tests failed");
			    System.exit(1);
	            } else {
    			logger.info("All tests passed successfully.");
    			System.exit(0);
		    }



}
}
}
