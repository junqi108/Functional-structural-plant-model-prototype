package fspm.config;

import java.util.List;

import Utils;

public class ModelConfig {
    private String name;
    private List configs;
    private List plugins;

    public ModelConfig() {
        Utils.print("Created model config");
    }

    public String getName() {
        return name;
    }

    public List getPlugins() {
        return plugins;
    }
}