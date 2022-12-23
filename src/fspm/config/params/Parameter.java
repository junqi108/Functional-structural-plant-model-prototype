package fspm.config.params;

public abstract class Parameter {
    private String key;

    /**
     * Protected constructor as Parameter is an abstract class and
     * should not be used for instantiation.
     * @param key
     */
    protected Parameter(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
