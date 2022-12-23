package fspm.testing;

import java.util.ArrayList;
import java.util.List;

import fspm.util.*;

public class TestRunner {
    private static List tests = new ArrayList();

    public static void runTests() {
        for (UnitTest test : tests) {
            Utility.println("Running test: " + test.getClass().getName());
            test.setup();
            test.run();
        }
    }

    public static void addTest(UnitTest test) {
        tests.add(test);
    }
}
