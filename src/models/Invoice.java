package models;

public class Invoice {
    private User user;
    private double amount;

    public Invoice(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public void refundAmount() {
        System.out.println("Refund of " + amount + " processed for user " + user.getId());
    }
}