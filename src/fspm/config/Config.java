package fspm.config;

import java.util.HashMap;
import java.util.Map;

public class Config {
    // Singleton design pattern
    private static Config instance = null;

    /**
     * Categories of parameters
     */
    private Map categories;

    public Config() {
        categories = new HashMap();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    public ParamContainer getCategory(String key) {
        ParamContainer category = (ParamContainer) categories.get(key);

        if (category == null) {
            throw new CategoryNotFoundException(key);
        }

        return category;
    }
    public void addCategory(String key, ParamContainer category) {
        // Not null if key already used
        if (categories.putIfAbsent(key, category) != null) {
            throw new UniqueKeyException(key);
        }
    }
}
