package exceptions;

public class BookAlreadyException extends RuntimeException {
    private static final String MESSAGE = "Book is already borrowed: ";

    public BookAlreadyException(int bookId) {
        super(MESSAGE + bookId);
    }
}