package org.example;

public class Expense extends Transaction {
    EexpanceCategories category;
    public Expense(float amount, String category, String date) {
        super(amount, date);
        this.category = EexpanceCategories.getCategory(category);
    }
}
