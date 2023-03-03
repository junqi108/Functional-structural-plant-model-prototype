package test.integration;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.BeforeClass;
import org.junit.Test;

import fspm.config.Config;
import fspm.config.ConfigAdapter;
import fspm.config.ParamConfig;
import fspm.config.params.ParamCategory;
import fspm.config.params.type.BooleanParam;
import fspm.input.JsonFileReader;

public class InputConfigITest {

    @BeforeClass
    public static void init() {
        
    }

    @Test
    public void addParamConfig() {
        // Add parameters to ParamConfig
        ParamCategory category = new ParamCategory("category");
        category.add(new BooleanParam("boolean", false));

        ParamConfig paramConfig = new ParamConfig();
        paramConfig.addCategory(category);

        // 
        Config.getInstance().setParamConfig(paramConfig);

        paramConfig = Config.getInstance();
        
        assertEquals(false, paramConfig);
    }

    @Test
    public void addParamConfigFromFile() {
        ConfigAdapter adapter = new JsonFileReader();
        ParamConfig paramConfig = adapter.parseParamConfig(
            "/var/model/src/test/resources/test_param.json");

        Config.getInstance().setParamConfig(paramConfig);

        // assertEquals();
    }
}
