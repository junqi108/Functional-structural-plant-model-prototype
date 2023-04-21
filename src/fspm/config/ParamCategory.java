package fspm.config;

import java.util.HashMap;
import java.util.Map;

import fspm.config.params.Parameter;
import fspm.config.params.type.BooleanParam;
import fspm.config.params.type.DoubleParam;
import fspm.config.params.type.IntegerParam;
import fspm.config.params.type.StringParam;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.KeyNotFoundException;
import fspm.util.exceptions.TypeNotFoundException;
/**
 * A ParamCategory stores {@link Parameter Parameters} that belong to 
 * a common category. Multiple ParamCategory classes may be created. 
 * These parameters can be accessed to get or set their values.
 * 
 * @author Ou-An Chuang
 */
public class ParamCategory implements ParamAccessor {
	private String key;
	private Map<String, Parameter> params;

	/**
	 * Class constructor.
	 * <p>
	 * All initialisations go here.
	 * 
	 * @param key Unique key for the category; for example, its name.
	 */
	public ParamCategory(String key) {
		this.key = key;
		this.params = new HashMap<>();
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
		params.put(key, param);
	}

	@Override
	public void set(String key, String value) {
		StringParam param = (StringParam) getIfInstanceOf(key, StringParam.class);

		param.setValue(value);
		set(key, param);
	}

	@Override
	public void set(String key, double value) {
		DoubleParam param = (DoubleParam) getIfInstanceOf(key, DoubleParam.class);

		param.setValue(value);
		set(key, param);
	}

	@Override
	public void set(String key, boolean value) {
		BooleanParam param = (BooleanParam) getIfInstanceOf(key, BooleanParam.class);

		param.setValue(value);
		set(key, param);
	}

	@Override
	public void set(String key, int value) {
		IntegerParam param = (IntegerParam) getIfInstanceOf(key, IntegerParam.class);

		param.setValue(value);
		set(key, param);
	}



	@Override
	public Boolean getBool(String key) {
		return ((BooleanParam) getIfInstanceOf(key, BooleanParam.class)).getValue();
	}

	@Override
	public String getString(String key) {
		return ((StringParam) getIfInstanceOf(key, StringParam.class)).getValue();
	}

	@Override
	public Integer getInt(String key) {
		return ((IntegerParam) getIfInstanceOf(key, IntegerParam.class)).getValue();
	}

	@Override
	public Double getDouble(String key) {
		return ((DoubleParam) getIfInstanceOf(key, DoubleParam.class)).getValue();
	}

	
	
	
	
	
	
	/**
	 * Helper method to get the parameter of a given key, if it is an 
	 * instance of the {@link Parameter} type class provided.
	 * 
	 * @param key The parameter key.
	 * @param paramTypeClass Concrete class type of {@link Parameter}.
	 * @return Generic {@link Parameter} if found matching parameter.
	 * @throws TypeNotFoundException    If the provided parameter is not an
	 *                                  instance of the {@link Parameter} type.
	 */
	private <T extends Parameter> Parameter getIfInstanceOf(String key, Class<T> paramTypeClass) {
		Parameter param = get(key);

		if (paramTypeClass.isInstance(param)) {
			return param;
		} else {
			throw new TypeNotFoundException(key, paramTypeClass.toString());
		}
	}

	/**
	 * Get generic {@link Parameter} with the given key.
	 * Use this method to check whether a parameter exists in this category.
	 * 
	 * @param key The parameter key.
	 * @return Generic {@link Parameter}. 
	 * @throws KeyNotFoundException If the given key could not be found.
	 */
	public Parameter get(String key) {
		Parameter param = params.get(key);

		if (param != null) {
			return param;
		}
		throw new KeyNotFoundException(key, 
				String.format("Could not find parameter '%s' in category '%s'", key, getKey()));
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
