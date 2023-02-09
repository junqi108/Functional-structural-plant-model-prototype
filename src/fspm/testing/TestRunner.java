package fspm.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import barrypitman.junitXmlFormatter.AntXmlRunListener;
import fspm.testing.tests.config.ParamConfigTest;
import fspm.testing.tests.config.ParamConfigTestSuite;
import fspm.util.*;

public class TestRunner {

    private static String xmlOutputPath = "/var/model/outputs/test_out.xml";

    public static void run() {
        runTests(
            /** FIXME: Suite produces "no runnable methods" error
             */ 
            // ParamConfigTestSuite.class

            ParamConfigTest.class
        );
    }

    public static void runTests(Class ...classes) {
        JUnitCore junit = new JUnitCore();

        // ===== Setup listeners
        junit.addListener(new TextListener(System.out));
        junit.addListener(new ExecutionListener());

        // Listener required for outputting result in XML
        AntXmlRunListener runListener = new AntXmlRunListener();
        try {
            runListener.setOutputStream(new FileOutputStream(
                new File(xmlOutputPath)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        junit.addListener(runListener);
        
        // ===== Run tests
        Result result = junit.run(classes);
        reportResult(result);
            
    }

    private static void reportResult(Result result) {
        Utility.println("\n===== Failures ===== \n");

        for (Failure failure : result.getFailures()) {
            Utility.println(
                failure.toString() + "\n" +
                failure.getTrimmedTrace()
            );
            
        }

        Utility.println("\n===== Summary ===== \n");

        Utility.println("Finished. Result: Failures: " +
            result.getFailureCount() + ". Ignored: " +
            result.getIgnoreCount() + ". Tests run: " +
            result.getRunCount() + ". Time: " +
            result.getRunTime() + "ms."
        );
    }
}
