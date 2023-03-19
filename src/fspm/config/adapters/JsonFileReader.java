package fspm.config.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fspm.config.ParamConfig;
import fspm.config.params.ParamCategory;
import fspm.config.params.ParamFactory;
import fspm.config.params.Parameter;

/**
 * File reader to parse JSON config files to {@link Config}.
 * @author Ou-An Chuang
 */
public class JsonFileReader implements ConfigAdapter {
    @Override
    public ParamConfig parseParamConfig(String filePath) throws FileNotFoundException {
        ParamConfig config = new ParamConfig();
        ParamFactory paramFactory = new ParamFactory();

        // Get node structure from JSON file
        JsonNode tree = getTreeFromFile(filePath);

        JsonNode categoriesNode = tree.get("category");
        Iterator categoryNames = categoriesNode.fieldNames();

        // Parse each category node
        for (JsonNode categoryNode : categoriesNode) {
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
        return config;
    }

    /**
     * Helper function for getting root/tree node from a JSON file.
     * @param filePath Path to JSON file.
     * @return Root/tree node.
     * @throws FileNotFoundException
     */
    private JsonNode getTreeFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(file);
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
