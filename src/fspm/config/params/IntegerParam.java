package fspm.config.params;

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

    // TODO: code duplication, may need to redesign parameters
    @Override
    public String toString() {
        return super.getKey() + ": " + value;
    }
}
