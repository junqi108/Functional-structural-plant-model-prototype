package test.unit.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fspm.config.Config;
import fspm.config.ParamConfig;

public class ConfigTest {

    @Test
    public void getSingleton_IsNeverNull() {
        assertNotNull(Config.getInstance());
    }

    @Test
    public void getParamConfig_UnsetIsNull() {
        assertNull(Config.getInstance().getParamConfig());
    }

    @Test
    public void setAndGetParamConfig() {
        Config config = Config.getInstance();

        config.setParamConfig(new ParamConfig());
        assertNotNull(config.getParamConfig());
    }
}
