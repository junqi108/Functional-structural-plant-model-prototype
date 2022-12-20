package fspm.config;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import fspm.util.exceptions.NotFoundException;

public class ParamConfig {
    /**
     * List of parameter categories stored as ObjectNodes.
     * Each parameter is stored inside these ObjectNodes as JsonNodes.
     */
    private List categories; // Assumes params are stored in a 'category' JsonNode

    public ParamConfig() {
        categories = new ArrayList();
    }
    
    public void addCategory(ObjectNode category) {
        categories.add(category);
    }

    // public ObjectNode getCategory(String key) {
    //     ObjectNode category = categories.get(key);

    //     if (category == null) {
    //         throw new NotFoundException(key);
    //     }

    //     return category;
    // }

    /**
     * Get the value of the first occurrence of this key.
     * @param key
     * @return JsonNode of key, null if not found.
     */
    public JsonNode get(String key) {
        ParamLocationInfo param = getParamLocation(key);

        // TODO: consider changing NotFoundException to checked exception if needed
        return param.value;
    }

    /**
     * Get the category and value of the parameter with this key.
     * @param key
     * @return ParamLocationInfo object if found, null if not found.
     */
    private ParamLocationInfo getParamLocation(String key) {
        for (ObjectNode category : categories) {
            JsonNode value = category.get(key);

            if (value != null) {
                // Found key in category
                return new ParamLocationInfo(category, key, value);
            }
        }
        
        throw new NotFoundException(key);
        return null;
    }




    public void set(String key, boolean value) {
        ParamLocationInfo param = getParamLocation(key);

        if (param.type.equals(JsonNodeType.BOOLEAN)) {
            param.category.put(param.key, value);
        } else {
            throw new NotFoundException(param.key, "Could not find parameter of boolean type");
        }
    }

    public void set(String key, String value) {
        ParamLocationInfo param = getParamLocation(key);

        if (param.type.equals(JsonNodeType.STRING)) {
            param.category.put(param.key, value);
        } else {
            throw new NotFoundException(param.key, "Could not find parameter of string type");
        }
    }



    // Overloads for int, double, etc. to convert to JsonNodeType.NUMBER

    public void set(String key, int value) {
        // Convert int to JsonNodeType.NUMBER using .put(int value)
        NumericNode convertedInt = JsonNodeFactory.instance.numberNode(value);
        setNumber(getParamLocation(key), convertedInt);
    }
    public void set(String key, double value) {
        // Convert int to JsonNodeType.NUMBER using .put(double value)
        NumericNode convertedInt = JsonNodeFactory.instance.numberNode(value);
        setNumber(getParamLocation(key), convertedInt);
    }

    /**
     * Set a generic JsonNodeType.NUMBER parameter.
     * @param param
     * @param newValue
     */
    private void setNumber(ParamLocationInfo param, JsonNode newValue) {
        // Check if parameter to be set is also a number type
        if (param.type.equals(JsonNodeType.NUMBER)) {
            param.category.replace(param.key, newValue);
        } else {
            throw new NotFoundException(param.key, "Could not find parameter of number type");
        }
    }

    /**
     * Allows for information about a parameter's storage location (category, key, etc.) 
     * to be passed to methods as a parameter.
     * Only used in this class.
     */
    private class ParamLocationInfo {
        public final ObjectNode category;
        public final String key;
        public final JsonNode value;

        /**
         * Can be derived directly from {@link ParamLocationInfo#value}, but included for
         * readability in conditionals
         */
        public final JsonNodeType type;

        public ParamLocationInfo(ObjectNode category, String key, JsonNode value) {
            this.category = category;
            this.key = key;
            this.value = value;
            this.type = value.getNodeType();
        }
    }
}
