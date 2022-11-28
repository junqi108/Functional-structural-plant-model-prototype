package fspm.models.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

public class ParamConfigFile extends ConfigFile {
    private Map fields;

    public ParamConfigFile() {
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