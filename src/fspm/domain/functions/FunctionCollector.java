package fspm.domain.functions;

import java.util.ArrayList;
import java.util.List;

public class FunctionCollector {
    // XCompiler unable to compile <> with type <IFunction>, so left generic
    private List functions;

    public FunctionCollector() {
        init();
    }

    public void init() {
        functions = new ArrayList();
    }

    public void run() {
        for (IFunction function : functions) {
            function.run();
        }
    }

    public void add(IFunction function) {
        functions.add(function);
    }

    public List getFunctions() {
        return functions;
    }
}