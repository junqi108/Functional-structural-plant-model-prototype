package fspm.util.exceptions;

public class KeyConflictException extends RuntimeException {
    public KeyConflictException(String name) {
        super("An entry already exists with unique key: " + name);
    }
    
    public KeyConflictException(String name, String location) {
        super("An entry already exists with unique key: " + name + " in " + location);
    }
}
