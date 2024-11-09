package com.devops;


import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TestRunner {

    private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Dex2HexTest.class);
        int fails = 0;
        
        try {
            for (Failure failure : result.getFailures()) {
                logger.severe(failure.toString());
                fails++;
            }
            
           if (fails > 0) {
    		if (logger.isLoggable(Level.SEVERE)) {
        	logger.severe(String.format("%d tests failed", fails));
    	}
    	    System.exit(1);
	} else {
	   if (logger.isLoggable(Level.INFO)) {
	        logger.info("All tests passed successfully.");
    }
	   System.exit(0);
}



        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during test execution: ", e);
            System.exit(1);
        }
    }
}
