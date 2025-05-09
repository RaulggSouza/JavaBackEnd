package exception;

public class DeclarationAlreadyExistsException extends RuntimeException {
    public DeclarationAlreadyExistsException(String message) {
        super(message);
    }
}
