package fspm.config;

import java.util.ArrayList;
import java.util.List;

import fspm.domain.scenario.Scenario;

/**
 * Configuration class for simulations.
 * @author Ou-An Chuang
 * @since 15-12-2022
 */
public class Config {
    /**
     * Global config singleton.
     */
    private static Config instance = null;

    private ParamConfig paramConfig;
    private ModelConfig modelConfig;
    private OrganConfig organConfig;

    private List scenarios;

    public Config() {
        scenarios = new ArrayList();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    public ParamConfig getParamConfig() {
        return paramConfig;
    }
    public void setParamConfig(ParamConfig config) {
        this.paramConfig = config;
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
}
