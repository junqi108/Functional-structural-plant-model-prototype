package fspm.config.adapters;

import java.io.FileNotFoundException;

import fspm.config.Config;
import fspm.config.ParamConfig;

/**
 * Defines the required methods adapters must implement to be 
 * compatible with {@link Config}.
 * 
 * @author  Ou-An Chuang
 */
public interface ConfigAdapter {
    /**
     * Parses and returns a {@link ParamConfig} with the parameter contents of the provided file.
     * @param filePath File path to parameter configuration.
     * @return Parsed {@link ParamConfig} for {@link Config}.
     */
    ParamConfig parseParamConfig(String filePath) throws FileNotFoundException;

    // void setModelConfig(String filePath);
    // void setOrganConfig(String filePath);
}
