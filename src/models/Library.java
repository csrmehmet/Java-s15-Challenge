package models;

import java.util.HashMap;
import java.util.Map;

public class Library extends User{
    private Map<Integer, User> users;
    private Map<Integer, Book> books;

    public Library(int id,String name) {
        super(id,name);
        this.users = new HashMap<>();
        this.books = new HashMap<>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public String getUserType() {
        return "";
    }
}
