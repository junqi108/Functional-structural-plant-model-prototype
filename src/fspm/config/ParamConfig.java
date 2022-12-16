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
    public void addCategory(JsonNode category) {
        categories.add(category);
    }

    public JsonNode getCategory(String key) {
        JsonNode category = categories.get(key);

        if (category == null) {
            throw new NotFoundException(key);
        }

        return category;
    }

    /**
     * Get the value of the first occurrence of this key.
     * @param key Key of the parameter.
     * @return JsonNode of key, null if not found.
     */
    public JsonNode get(String key) {
        // Search each category
        for (JsonNode category : categories) {
            JsonNode value = category.get(key);

            if (value != null) {
                // Found key in category
                return value;
            }
        }

        throw new NotFoundException(key);
        return null;
    }

    // public Boolean getBoolean(String key) {
    //     JsonNode value = get(key);

    //     if (value == null) {
    //         throw new NotFoundException(key);
    //     }
    //     return (Boolean) value;
    // }
    
}
