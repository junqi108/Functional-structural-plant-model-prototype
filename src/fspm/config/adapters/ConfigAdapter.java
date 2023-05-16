package fspm.config.adapters;

import java.io.FileNotFoundException;

import fspm.config.Config;
import fspm.config.params.ParamGroup;

/**
 * Defines the required methods adapters must implement to be 
 * compatible with {@link Config}.
 * 
 * @author  Ou-An Chuang
 */
public abstract class ConfigAdapter {
	protected final String path;
	
	/**
     * @param filePath File path to parameter configuration.
	 */
	protected ConfigAdapter(String path) {
		this.path = path;
	}
	
    /**
     * Parses and returns a {@link ParamGroup} with the parameter contents of the provided file.
     * @return Parsed {@link ParamGroup} for {@link Config}.
     */
    public abstract ParamGroup parse() throws FileNotFoundException;
}
