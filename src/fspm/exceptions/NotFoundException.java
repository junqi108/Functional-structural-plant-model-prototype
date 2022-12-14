package fspm.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super("Could not find: " + name);
    }
}