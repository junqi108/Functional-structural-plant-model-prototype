package fspm.config.params;

import com.fasterxml.jackson.databind.JsonNode;

import fspm.util.Utility;
import fspm.util.exceptions.UnsupportedException;

public class ParamFactory {
    public Parameter getParam(String name, JsonNode node) {
        Utility.println(name);
        if (node.isInt()) {
            return new IntegerParam(name, node.intValue());
        } else if (node.isBoolean()) {
            return new BooleanParam(name, node.booleanValue());
        } else if (node.isTextual()) {
            //return new StringParam(name, node.textValue());
        }

        throw new UnsupportedException(name + " uses an unsupported type.");
        return null;
    }
}
