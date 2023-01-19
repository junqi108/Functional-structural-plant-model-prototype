package fspm.testing.tests;

import fspm.input.*;
import fspm.config.*;
import fspm.config.params.ParamCategory;
import fspm.util.*;
import fspm.util.exceptions.KeyNotFoundException;
import fspm.util.exceptions.TypeNotFoundException;
import fspm.testing.*;
import fspm.testing.UnitTest;

public class ParamsTest implements UnitTest {
    
    ParamConfig params;

    @Override
    public void setup() {
        ConfigAdapter adapter = new JsonFileReader();
        // adapter.setParamConfig("/var/model/inputs/parameterset_1.json");
        adapter.setConfig("/var/model/inputs/parameterset_1.json");

        params = Config.getInstance().getParamConfig();
    }

    @Override
    public void run() {
        General_Basic();

        Get_NotExists();
        Get_IncorrectType();
        Get_Shorthand();

        Set_Booleans();
        Set_Integers();
    }

    private void General_Basic() {
        Utility.println(params.getCategory("Boolean_variables"));
        ParamCategory booleans = params.getCategory("Boolean_variables");
        Utility.println(booleans.getBool("useCTRAM"));
    }

    private void Get_NotExists() {
        ParamCategory booleans = params.getCategory("Boolean_variables");

        try {
            Utility.println(booleans.getBool("useStatic"));
        } catch (KeyNotFoundException e) {
            Utility.println("Successful catch: " + e.getMessage());
        }
    
    }

    private void Get_IncorrectType() {
        ParamCategory booleans = params.getCategory("Boolean_variables");
        Utility.println(booleans.getBool("useStaticArc"));

        try {
            Utility.println(booleans.getInt("useStaticArc"));
        } catch (TypeNotFoundException e) {
            Utility.println("Successful catch: " + e.getMessage());
        }
    }

    private void Get_Shorthand() {
        Utility.println(params.getBool("useStaticArc"));
        Utility.println(params.getCategory("Boolean_variables").getBool("useStaticArc"));
        
        ParamCategory booleans = params.getCategory("Boolean_variables");
        Utility.println(booleans.getBool("useStaticArc"));
    }

    private void Set_Booleans() {
        ParamCategory booleans = params.getCategory("Boolean_variables");
        Utility.println(booleans);

        booleans.set("useStaticArc", false);
        Utility.println(booleans);

        booleans.set("usePhenology", false);
        Utility.println(booleans);
    }

    private void Set_Integers() {
        Utility.println(params.getInt("nrStrips"));
        
        for (int i = 0; i < 5; i++) {
            int calc = params.getInt("nrStrips") + 1;
            params.set("nrStrips", calc);
            Utility.println(params.getInt("nrStrips"));
        }   
    }
    
}
