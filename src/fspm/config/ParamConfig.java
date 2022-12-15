package fspm.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import fspm.util.exceptions.NotFoundException;

public class ParamConfig {
    private ArrayNode categories; // Assumes params are stored in a 'category' JsonNode

    public ParamConfig() {
        categories = JsonNodeFactory.instance.arrayNode();
    }

    public void setCategories(ArrayNode categories) {
        this.categories = categories;
    }

    public JsonNode getCategory(String key) {
        JsonNode category = categories.get(key);

        if (category == null) {
            throw new NotFoundException(key);
        }

        return category;
    }
    
}
