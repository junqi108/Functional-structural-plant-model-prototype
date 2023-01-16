package fspm.input;

import java.io.File;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import fspm.config.Config;
import fspm.config.ConfigAdapter;
import fspm.config.ModelConfig;
import fspm.config.OrganConfig;
import fspm.config.ParamConfig;
import fspm.config.params.*;
import fspm.util.exceptions.UnsupportedException;

/**
 * File reader to parse JSON config files to {@link Config}.
 * @author Ou-An Chuang
 * @version %I%
 */
public class JsonFileReader implements ConfigAdapter {
    @Override
    public void setParamConfig(String filePath) {
        ParamConfig config = new ParamConfig();
        ParamFactory paramFactory = new ParamFactory();

        // Get node structure from JSON file
        JsonNode tree = getTreeFromFile(filePath);

        JsonNode categoriesNode = tree.get("category");
        Iterator categoryNames = categoriesNode.fieldNames();

        // Parse each category node
        for (ObjectNode categoryNode : categoriesNode) {
            String categoryName = categoryNames.next().toString();
            ParamCategory category = new ParamCategory(categoryName);

            Iterator paramNames = categoryNode.fieldNames();

            // Parse each parameter node
            for (JsonNode paramNode : categoryNode) {
                Parameter param = paramFactory.getParam(paramNames.next().toString(), paramNode);

                // null if paramNode type is unsupported
                // TODO: use checked exception for UnsupportedException
                if (param != null) {
                    category.add(param);
                }
            }
            config.addCategory(category);
        }

        Config.getInstance().setParamConfig(config);
    }

    @Override
    public void setConfig(String filePath) {
        String metaClassName = getTreeFromFile(filePath).get("metaclass").asText();

        // SWITCH statement unsupported by XCompiler; use IF instead
        if (metaClassName.equals("document-category-name")) {
            setParamConfig(filePath);
        } else {
            throw new UnsupportedException(metaClassName + " is not supported.");
        }
    }

    /**
     * Helper function for getting root/tree node from a JSON file.
     * @param filePath Path to JSON file.
     * @return Root/tree node.
     */
    private JsonNode getTreeFromFile(String filePath) {
        File file = new File(filePath);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(file);
    }
}
