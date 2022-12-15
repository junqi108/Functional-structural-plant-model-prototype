package fspm.config;

/**
 * Defines the required methods adapters must implement to be compatible with the Config class
 * @author  Ou-An Chuang
 * @since   15-12-2022
 */
public interface ConfigAdapter {
    void setParamConfig(ParamConfig config);
    void setModelConfig(ModelConfig config);
    void setOrganConfig(OrganConfig config);
}
