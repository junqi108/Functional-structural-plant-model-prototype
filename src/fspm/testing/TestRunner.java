package fspm.testing;

import java.util.ArrayList;
import java.util.List;

import fspm.util.*;

import Utils;

public class TestRunner {
    private static List tests = new ArrayList();

    public static void runTests() {
        for (UnitTest test : tests) {
            Utils.print("Running test: " + test.getClass().getName());
            test.setup();
            test.run();
        }
    }

    public static void addTest(UnitTest test) {
        tests.add(test);
    }
}
