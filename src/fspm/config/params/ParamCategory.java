package fspm.config.params;

import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.BooleanControl;

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


    public Boolean getBool(String key) {
        BooleanParam param = (BooleanParam) getIfMatching(key, BooleanParam.class);
        return param.getValue();
    }

    public int getInt(String key) {
        IntegerParam param = (IntegerParam) getIfMatching(key, IntegerParam.class);
        return param.getValue();
    }




    public void set(String key, boolean newValue) {
        BooleanParam newParam = (BooleanParam) getIfMatching(key, BooleanParam.class);

        newParam.setValue(newValue);
        set(key, newParam);
    }

    public void set(String key, int newValue) {
        IntegerParam newParam = (IntegerParam) getIfMatching(key, IntegerParam.class);

        newParam.setValue(newValue);
        set(key, newParam);
    }

    /**
     * Set parameter with the given key to the provided {@link Parameter}.
     * <p>
     * Private method as parameters should not be directly accessed (set) from outside this class; 
     * prevents overriding parameters with a mismatching type.
     * @param key
     * @param param
     */
    private void set(String key, Parameter param) {
        // TODO: better explanation or structure of why checks may or may not be needed (due to previous checks on higher classes)
        params.put(key, param);
    }

    /**
     * Helper method for getting the parameter of a given key if matches the Paramater type class provided.
     * @param key
     * @param paramTypeClass Concrete class type of {@link Parameter}
     * @return Generic {@link Parameter} if found matching parameter. Throws {@link NotFoundException} otherwise.
     */
    private Parameter getIfMatching(String key, Class paramTypeClass) {
        Parameter param = get(key);
        
        if (paramTypeClass.isInstance(param)) {
            return param;
        } else { // if null or not expected type, etc.
            throw new NotFoundException(key, "Could not find as a " + paramTypeClass + " parameter");
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
