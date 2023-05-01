package test.unit.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import fspm.config.Config;
import fspm.config.adapters.ConfigAdapter;
import fspm.config.adapters.JsonFileReader;
import fspm.config.params.ParamCategory;
import fspm.config.params.ParamGroup;
import test.util.Utility;

public class ConfigAdapterTest {

    String testParamFile = "/var/model/src/test/resources/test_param.json";

    @BeforeClass
    public static void init() {
        
    }

    @Test
    public void parseInvalidFile() {
        try {
            ConfigAdapter adapter = new JsonFileReader();
            ParamGroup paramConfig = adapter.parseParamConfig(
                "unknown path");
        } catch (FileNotFoundException e) {
            Utility.println(e);
        }
    }

    @Test
    public void addParamConfigFromFile() {
        Config config = Config.getInstance();

        ConfigAdapter adapter = new JsonFileReader();
        ParamGroup paramConfig;

        // Try parsing test parameter file
        try {
            paramConfig = adapter.parseParamConfig(testParamFile);
        } catch (FileNotFoundException e) {
            fail("Test resource " + testParamFile + " is missing.");
            return;
        }

        config.setParamConfig(paramConfig);
        ParamCategory category = config.getParamConfig().getCategory("booleans");

        assertEquals(false, category.getBoolean("bool1"));
    }
}
