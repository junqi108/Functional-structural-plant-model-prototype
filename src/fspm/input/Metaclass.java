package fspm.input;

public enum Metaclass {
    CATEGORY("document-category-name");

    public final String name;

    private Metaclass(String name) {
        this.name = name;
    }
}
