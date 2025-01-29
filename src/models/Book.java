package models;

import exceptions.BookAlreadyException;
import extensions.Borrowable;

public class Book implements Borrowable {
    private int id;
    private String title;
    private boolean borrowed;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public void borrow() {
        if (!borrowed) {
            borrowed = true;
        }

    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
        }

    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}
