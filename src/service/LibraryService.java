// LibraryService.java
package service;

import exceptions.BookAlreadyException;
import exceptions.BookLimitException;
import exceptions.BookNotFoundException;
import exceptions.UserNotFoundException;
import models.Invoice;
import models.User;
import models.Book;
import models.Library;
import java.util.Optional;

public class LibraryService {
    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public void borrowBook(int userId, int bookId) {

        User user = library.getUsers().get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }


        Optional<Book> bookOpt = library.getBooks().values().stream()
                .filter(book -> book.getId() == bookId)
                .findFirst();

        if (!bookOpt.isPresent()) {
            throw new BookNotFoundException(bookId);
        }

        Book book = bookOpt.get();


        if (book.isBorrowed()) {
            throw new BookAlreadyException(bookId);
        }


        if (user.getBorrowedBooks().size() >= 5) {
            throw new BookLimitException(userId);
        }


        book.borrow();
        user.addBook(book);
        System.out.println("Book borrowed successfully by user " + userId);
    }

    public void returnBook(int userId, int bookId) {

        User user = library.getUsers().get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        Optional<Book> bookOpt = user.getBorrowedBooks().stream()
                .filter(book -> book.getId() == bookId)
                .findFirst();

        if (!bookOpt.isPresent()) {
            throw new BookNotFoundException(bookId);
        }

        Book book = bookOpt.get();
        book.returnItem();
        user.removeBook(book);

        Invoice invoice = new Invoice(user, 10.0);
        invoice.refundAmount();

        System.out.println("Book returned successfully by user " + userId);
    }
}
