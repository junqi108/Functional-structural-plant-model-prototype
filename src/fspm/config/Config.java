package fspm.config;

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

    // TODO: other configurations to be determined, for example:
    // private ModelConfig modelConfig;
    // private OrganConfig organConfig;

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

    /**
     * Gets the parameter configuration.
     * @return Parameter configuration, or null if it has not been set.
     */
    public ParamConfig getParamConfig() {
        return paramConfig;
    }
    public void setParamConfig(ParamConfig config) {
        this.paramConfig = config;
    }
}
