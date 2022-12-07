package fspm.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import fspm.exceptions.ParamNotFoundException;

public class ParamContainer {
    // Implicitly of their specified types defined using e.g: Map<String, Boolean>
    private Map booleanParams;
    private Map intParams;
    private Map doubleParams;
    private Map stringParams;

    // TODO: use ArrayNodes and NodeFactory to store all types of params and use get(), instead of requiring maps for each type
    private ArrayNode params;

    public ParamContainer() {
        // booleanParams = new HashMap();
        // intParams = new HashMap();
        // doubleParams = new HashMap();
        // stringParams = new HashMap();

        params = JsonNodeFactory.instance.arrayNode();
    }

    public void addNode(JsonNode node) {
        params.add(node);
    }

    public JsonNode get(String key) {
        return params.get(key);
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
