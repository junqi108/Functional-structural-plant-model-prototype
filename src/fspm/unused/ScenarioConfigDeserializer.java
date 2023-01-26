package fspm.unused;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import fspm.domain.scenario.Scenario;
import fspm.domain.scenario.Treatment;

import java.io.File;

public class ScenarioConfigDeserializer {
    // public static Scenario deserialize(String pathname) {
    //     File configFile = new File(pathname);

    //     ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    //     JsonNode scenarioTree = mapper.readTree(configFile);

    //     // Deserialize scenario
    //     Scenario scenario = new Scenario();
    //     scenario.setName(scenarioTree.get("name").asText());

    //     // Deserialize treatments
    //     JsonNode treatmentsNode = scenarioTree.get("treatments");

    //     for (JsonNode treatmentNode : treatmentsNode) {
    //         Treatment treatment = TreatmentConfigDeserializer.deserialize(treatmentNode);
    //         scenario.addTreatment(treatment);
    //     }

    //     return scenario;
    // }
}
