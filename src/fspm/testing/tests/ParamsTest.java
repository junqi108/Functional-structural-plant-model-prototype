package fspm.testing.tests;

import fspm.input.*;
import fspm.config.*;
import fspm.config.params.ParamCategory;
import fspm.util.*;
import fspm.util.exceptions.NotFoundException;
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
        // General_Basic();

        // Get_NotExists();
        // Get_IncorrectType();
        // Get_Shorthand();
        Set_Booleans();

        //NumericParam_Set_RejectsString();
        // NumericParam_Set_AfterCalculation();
        // BooleanParam_Get_IncorrectType();
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
        } catch (NotFoundException e) {}
    }

    private void Get_IncorrectType() {
        ParamCategory booleans = params.getCategory("Boolean_variables");
        Utility.println(booleans.getBool("useStaticArc"));

        try {
            Utility.println(booleans.getInt("useStaticArc"));
        } catch (NotFoundException e) {}
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

    // private void NumericNode_Set_Basic() {
    //     Utility.println(params.get("PETIOLE_DENSITY"));
    //     params.set("PETIOLE_DENSITY", 0.1);
    //     Utility.println(params.get("PETIOLE_DENSITY"));
    // }
    
    // private void NumericParam_Set_RejectsString() {
    //     Utility.println(params.get("PETIOLE_DENSITY"));
    //     //params.set("PETIOLE_DENSITY", false);
    //     Utility.println(params.get("PETIOLE_DENSITY"));
    //     params.set("PETIOLE_DENSITY", 1);
        
    // }

    // private void NumericParam_Set_AfterCalculation() {
    //     for (int i = 0; i < 5; i++) {
    //         double calc = params.getDouble("PETIOLE_DENSITY") + 0.2;
    //         params.set("PETIOLE_DENSITY", calc);
    //         Utility.println(params.get("PETIOLE_DENSITY"));
    //     }
    // }

    // private void BooleanParam_Get_IncorrectType() {
    //     double calc = params.getDouble("useComplexLeaf") + 0.1;
    // }
    
}
