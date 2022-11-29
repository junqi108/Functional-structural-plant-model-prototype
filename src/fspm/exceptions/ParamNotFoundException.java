package fspm.exceptions;

public class ParamNotFoundException extends RuntimeException {
    public ParamNotFoundException(String name) {
        super("Could not find parameter of name: " + name);
    }
}
