package test;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import test.util.Utility;

public class ExecutionListener extends RunListener {
    @Override
    public void testStarted(Description description) {
        Utility.println("-----");
    }

    @Override
    public void testFinished(Description description) {
        Utility.println("FINISH: " + description.getMethodName());
    }

    @Override
    public void testFailure(Failure failure) {
        Utility.println("FAIL: " + failure.getDescription().getMethodName());
    }

    @Override
    public void testIgnored(Description description) {
        Utility.println("IGNORE: " + description.getMethodName());
    }
}
