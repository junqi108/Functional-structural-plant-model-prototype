package test.unit.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fspm.config.Config;
import fspm.config.params.ParamCategory;
import fspm.config.params.ParamGroup;
import fspm.config.params.type.BooleanParam;
import fspm.config.params.type.IntegerParam;
import fspm.util.exceptions.KeyConflictException;
import fspm.util.exceptions.KeyNotFoundException;
import test.util.Utility;

public class ParamConfigTest {

    ParamGroup params;

    /**
     * Reinitialise an unmodified initial parameter config setup.
     * <p>
     * The results of any test should not impact other tests, 
     * so it should remain unchanged between tests.
     */
    @Before
    public void setup() {
        // Set parameter config to a clean instance
        Config.getInstance().setParamConfig(new ParamGroup());

        params = Config.getInstance().getParamConfig();
    }

    // ===== Get ParamCategory
    
    @Test //(expected = KeyNotFoundException.class)
    public void getNonExistentCategory() {
        try {
            params.getCategory("Non-existent category");
            fail("Expected KeyNotFoundException");
        } catch (KeyNotFoundException e) {
            Utility.println(e);
        }
    }

    // ===== Add ParamCategory

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

    @Test //(expected = KeyConflictException.class)
    public void addCategoryWithConflictingKey() {
        // Using try-catch instead of expected in @Test annotation to print out exception message
        try {
            params.addCategory(new ParamCategory("booleans"));
            params.addCategory(new ParamCategory("booleans"));
            fail("Expected KeyConflictException");
        } catch (KeyConflictException e) {
            Utility.println(e);
        }
    }

    // ===== Get Parameter

    @Test //(expected = KeyNotFoundException.class)
    public void getNonExistentParam() {
        ParamCategory booleans = new ParamCategory("booleans");
        
        try {
            booleans.getBoolean("Non-existent boolean");
            fail("Expected KeyNotFoundException");
        } catch (KeyNotFoundException e) {
            Utility.println(e);
        }
    }

    @Test
    public void addAndGetNewBooleanParam() {
        ParamCategory booleans = new ParamCategory("booleans");
        booleans.add(new BooleanParam("bool1", false));

        assertEquals(false, booleans.getBoolean("bool1"));
    }

    @Test
    public void addAndGetNewIntegerParam() {
        ParamCategory integers = new ParamCategory("integers");
        integers.add(new IntegerParam("int1", 1));

        assertEquals(1, integers.getInteger("int1"));
    }

    // ===== Set Parameter

    @Test
    public void setBooleanParam() {
        ParamCategory booleans = new ParamCategory("booleans");
        booleans.add(new BooleanParam("bool1", false));

        booleans.set("bool1", true);
        assertEquals(true, booleans.getBoolean("bool1"));
    }

    @Test
    public void setIntegerParam() {
        ParamCategory integers = new ParamCategory("integers");
        integers.add(new IntegerParam("int1", 1));

        assertEquals(1, integers.getInteger("int1"));

        while (integers.getInteger("int1") < 5) {
            int calc = integers.getInteger("int1") + 1;
            integers.set("int1", calc);
        }

        assertEquals(5, integers.getInteger("int1"));
    }

    // TODO: add more tests and check code coverage
}
