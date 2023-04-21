package fspm.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import fspm.config.adapters.ConfigAdapter;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.KeyNotFoundException;

/**
 * Configuration class for storing input configurations to be used in simulations.
 * 
 * @author Ou-An Chuang
 */
public class Config implements ParamAccessor {
    /**
     * Singleton instance for the global config. 
     * Set to null by default until instance is first retrieved with {@link #getInstance()}.
     */
    private static Config instance = null;

    /**
     * We use Map instead of Set to allow us to check for key conflicts.
     */
    private Map<String, ParamGroup> paramGroups;
    
    private ParamGroup groupContext = null;
    private ParamCategory categoryContext = null;


    /**
     * Class constructor.
     * Private access as creation should be controlled to enforce singleton pattern
     */
    private Config() {
    	paramGroups = new HashMap<>();
    }

    /**
     * Gets the singleton instance of the simulation {@link Config}.
     * Creates a new Config if there was no existing instance.
     * 
     * @return Singleton instance of {@link Config}.
     */
    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }


    public void addGroup(ConfigAdapter adapter) throws FileNotFoundException {
    	addGroup(adapter.parse());
    }
    public void addGroup(String key, ConfigAdapter adapter) throws FileNotFoundException {
    	addGroup(key, adapter.parse());
    }
    
    /**
     * Add a new group with a unique key.
     * @param group
     */
    public void addGroup(ParamGroup group) {
        addGroup(group.getKey(), group);
    }
    
    private void addGroup(String key, ParamGroup group) {
    	if (paramGroups.containsKey(key)) {
    		throw new KeyConflictException(key, this.toString());
    	}
    	paramGroups.put(key, group);
    }
    
    /**
     * Gets the parameter group with the given key.
     * @return Parameter group
     */
    public ParamGroup getGroup(String key) {
    	ParamGroup group = paramGroups.get(key);
    	
    	if (group == null) {
    		throw new KeyNotFoundException(key);
    	}
    	return group;
    }
    
    
    public Config setGroupContext(String key) {
    	try {
    		groupContext = getGroup(key);
    	} catch (KeyNotFoundException e) {
    		throw new KeyNotFoundException(key, "Could not set group context as group with key does not exist.");
    	}
    	return this;
    }
    
    public Config setCategoryContext(String key) {
    	// Check group context has been set.
		if (groupContext.equals(null)) {
			throw new RuntimeException("Could not set category context as group context is undefined.");
		}
		
    	try {
    		categoryContext = groupContext.getCategory(key);
    	} catch (KeyNotFoundException e) {
    		throw new KeyNotFoundException(key, "Could not set category context as category with key does not exist.");
    	}
    	return this;
    }
    
    

	@Override
	public Boolean getBool(String key) {
		return categoryContext.getBool(key);
	}

	@Override
	public String getString(String key) {
		return categoryContext.getString(key);
	}

	@Override
	public Integer getInt(String key) {
		return categoryContext.getInt(key);
	}

	@Override
	public Double getDouble(String key) {
		return categoryContext.getDouble(key);
	}

	@Override
	public void set(String key, boolean value) {
		categoryContext.set(key, value);
	}

	@Override
	public void set(String key, String value) {
		categoryContext.set(key, value);
	}

	@Override
	public void set(String key, int value) {
		categoryContext.set(key, value);
	}

	@Override
	public void set(String key, double value) {
		categoryContext.set(key, value);
	}
}
