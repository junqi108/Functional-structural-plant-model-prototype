package fspm.util.exceptions;

public class KeyConflictException extends RuntimeException {
    public KeyConflictException(String name) {
        super("An entry already exists with unique key: " + name);
    }
}
