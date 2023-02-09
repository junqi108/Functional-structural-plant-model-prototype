package fspm.testing.tests.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fspm.config.Config;
import fspm.config.ParamConfig;
import fspm.config.params.ParamCategory;
import fspm.config.params.type.BooleanParam;
import fspm.config.params.type.IntegerParam;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.KeyNotFoundException;

public class ParamConfigTest {

    ParamConfig params;

    /**
     * Reinitialise an unmodified initial parameter config setup.
     * <p>
     * The results of any test should not impact other tests, 
     * so it should remain unchanged between tests.
     */
    @Before
    public void setup() {
        // Set parameter config to a clean instance
        Config.getInstance().setParamConfig(new ParamConfig());

        params = Config.getInstance().getParamConfig();
    }
    
    @Test(expected = KeyNotFoundException.class)
    public void getNonExistentCategory() {
        params.getCategory("Non-existent category");
    }

    @Test
    public void addNewCategoryWithKey() {
        params.addCategory(new ParamCategory("booleans"));
        assertTrue(params.getCategory("booleans")
            .getKey().equals("booleans"));
    }

    @Test
    public void addMultipleCategories() {
        params.addCategory(new ParamCategory("booleans"));
        params.addCategory(new ParamCategory("integers"));

        assertTrue(params.getCategory("booleans")
            .getKey().equals("booleans"));
        
        assertTrue(params.getCategory("integers")
            .getKey().equals("integers"));
    }

    @Test(expected = KeyConflictException.class)
    public void addCategoryWithConflictingKey() {
        params.addCategory(new ParamCategory("booleans"));
        params.addCategory(new ParamCategory("booleans"));
    }


    // @Test
    // public void addBooleanParam() {
    //     ParamCategory booleans = new ParamCategory("booleans");
    // }
}
