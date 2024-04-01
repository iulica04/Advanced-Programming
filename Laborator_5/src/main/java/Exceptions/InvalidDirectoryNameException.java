package Exceptions;

public class InvalidDirectoryNameException extends RuntimeException {
    public InvalidDirectoryNameException(String message) {
        super(message);
    }
}
