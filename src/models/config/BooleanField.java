package models.config;

public class BooleanField extends Field {

    private boolean value;

    public BooleanField(String name, boolean value) {
        super(name);
        this.value = value;
    }
}
