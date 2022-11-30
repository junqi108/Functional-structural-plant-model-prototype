package fspm.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String name) {
        super("Could not find category of name: " + name);
    }
}