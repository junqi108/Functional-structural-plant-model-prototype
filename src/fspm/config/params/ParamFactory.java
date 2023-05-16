package fspm.config.params;

import com.fasterxml.jackson.databind.JsonNode;

import fspm.config.params.type.*;
import fspm.util.exceptions.UnsupportedException;

/**
 * ParamFactory creates instances of concrete {@link Parameter Parameter}
 * implementations depending on the data type received.
 * 
 * @author Ou-An Chuang
 */
public class ParamFactory {

    /**
     * Returns a concrete {@link Parameter Parameter} instance depending on
     * the data type of the JsonNode passed in.
     * 
     * @param name The parameter name.
     * @param node The JsonNode containing the parameter value and data type.
     * @return  Concrete {@link Parameter Parameter} instance of the
     *          corresponding data type.
     * @throws UnsupportedException If the JsonNode data type does not correspond
     *                              to any concrete {@link Parameter} implementation.
     */
    public Parameter getParam(String name, JsonNode node) {
    	if (node.isNull() || node.toString().equals(NullParam.nullString)) {
            return new NullParam(name);
        } else if (node.isInt()) {
            return new IntegerParam(name, node.intValue());
        } else if (node.isDouble()) {
            return new DoubleParam(name, node.doubleValue());
        } else if (node.isBoolean()) {
            return new BooleanParam(name, node.booleanValue());
        } else if (node.isTextual()) {
            return new StringParam(name, node.textValue());
        }

        throw new UnsupportedException(name + " uses an unsupported type.");
    }
}
