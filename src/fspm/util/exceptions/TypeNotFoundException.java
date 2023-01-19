package fspm.util.exceptions;

public class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(String name, String type) {
        super("Could not find key: '" + name + "' of type: " + type);
    }
}
