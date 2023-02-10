package test.integration;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import fspm.config.Config;
import fspm.config.ParamConfig;
import fspm.config.params.ParamCategory;
import fspm.config.params.type.BooleanParam;

public class InputConfigITest {

    @BeforeClass
    public static void init() {
        
    }

    // @Test
    // public void addParamConfig() {
    //     // Add parameters to ParamConfig
    //     ParamCategory category = new ParamCategory("category");
    //     category.add(new BooleanParam("boolean", false));

    //     ParamConfig paramConfig = new ParamConfig();
    //     paramConfig.addCategory(category);

    //     // 
    //     Config.getInstance().setParamConfig(paramConfig);

    //     paramConfig = Config.getInstance()
        
    //     assertEquals(false, paramConfig);
    // }
}
