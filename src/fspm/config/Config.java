package fspm.config;

import java.util.ArrayList;
import java.util.List;

import fspm.domain.scenario.Scenario;

/**
 * Configuration class for storing input configurations to be used in simulations.
 * 
 * @author Ou-An Chuang
 */
public class Config {
    /**
     * Singleton instance for the global config. 
     * Set to null by default until instance is first retrieved with {@link #getInstance()}.
     */
    private static Config instance = null;

    private ParamConfig paramConfig = null;

    // TODO: configs not implemented yet
    // private ModelConfig modelConfig;
    // private OrganConfig organConfig;

    // TODO: scenarios not implemented
    // private List scenarios;

    /**
     * Class constructor.
     * Private access as creation should be controlled to enforce singleton pattern
     */
    private Config() {
        // scenarios = new ArrayList();
    }

    /**
     * Gets the singleton instance of the simulation {@link Config}.
     * Creates a new Config if there was no existing instance.
     * 
     * @return Singleton instance of {@link Config}.
     */
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

    // TODO: configs not implemented

    // public ModelConfig getModelConfig() {
    //     return modelConfig;
    // }
    // public void setModelConfig(ModelConfig config) {
    //     this.modelConfig = config;
    // }

    // public OrganConfig getOrganConfig() {
    //     return organConfig;
    // }
    // public void setOrganConfig(OrganConfig config) {
    //     this.organConfig = config;
    // }


    // TODO: scenarios not implemented

    // public List getScenarios() {
    //     return scenarios;
    // }
    // public Scenario getScenario(String name) {
    //     // Cannot use foreach as List does not have explicit Scenario type
    //     for (int i = 0; i < scenarios.size(); i++) {
    //         Scenario scenario = (Scenario) scenarios.get(i);
            
    //         if (scenario.getName().equals(name)) {
    //             return scenario;
    //         }
    //     }
    //     // FIXME: consider throwing a checked exception
    //     return null;
    // }
    // public void setScenarios(List scenarios) {
    //     this.scenarios = scenarios;
    // }
    // public void addScenario(Scenario scenario) {
    //     scenarios.add(scenario);
    // }
}
