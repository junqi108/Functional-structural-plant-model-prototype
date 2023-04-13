package fspm.config;

/**
 * Blueprint for all classes that handles getting and setting of parameters.
 */
public interface ParamAccessor {
	Boolean getBool(String name);
	void set(String name, boolean value);
}
