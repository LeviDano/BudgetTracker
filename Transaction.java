package org.example;

public abstract class Transaction {
    private float amount;
    private String date;


    public Transaction(float amount, String date) {
        this.amount = amount;
        this.date = date;
    }


    public float getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
