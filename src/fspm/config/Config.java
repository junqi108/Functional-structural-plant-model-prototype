package fspm.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fspm.exceptions.CategoryNotFoundException;
import fspm.exceptions.UniqueKeyException;
import fspm.models.scenario.Scenario;

public class Config {
    // Singleton design pattern
    private static Config instance = null;

    private ModelConfig modelConfig;
    private OrganConfig organConfig;
    private List scenarios;

    /**
     * Category of parameters
     */
    private Map categories;

    public Config() {
        scenarios = new ArrayList();
        categories = new HashMap();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }


    public ModelConfig getModelConfig() {
        return modelConfig;
    }
    public void setModelConfig(ModelConfig config) {
        this.modelConfig = config;
    }

    public OrganConfig getOrganConfig() {
        return organConfig;
    }
    public void setOrganConfig(OrganConfig config) {
        this.organConfig = config;
    }

    public List getScenarios() {
        return scenarios;
    }
    public Scenario getScenario(String name) {
        // Cannot use foreach as List does not have explicit Scenario type
        for (int i = 0; i < scenarios.size(); i++) {
            Scenario scenario = (Scenario) scenarios.get(i);
            
            if (scenario.getName().equals(name)) {
                return scenario;
            }
        }
        // TODO: consider throwing a checked exception
        return null;
    }
    public void setScenarios(List scenarios) {
        this.scenarios = scenarios;
    }
    public void addScenario(Scenario scenario) {
        scenarios.add(scenario);
    }


    public void addCategory(String key, ParamContainer category) {
        // Not null if key already used
        if (categories.putIfAbsent(key, category) != null) {
            throw new UniqueKeyException(key);
        }
    }
    public ParamContainer getCategory(String key) {
        ParamContainer category = (ParamContainer) categories.get(key);

        if (category == null) {
            throw new CategoryNotFoundException(key);
        }

        return category;
    }
}
