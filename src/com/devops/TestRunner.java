package com.devops;


import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TestRunner {

    private static final Logger logger = Logger.getLogger(TestRunner.class.getName()); // Logger instance specifically for the TestRunner class

    public static void main(String[] args) {
	// Run all tests in the Dex2HexTest class and store the result
        Result result = JUnitCore.runClasses(Dex2HexTest.class);
        int fails = 0; // Counter to track the number of test failures
        
        try {
		// Loop through each test failure in the result
            for (Failure failure : result.getFailures()) {
		// Log each failure's details at SEVERE level
                logger.severe(failure.toString());
                fails++;
            }

            // Check if any tests failed
           if (fails > 0) {

		// Log the total number of failed tests if logging level SEVERE is enabled
    		if (logger.isLoggable(Level.SEVERE)) {
        	logger.severe(String.format("%d tests failed", fails));
    	} 	
		System.exit(1); // Exit the program with a non-zero status to indicate failure
	} else {

	   if (logger.isLoggable(Level.INFO)) { // If all tests passed, log a success message at INFO level
	        logger.info("All tests passed successfully.");
    }
	   System.exit(0); // Exit the program with a zero status to indicate success
}



        } catch (Exception e) {

		// Log any unexpected exceptions that occur during test execution
            logger.log(Level.SEVERE, "An error occurred during test execution: ", e);
            System.exit(1); // Exit with error status in case of exception
        }
    }
}
