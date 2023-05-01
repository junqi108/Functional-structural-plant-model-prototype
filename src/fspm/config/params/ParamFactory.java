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
     * The string representing a null value of a JsonNode.
     */
    private String nullString = "NA";

    public String getNullString() {
        return nullString;
    }

    public void setNullString(String nullString) {
        this.nullString = nullString;
    }

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
        if (node.isInt()) {
            return new IntegerParam(name, node.intValue());
        } else if (node.isDouble()) {
            return new DoubleParam(name, node.doubleValue());
        } else if (node.isBoolean()) {
            return new BooleanParam(name, node.booleanValue());
        } else if (node.isTextual()) {
            return new StringParam(name, node.textValue());
        } else if (node.isNull()) {
            return new StringParam(name, nullString);
        }

        throw new UnsupportedException(name + " uses an unsupported type.");
    }
}
