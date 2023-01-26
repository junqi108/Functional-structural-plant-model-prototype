package fspm.unused;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import fspm.domain.functions.IFunction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OrganConfigDeserializer {
    // public List deserialize(String pathname) {
    //     File configFile = new File(pathname);

    //     List organs = new ArrayList();

    //     ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    //     JsonNode organTree = mapper.readTree(configFile);

    //     for (JsonNode organNode : organTree) {
    //         // Create organ instances
    //         String organName = organNode.get("name").asText();
    //         Class organClass = Class.forName(organName);
    //         GenericOrgan organ = (GenericOrgan) organClass.getDeclaredConstructor().newInstance();

    //         JsonNode functions = organNode.get("functions");

    //         for (JsonNode functionName : functions) {
    //             String className = functionName.asText();
    //             Class functionClass = Class.forName(className);
    //             IFunction function = (IFunction) functionClass.getDeclaredConstructor().newInstance();

    //             organ.getCollector().add(function);
    //         }

    //         organs.add(organ);
    //     }
    //     return organs;
    // }
}
