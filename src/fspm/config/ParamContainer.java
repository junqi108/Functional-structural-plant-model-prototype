package fspm.config;

import java.util.HashMap;
import java.util.Map;

import fspm.exceptions.ParamNotFoundException;

public class ParamContainer {
    // Implicitly of their specified types defined using e.g: Map<String, Boolean>
    private Map booleanParams;
    private Map intParams;
    private Map doubleParams;
    private Map stringParams;

    public ParamContainer() {
        booleanParams = new HashMap();
        intParams = new HashMap();
        doubleParams = new HashMap();
        stringParams = new HashMap();
    }

    public boolean getBoolean(String key) {
        // Need to cast due to XCompiler disallowing <> to define HashMap types
        Boolean value = (Boolean) booleanParams.get(key);

        if (value == null) {
            throw new ParamNotFoundException(key);
        }
        return value;
    }
    /**
     * Add a new or set the value of an existing boolean parameter.
     * @param key
     * @param value
     */
    public void setBoolean(String key, boolean value) {
        booleanParams.put(key, value);
    }
}
