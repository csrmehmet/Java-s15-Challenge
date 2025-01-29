package exceptions;

public class BookNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Book not found: ";

    public BookNotFoundException(int bookId) {
        super(MESSAGE + bookId);
    }
}