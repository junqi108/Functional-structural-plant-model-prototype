package fspm.config.params.type;

import fspm.config.params.Parameter;

/**
 * Concrete {@link Parameter} implementation for booleans.
 * @author Ou-An Chuang
 */
public class BooleanParam extends Parameter {
    private boolean value;

    public BooleanParam(String key, boolean value) {
        super(key);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.getKey() + ": " + value;
    }
}
