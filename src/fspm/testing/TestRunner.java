package fspm.testing;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import fspm.testing.tests.config.ParamConfigTestSuite;
import fspm.testing.tests.config.ParamsUnitTest;
import fspm.util.*;

public class TestRunner {
    public static void runTests() {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        
        Result result = JUnitCore.runClasses(
            // ParamConfigTestSuite.class, // FIXME: suite produces "no runnable methods" error
            ParamsUnitTest.class
        );

        reportResult(result);
            
    }

    // TODO: format test result output
    public static void reportResult(Result result) {
        for (Failure failure : result.getFailures()) {
            Utility.println(failure.toString());
        }
        Utility.println("Finished. Result: Failures: " +
            result.getFailureCount() + ". Ignored: " +
            result.getIgnoreCount() + ". Tests run: " +
            result.getRunCount() + ". Time: " +
            result.getRunTime() + "ms.");
    }
}
