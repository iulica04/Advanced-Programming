package Exceptions;

public class InvalidDocumentException extends RuntimeException {
    public InvalidDocumentException(String message) {
        super(message);
    }
}
