package exceptions;



public class UserNotFoundException extends LibraryException {
    private static final String MESSAGE = "User not found: ";

    public UserNotFoundException(int userId) {
        super(MESSAGE + userId);
    }
}
