package fspm.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import barrypitman.junitXmlFormatter.AntXmlRunListener;

import fspm.testing.tests.config.ParamConfigTestSuite;
import fspm.testing.tests.config.ParamsUnitTest;
import fspm.util.*;

public class TestRunner {
    public static void run() {
        runTests(
            // ParamConfigTestSuite.class, // FIXME: suite produces "no runnable methods" error
            ParamsUnitTest.class
        );
    }

    public static void runTests(Class ...classes) {
        JUnitCore junit = new JUnitCore();

        // Setup listeners
        junit.addListener(new TextListener(System.out));

        AntXmlRunListener runListener = new AntXmlRunListener();
        try {
            runListener.setOutputStream(new FileOutputStream(
                new File("/var/model/outputs/test_out.xml")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        junit.addListener(runListener);
        
        // Run tests
        Result result = junit.run(classes);
        reportResult(result);
            
    }

    public static void reportResult(Result result) {
        for (Failure failure : result.getFailures()) {
            Utility.println(
                failure.toString() + "\n" +
                failure.getTrimmedTrace()
            );
            
        }
        Utility.println("Finished. Result: Failures: " +
            result.getFailureCount() + ". Ignored: " +
            result.getIgnoreCount() + ". Tests run: " +
            result.getRunCount() + ". Time: " +
            result.getRunTime() + "ms."
        );
    }
}
