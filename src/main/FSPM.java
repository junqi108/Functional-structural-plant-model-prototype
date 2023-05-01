package main;

import java.io.FileNotFoundException;

import fspm.config.Config;
import fspm.config.adapters.JsonFileReader;
import fspm.config.params.ParamCategory;
import fspm.config.params.ParamGroup;

public class FSPM {
	static final Config CONFIG = Config.getInstance();

	public static void main(String[] args) {
		
		addGroups();
		
		accessExamples();
	}
	
	
	
	
	private static void addGroups() {
		// Manually add new group
		CONFIG.addGroup(new ParamGroup("group"));
		
		// Read in JSON file and add as new group
		try {
			CONFIG.addGroup("model.input.data.name", 
					new JsonFileReader("./inputs/parameters/model.input.data.name.json"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void accessExamples() {
		// Full descriptive access of hierarchy
		println(" ===== Full descriptive access ");
		
		println(CONFIG.getGroup("model.input.data.name").getCategory("Boolean_variables").getBoolean("useStaticArc"));
		println(CONFIG.getGroup("model.input.data.name").getCategory("Boolean_variables").getBoolean("inputLeafN"));
		
		println(CONFIG.getGroup("model.input.data.name").getCategory("simulation_location").getString("location_name"));
		
		
		
		// Contextual access

		println(" ===== Contextual access ");
		
		CONFIG.setGroupContext("model.input.data.name")
			.setCategoryContext("Boolean_variables");
		
		println(CONFIG.getBoolean("useStaticArc"));
		println(CONFIG.getBoolean("inputLeafN"));
		
		CONFIG.setCategoryContext("simulation_location");
		
		println(CONFIG.getString("location_name"));

		
		
		// Access via aliasing
		
		println(" ===== Aliasing ");
		
		ParamCategory booleans = CONFIG.getGroup("model.input.data.name").getCategory("Boolean_variables");
		
		println(booleans.getBoolean("useStaticArc"));
		println(booleans.getBoolean("inputLeafN"));
		
		ParamCategory simulationLocation = CONFIG.getGroup("model.input.data.name").getCategory("simulation_location");
		
		println(simulationLocation.getString("location_name"));
		
		
		
		// Direct access; not compatible with contextual access
		
//		println(" ===== Direct access");
//		println(CONFIG.getBoolean("useStaticArc"));
	}
	

	
	
	private static void println(Object o) {
		System.out.println(o.toString());
	}

}
