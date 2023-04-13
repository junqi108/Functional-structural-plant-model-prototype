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
public class Config {
    /**
     * Singleton instance for the global config. 
     * Set to null by default until instance is first retrieved with {@link #getInstance()}.
     */
    private static Config instance = null;

    /**
     * We use Map instead of Set to allow us to check for key conflicts.
     */
    private Map<String, ParamGroup> paramGroups;


    /**
     * Class constructor.
     * Private access as creation should be controlled to enforce singleton pattern
     */
    private Config() {
    	paramGroups = new HashMap<String, ParamGroup>();
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
    public void addGroup(String name, ConfigAdapter adapter) throws FileNotFoundException {
    	addGroup(name, adapter.parse());
    }
    
    /**
     * Add a new group with a unique name.
     * @param group
     */
    public void addGroup(ParamGroup group) {
        addGroup(group.getName(), group);
    }
    
    private void addGroup(String name, ParamGroup group) {
    	if (paramGroups.containsKey(name)) {
    		throw new KeyConflictException(name, this.toString());
    	}
    	paramGroups.put(name, group);
    }
    
    /**
     * Gets the parameter group with the given name.
     * @return Parameter group
     */
    public ParamGroup getGroup(String name) {
    	ParamGroup group = paramGroups.get(name);
    	
    	if (group == null) {
    		throw new KeyNotFoundException(name);
    	}
    	return group;
    }
}
