import models.*;
import service.*;


public class Main {
    public static void main(String[] args) {

        Library library = new Library(1, "City Library");
        User user1 = new User(1, "John Doe") {
            @Override
            public void addUser(User user) {

            }

            @Override
            public String getUserType() {
                return "";
            }
        };
        User user2 = new User(2, "Jane Smith") {
            @Override
            public void addUser(User user) {

            }

            @Override
            public String getUserType() {
                return "";
            }
        };
        library.addUser(user1);
        library.addUser(user2);

        Book book1 = new Book(1, "The Great Gatsby");
        Book book2 = new Book(2, "Moby Dick");
        library.addBook(book1);
        library.addBook(book2);

        LibraryService libraryService = new LibraryService(library);


        try {
            libraryService.borrowBook(1, 1);
            libraryService.borrowBook(1, 2);
            libraryService.borrowBook(2, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            libraryService.returnBook(1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
