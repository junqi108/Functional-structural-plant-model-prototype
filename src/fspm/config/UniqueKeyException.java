package fspm.config;

public class UniqueKeyException extends RuntimeException {
    public UniqueKeyException(String name) {
        super("An entry already exists with unique key: " + name);
    }
}
