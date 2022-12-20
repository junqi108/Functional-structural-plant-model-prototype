package fspm.input;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import fspm.config.Config;
import fspm.config.ConfigAdapter;
import fspm.config.ModelConfig;
import fspm.config.OrganConfig;
import fspm.config.ParamConfig;
import fspm.util.exceptions.NotSupportedException;

public class JsonFileReader implements ConfigAdapter {

    @Override
    public void setParamConfig(String filePath) {
        JsonNode tree = getTreeFromFile(filePath);

        ParamConfig config = new ParamConfig();
        for (ObjectNode category : tree.get("category")) {
            config.addCategory(category);
        }

        Config.getInstance().setParamConfig(config);
    }

    @Override
    public void setModelConfig(String filePath) {
        // TODO: Auto-generated method stub
        
    }

    @Override
    public void setOrganConfig(String filePath) {
        // TODO: Auto-generated method stub
        
    }

    @Override
    public void setConfig(String filePath) {
        String metaClassName = getTreeFromFile(filePath).get("metaclass").asText();

        // SWITCH statement unsupported by XCompiler; use IF instead
        if (metaClassName.equals("document-category-name")) {
            setParamConfig(filePath);
        } else {
            throw new NotSupportedException(metaClassName + " is not supported.");
        }
    }

    private JsonNode getTreeFromFile(String filePath) {
        File file = new File(filePath);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(file);
    }
}
