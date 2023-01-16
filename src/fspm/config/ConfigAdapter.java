package fspm.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Defines the required methods adapters must implement to be 
 * compatible with {@link Config}.
 * 
 * @author  Ou-An Chuang
 * @version %I%
 */
public interface ConfigAdapter {
    /**
     * Parses and sets the {@link ParamConfig} of {@link Config} to the contents of the provided file.
     * @param filePath File path to parameter configuration.
     */
    void setParamConfig(String filePath);

    // void setModelConfig(String filePath);
    // void setOrganConfig(String filePath);

    /**
     * Generic set config using a file of any metaclass type.
     * @param filePath File path to configuration file of any metaclass type.
     */
    void setConfig(String filePath);
    
}
