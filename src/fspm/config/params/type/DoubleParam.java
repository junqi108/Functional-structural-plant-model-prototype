package fspm.config.params.type;

import fspm.config.params.Parameter;

/**
 * Concrete {@link Parameter} implementation for doubles.
 * @author Ou-An Chuang
 */
public class DoubleParam extends Parameter {
    private double value;

    public DoubleParam(String key, double value) {
        super(key);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return super.getKey() + ": " + value;
    }
}
