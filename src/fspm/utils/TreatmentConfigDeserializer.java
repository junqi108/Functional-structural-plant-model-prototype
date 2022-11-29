package fspm.utils;

import com.fasterxml.jackson.databind.JsonNode;

import fspm.models.scenario.Treatment;

public class TreatmentConfigDeserializer {

    public static Treatment deserialize(JsonNode treatmentNode) {
        Treatment treatment = new Treatment();
        treatment.setName(treatmentNode.get("name").asText());
        treatment.setStartYear(treatmentNode.get("start-year"));
        treatment.setEndYear(treatmentNode.get("end-year"));
        // TODO: read YAML list into ArrayList
        // treatment.setConfigs(treatmentNode.get("configs"));

        return treatment;
    }
}