package fspm.config;

import java.util.List;

public class ModelConfig {
    private String name;
    private List configs;
    private List plugins;

    public ModelConfig() {
    }

    public String getName() {
        return name;
    }

    public List getPlugins() {
        return plugins;
    }
}