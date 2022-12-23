package fspm.testing.tests;

import fspm.input.*;
import fspm.config.*;
import fspm.util.*;
import fspm.testing.*;
import fspm.testing.UnitTest;

public class ParamsTest implements UnitTest {
    
    ParamConfig params;

    @Override
    public void setup() {
        ConfigAdapter adapter = new JsonFileReader();
        adapter.setParamConfig("/var/model/inputs/parameterset_1.json");
        adapter.setConfig("/var/model/inputs/parameterset_1.json");

        params = Config.getInstance().getParamConfig();
    }

    @Override
    public void run() {
        //NumericParam_Set_RejectsString();
        // NumericParam_Set_AfterCalculation();
        // BooleanParam_Get_IncorrectType();
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
