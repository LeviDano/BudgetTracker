package org.example;

public class Income extends Transaction {
    EIncomeCategories category;
    public Income(float amount, String category, String date) {
        super(amount, date);
        this.category = EIncomeCategories.getCategory(category);
    }
}
