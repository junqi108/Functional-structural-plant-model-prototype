package fspm.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

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
    ParamConfig parseParamConfig(String filePath);

    // void setModelConfig(String filePath);
    // void setOrganConfig(String filePath);
}
