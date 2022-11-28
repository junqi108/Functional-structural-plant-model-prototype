package fspm.models.config;

import java.util.List;

public class ModelConfigFile extends ConfigFile {
    private String name;
    private List configs;
    private List plugins;

    public ModelConfigFile() {

    }

    public String getName() {
        return name;
    }

    public List getPlugins() {
        return plugins;
    }
}