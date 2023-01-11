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

    /**
     * Get parameter with the given key.
     * @param key
     * @return Generic {@link Parameter}, return null if not found.
     */
    public Parameter get(String key) {
        // Can cast params is implicitly Map<Parameter>, but this syntax is not supported by XCompiler
        return (Parameter) params.get(key);
    }


    public void set(String key, Parameter param) {
        // TODO: better explanation or structure of why checks may or may not be needed (due to previous checks on higher classes)
        params.put(key, param);
    }

    public Boolean getBool(String key) {
        Parameter param = get(key);
        
        if (param instanceof BooleanParam) {
            return ((BooleanParam) param).getValue(); 
        } else { // if null or not expected type, etc.
            throw new NotFoundException(key, "Could not find as a boolean parameter");
        }
    }

    public int getInt(String key) {
        Parameter param = get(key);
        
        if (param instanceof IntegerParam) {
            return ((IntegerParam) param).getValue(); 
        } else { // if null or not expected type, etc.
            throw new NotFoundException(key, "Could not find as a integer parameter");
        }
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
