package fspm.config.params;

import java.util.HashMap;
import java.util.Map;

import fspm.util.Utility;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.NotFoundException;

public class ParamCategory {
    private String key;
    private Map params;

    public ParamCategory(String key) {
        this.key = key;
        this.params = new HashMap();
    }

    public String getKey() {
        return key;
    }

    public void add(Parameter param) {
        // Use parameter key as unique identifier
        if (params.containsKey(param.getKey())) {
            throw new KeyConflictException(param.getKey());
        } else {
            params.put(param.getKey(), param);
        }
    }

    public Parameter getParam(String paramKey) {
        // Can cast params is implicitly Map<Parameter>, but this syntax is not supported by XCompiler
        Parameter param = (Parameter) params.get(paramKey);

        if (param != null) {
            return param;
        }
        throw new NotFoundException(paramKey);
    }

    @Override
    public String toString() {
        String format = "Category: " + key + "\n";

        for (Parameter param : params.values()) {
            format += "- " + param + "\n";
        }

        return format;
    }
}
