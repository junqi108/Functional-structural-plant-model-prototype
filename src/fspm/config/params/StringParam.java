package fspm.config.params;

public class StringParam extends Parameter {
    private String value;

    public StringParam(String key, String value) {
        super(key);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.getKey() + ": " + value;
    }
}
