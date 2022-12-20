package fspm.testing.tests;

import fspm.input.*;
import fspm.config.*;
import fspm.util.*;
import fspm.testing.*;
import fspm.testing.UnitTest;

import Utils;

public class ParamsTest implements UnitTest {

    @Override
    public void setup() {
        ConfigAdapter adapter = new JsonFileReader();
        adapter.setParamConfig("/var/model/inputs/parameterset_1.json");
        adapter.setConfig("/var/model/inputs/parameterset_1.json");
    }

    @Override
    public void run() {
        numericParamRejectsString();
    }

    private void numericParamRejectsString() {
        ParamConfig params = Config.getInstance().getParamConfig();
        Utils.print(params.get("PETIOLE_DENSITY"));
        //params.set("PETIOLE_DENSITY", false);
        Utils.print(params.get("PETIOLE_DENSITY"));
        params.set("PETIOLE_DENSITY", 1);
        Utils.print(params.get("PETIOLE_DENSITY"));
        params.set("PETIOLE_DENSITY", 0.1);
        Utils.print(params.get("PETIOLE_DENSITY"));
    }
    
}
