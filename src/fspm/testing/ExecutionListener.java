package fspm.testing;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import fspm.util.Utility;

public class ExecutionListener extends RunListener {
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
