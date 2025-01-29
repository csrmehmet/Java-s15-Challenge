package exceptions;

public class BookLimitException extends RuntimeException {
    private static final String MESSAGE = "User has reached the borrowing limit: ";

    public BookLimitException(int userId) {
        super(MESSAGE + userId);
    }
}