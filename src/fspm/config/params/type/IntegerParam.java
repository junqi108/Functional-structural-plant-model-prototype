package fspm.config.params.type;

import fspm.config.params.Parameter;

/**
 * Concrete {@link Parameter} implementation for integers.
 * @author Ou-An Chuang
 */
public class IntegerParam extends Parameter {
    private int value;

    public IntegerParam(String key, int value) {
        super(key);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.getKey() + ": " + value;
    }
}
