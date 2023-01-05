package fspm.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Defines the required methods adapters must implement to be compatible with {@link Config}.
 * @author  Ou-An Chuang
 * @since   15-12-2022
 */
public interface ConfigAdapter {
    /**
     * Parses and sets the {@link ParamConfig} of {@link Config} to the contents of the provided file.
     * @param filePath Parameter config file path.
     */
    void setParamConfig(String filePath);

    /**
     * 
     * @param filePath
     */
    void setModelConfig(String filePath);
    void setOrganConfig(String filePath);

    /**
     * Generic set config using a file of any metaclass type.
     * @param filePath Path to config file.
     */
    void setConfig(String filePath);
    
}
