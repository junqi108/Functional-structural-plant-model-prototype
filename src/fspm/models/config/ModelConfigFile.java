package fspm.models.config;

import java.util.List;

import Utils;

public class ModelConfigFile extends ConfigFile {
    private String name;
    private List configs;
    private List plugins;

    public ModelConfigFile() {
        Utils.print("Created model config");
    }

    public String getName() {
        return name;
    }

    public List getPlugins() {
        return plugins;
    }
}