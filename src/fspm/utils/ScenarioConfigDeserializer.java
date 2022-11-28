package fspm.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

import fspm.models.scenario.Scenario;
import fspm.models.scenario.Treatment;

public class ScenarioConfigDeserializer {
    public ScenarioConfigDeserializer() {

    }

    public Scenario deserialize(String pathname) {
        File configFile = new File(pathname);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        JsonNode scenarioTree = mapper.readTree(configFile);

        // Deserialize scenario
        Scenario scenario = new Scenario();
        scenario.setName(scenarioTree.get("name").asText());

        // Deserialize treatments
        TreatmentConfigDeserializer tDeserializer = new TreatmentConfigDeserializer();
        JsonNode treatmentsNode = scenarioTree.get("treatments");

        for (JsonNode treatmentNode : treatmentsNode) {
            Treatment treatment = tDeserializer.deserialize(treatmentNode);
            scenario.addTreatment(treatment);
        }

        return scenario;
    }
}
