package fspm.testing.unit.config;

import fspm.config.Config;
import fspm.config.ConfigAdapter;
import fspm.config.ParamConfig;
import fspm.config.params.*;
import fspm.input.JsonFileReader;
import fspm.util.exceptions.KeyNotFoundException;
import fspm.util.exceptions.TypeNotFoundException;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class ParamsUnitTest {

    ConfigAdapter adapter = new JsonFileReader();
    ParamConfig params;

    @Before
    public void setUp() {
        adapter.setConfig("/var/model/inputs/parameters/model.input.data.name.json");
        params = Config.getInstance().getParamConfig();
    }

    @Test
    public void General_Basic() {
        ParamCategory booleans = params.getCategory("Boolean_variables");
        // Utility.println(booleans);
        
        assertEquals(booleans.getBool("useCTRAM"), true);
    }

    @Test
    public void Get_NotExists() {
        ParamCategory booleans = params.getCategory("Boolean_variables");

        try {
            // Utility.println(booleans.getBool("useStatic"));
        } catch (KeyNotFoundException e) {
            // Utility.println("Successful catch: " + e.getMessage());
        }
    }

    @Test
    public void Get_IncorrectType() {
        ParamCategory booleans = params.getCategory("Boolean_variables");
        // Utility.println(booleans.getBool("useStaticArc"));

        try {
            // Utility.println(booleans.getInt("useStaticArc"));
        } catch (TypeNotFoundException e) {
            // Utility.println("Successful catch: " + e.getMessage());
        }
    }

    @Test
    public void Get_Shorthand() {
        // Utility.println(params.getBool("useStaticArc"));
        // Utility.println(params.getCategory("Boolean_variables").getBool("useStaticArc"));
        
        ParamCategory booleans = params.getCategory("Boolean_variables");
        // Utility.println(booleans.getBool("useStaticArc"));
    }

    @Test
    public void Set_Booleans() {
        ParamCategory booleans = params.getCategory("Boolean_variables");
        // Utility.println(booleans);

        booleans.set("useStaticArc", false);
        // Utility.println(booleans);

        booleans.set("usePhenology", false);
        // Utility.println(booleans);
    }

    @Test
    public void Set_Integers() {
        ParamCategory simControl = params.getCategory("simulation_control");
        // Utility.println(params.getInt("nrStrips"));
        
        for (int i = 0; i < 5; i++) {
            int calc = simControl.getInt("nrStrips") + 1;
            simControl.set("nrStrips", calc);
            // Utility.println(params.getInt("nrStrips"));
        }

        assertEquals(simControl.getInt("nrStrips"), 1);
    }
}
