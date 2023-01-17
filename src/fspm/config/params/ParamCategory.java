package fspm.config.params;

import java.util.HashMap;
import java.util.Map;

import fspm.config.params.type.BooleanParam;
import fspm.config.params.type.IntegerParam;
import fspm.util.Utility;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.NotFoundException;

/**
 * A ParamCategory stores {@link Parameter Parameters} that belong to 
 * a common category. Multiple ParamCategory classes may be created. 
 * These parameters can be accessed to get or set their values.
 * 
 * @author Ou-An Chuang
 * @version %I%
 */
public class ParamCategory {
    private String key;
    private Map params;

    /**
     * Class constructor.
     * <p>
     * All initialisations go here.
     * 
     * @param key Unique key for the category; for example, its name.
     */
    public ParamCategory(String key) {
        this.key = key;
        this.params = new HashMap();
    }

    public String getKey() {
        return key;
    }

    /**
     * Adds a new {@link Parameter} to the category.
     * 
     * @param param Parameter to be added to the category.
     * @throws KeyConflictException     If there is already a parameter with 
     *                                  the same key in the category.
     */
    public void add(Parameter param) {
        // Use parameter key as unique identifier
        if (params.containsKey(param.getKey())) {
            throw new KeyConflictException(param.getKey());
        } else {
            set(param.getKey(), param);
        }
    }

    /**
     * Get generic {@link Parameter} with the given key.
     * 
     * @param key The parameter key.
     * @return Generic {@link Parameter}. Returns null if not found.
     */
    public Parameter get(String key) {
        // Can cast params is implicitly Map<Parameter>, but this syntax is not supported by XCompiler
        return (Parameter) params.get(key);
    }


    public Boolean getBool(String key) {
        BooleanParam param = (BooleanParam) getIfInstanceOf(key, BooleanParam.class);
        return param.getValue();
    }

    public int getInt(String key) {
        IntegerParam param = (IntegerParam) getIfInstanceOf(key, IntegerParam.class);
        return param.getValue();
    }

    /**
     * Set parameter with the given key to the provided {@link Parameter}.
     * The parameter is added if there was not an existing key to replace.
     * <p>
     * Private method as parameters should not be directly accessed (set) 
     * from outside this class; prevents overriding parameters with a mismatching type.
     * 
     * @param key The parameter key.
     * @param param {@link Parameter} to replace or add to the category.
     */
    private void set(String key, Parameter param) {
        // TODO: better explanation or structure of why checks may or may not be needed (due to previous checks on higher classes)
        params.put(key, param);
    }


    public void set(String key, boolean newValue) {
        BooleanParam newParam = (BooleanParam) getIfInstanceOf(key, BooleanParam.class);

        newParam.setValue(newValue);
        set(key, newParam);
    }

    public void set(String key, int newValue) {
        IntegerParam newParam = (IntegerParam) getIfInstanceOf(key, IntegerParam.class);

        newParam.setValue(newValue);
        set(key, newParam);
    }




    /**
     * Helper method to get the parameter of a given key, if it is an 
     * instance of the {@link Parameter} type class provided.
     * 
     * @param key The parameter key.
     * @param paramTypeClass Concrete class type of {@link Parameter}.
     * @return Generic {@link Parameter} if found matching parameter.
     * @throws NotFoundException    If the provided parameter is not an
     *                              instance of the {@link Parameter} type.
     */
    private Parameter getIfInstanceOf(String key, Class paramTypeClass) {
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
