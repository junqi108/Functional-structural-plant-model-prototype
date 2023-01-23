package fspm.testing;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Test;

import fspm.testing.tests.ParamsUnitTest;
import fspm.util.*;

public class TestRunner {
    public static void runTests() {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        
        Result result = junit.run(
            ParamsUnitTest.class
        );

        reportResult(result);
            
    }

    // TODO: format test result output
    public static void reportResult(Result result) {
        Utility.println("Finished. Result: Failures: " +
            result.getFailureCount() + ". Ignored: " +
            result.getIgnoreCount() + ". Tests run: " +
            result.getRunCount() + ". Time: " +
            result.getRunTime() + "ms.");
    }
}
