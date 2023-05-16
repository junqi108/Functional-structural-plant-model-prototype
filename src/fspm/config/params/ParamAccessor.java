package fspm.config.params;

/**
 * Blueprint for all classes that handles getting and setting of parameters.
 */
public interface ParamAccessor {
	Boolean getBoolean(String key);
	String getString(String key);
	Integer getInteger(String key);
	Double getDouble(String key);

	void set(String key, boolean value);
	void set(String key, String value);
	void set(String key, int value);
	void set(String key, double value);
	
	boolean isNull(String key);
}
