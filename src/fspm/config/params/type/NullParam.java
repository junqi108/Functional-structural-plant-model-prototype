package fspm.config.params.type;

import fspm.config.params.Parameter;

/**
 * Concrete {@link Parameter} implementation for Null parameters representing a null value JsonNode.
 * @author Ou-An Chuang
 */
public class NullParam extends Parameter {
    public static final String nullString = "NA";

    public NullParam(String key) {
        super(key);
    }

    @Override
    public String toString() {
        return super.getKey() + ": " + nullString;
    }
}