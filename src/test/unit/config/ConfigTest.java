package test.unit.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fspm.config.Config;
import fspm.config.ParamConfig;
import fspm.config.params.ParamCategory;
import fspm.config.params.type.BooleanParam;

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

    
    @Test
    public void setParamConfig_getParam() {
        // Add parameters to ParamConfig
        ParamCategory category = new ParamCategory("category");
        category.add(new BooleanParam("boolean", false));

        ParamConfig paramConfig = new ParamConfig();
        paramConfig.addCategory(category);

        Config.getInstance().setParamConfig(paramConfig);

        paramConfig = Config.getInstance().getParamConfig();
        
        assertEquals(false, paramConfig.getBool("boolean"));
    }
}
