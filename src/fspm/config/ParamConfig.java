package fspm.config;

import java.util.Map;
import java.util.HashMap;

import fspm.config.params.*;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.NotFoundException;
import fspm.util.exceptions.UnsupportedException;

public class ParamConfig {
    /**
     * List of parameter categories stored as ObjectNodes.
     * Each parameter is stored inside these ObjectNodes as JsonNodes.
     */
    private Map categories; // Assumes params are stored in a 'category' JsonNode

    public ParamConfig() {
        categories = new HashMap();
    }
    
    public void addCategory(ParamCategory category) {
        // Use category key as unique identifier
        if (categories.containsKey(category.getKey())) {
            throw new KeyConflictException(category.getKey());
        } else {
            categories.put(category.getKey(), category);
        }
    }

    public ParamCategory getCategory(String key) {
        ParamCategory category = (ParamCategory) categories.get(key);

        if (category != null) {
            return category;
        }
        throw new NotFoundException(key, "Could not find category");
    }

    public Boolean getBool(String key) {
        // TODO: implement if shorthand config.getBool() is desired over config.getCategory().getBool()
        throw new UnsupportedException("Not implemented.");
        // for (ParamCategory category : categories.values()) {
        //     category.getParam(key);
        //     Boolean param = category.getBool(key);

        //     if (param != null) {
        //         // Found key in category
        //         return param;
        //     }
        // }
    }

    public Integer getInt(String key) {
        throw new UnsupportedException("Not implemented.");
        // Parameter param = getParamLocation(key).param;
        
        // if (param instanceof IntegerParam) {
        //     return ((IntegerParam) param).getValue(); 
        // }
        // throw new NotFoundException(key, "Could not find as a integer parameter");
    }



    public void set(String key, boolean value) {
        ParamLocationInfo paramInfo = getParamLocation(key);

        if (paramInfo.param instanceof BooleanParam) {
            ((BooleanParam) paramInfo.param).setValue(value);

            paramInfo.category.setParam(key, paramInfo.param);
            return;
        }
        throw new NotFoundException(key, "Could not find as a boolean parameter");
    }

    public void set(String key, int value) {
        ParamLocationInfo paramInfo = getParamLocation(key);

        if (paramInfo.param instanceof IntegerParam) {
            ((IntegerParam) paramInfo.param).setValue(value);
            
            paramInfo.category.setParam(key, paramInfo.param);
            return;
        }
        throw new NotFoundException(key, "Could not find as an integer parameter");
    }



    // // Overloads for int, double, etc. to convert to JsonNodeType.NUMBER

    // public void set(String key, int value) {
    //     // Convert int to JsonNodeType.NUMBER using .put(int value)
    //     NumericNode convertedInt = JsonNodeFactory.instance.numberNode(value);
    //     setNumber(getParamLocation(key), convertedInt);
    // }
    // public void set(String key, double value) {
    //     // Convert int to JsonNodeType.NUMBER using .put(double value)
    //     NumericNode convertedInt = JsonNodeFactory.instance.numberNode(value);
    //     setNumber(getParamLocation(key), convertedInt);
    // }

    // /**
    //  * Set a generic JsonNodeType.NUMBER parameter.
    //  * @param param
    //  * @param newValue
    //  */
    // private void setNumber(ParamLocationInfo param, JsonNode newValue) {
    //     // Check if parameter to be set is also a number type
    //     if (param.type.equals(JsonNodeType.NUMBER)) {
    //         param.category.replace(param.key, newValue);
    //     } else {
    //         throw new NotFoundException(param.key, "Could not find parameter of number type");
    //     }
    // }

    /**
     * Get the category and value of the first parameter found with this key.
     * @param key
     * @return ParamLocationInfo object if found, null if not found.
     */
    private ParamLocationInfo getParamLocation(String key) {
        for (ParamCategory category : categories.values()) {
            Parameter param = category.getParam(key);

            if (param != null) {
                // Found key in category
                return new ParamLocationInfo(category, param);
            }
        }
        
        throw new NotFoundException(key);
        return null;
    }

    /**
     * Allows for information about a parameter's storage location (category, etc.) 
     * to be passed to methods as a parameter.
     * Only used in this class.
     */
    private class ParamLocationInfo {
        public final ParamCategory category;
        public final Parameter param;

        public ParamLocationInfo(ParamCategory category, Parameter param) {
            this.category = category;
            this.param = param;
        }
    }
}
