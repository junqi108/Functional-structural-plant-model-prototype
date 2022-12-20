package fspm.util.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super("Could not find: " + name);
    }

    public NotFoundException(String name, String msg) {
        super(name + ", " + msg);
    }
}
