package models.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

public class ConfigFile {
    private Map fields;

    public ConfigFile() {
        fields = new HashMap();
    }

    @JsonAnySetter
    public void addField(String name, String value) {
        fields.put(name, value);
    }

    public Map getFields() {
        return fields;
    }
}