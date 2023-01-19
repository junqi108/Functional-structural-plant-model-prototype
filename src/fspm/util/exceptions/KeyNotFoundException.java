package fspm.util.exceptions;

public class KeyNotFoundException extends RuntimeException {
    public KeyNotFoundException(String name) {
        super("Could not find: '" + name + "'");
    }

    public KeyNotFoundException(String name, String msg) {
        super("'" + name + "', " + msg);
    }
}
