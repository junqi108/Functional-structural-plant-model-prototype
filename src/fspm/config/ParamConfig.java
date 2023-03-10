package fspm.config;

import java.util.Map;
import java.util.HashMap;

import fspm.config.params.*;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.KeyNotFoundException;
import fspm.util.exceptions.UnsupportedException;

/**
 * Parameter configuration class for storing parameter categories.
 * 
 * @author Ou-An Chuang
 */
public class ParamConfig {
    /**
     * List of parameter categories stored as {@link ParamCategory} instances.
     */
    private Map categories;

    /**
     * Class constructor.
     * <p>
     * All initialisations go here.
     */
    public ParamConfig() {
        categories = new HashMap();
    }
    
    /**
     * Adds a new category.
     * 
     * @param category {@link ParamCategory} to be added.
     * @throws KeyConflictException     If there is already a category with 
     *                                  the same key.
     */
    public void addCategory(ParamCategory category) {
        // Use category key as unique identifier
        if (categories.containsKey(category.getKey())) {
            throw new KeyConflictException(category.getKey());
        } else {
            categories.put(category.getKey(), category);
        }
    }

    /**
     * Gets the category with the given key.
     * 
     * @param key The category key.
     * @return The {@link ParamCategory} with the given key.
     * @throws KeyNotFoundException    If the category with the given key 
     *                                 could not be found.
     */
    public ParamCategory getCategory(String key) {
        ParamCategory category = (ParamCategory) categories.get(key);

        if (category != null) {
            return category;
        }
        throw new KeyNotFoundException(key, "Could not find category");
    }


    /**
     * Gets the first occurrence of the parameter with the given key.
     * Shorthand method of getting parameters without needing to get through category.
     * 
     * @param key The parameter key.
     * @return Boolean parameter.
     */
    public Boolean getBool(String key) {
        ParamCategory category = getCategoryWithParam(key);
        return category.getBool(key);
    }

    /**
     * Gets the first occurrence of the parameter with the given key.
     * Shorthand method of getting parameters without needing to get through category.
     * 
     * @param key The parameter key.
     * @return Integer parameter.
     */
    public Integer getInt(String key) {
        ParamCategory category = getCategoryWithParam(key);
        return category.getInt(key);
    }



    public void set(String key, boolean value) {
        ParamCategory category = getCategoryWithParam(key);
        category.set(key, value);
    }

    public void set(String key, int value) {
        ParamCategory category = getCategoryWithParam(key);
        category.set(key, value);
    }



    /**
     * Helper method to find and get the first category 
     * containing the parameter of a given key.
     * 
     * @param paramKey The parameter key.
     * @return {@link ParamCategory} containing the parameter to be found.
     */
    private ParamCategory getCategoryWithParam(String paramKey) {
        for (ParamCategory category : categories.values()) {
            try {
                Parameter param = category.get(paramKey);
                return category;
            } catch (KeyNotFoundException e) {
                // Not found in this category, continue and check next category.
            }
        }
        // Not found in any category.
        throw new KeyNotFoundException(paramKey, "Could not find this parameter in any category");
    }
}
