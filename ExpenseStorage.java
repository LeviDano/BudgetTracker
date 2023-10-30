package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseStorage {
    private ArrayList<Expense> expenses;

    public ExpenseStorage(){
        this.expenses = new ArrayList<>();
    }
    public void addExpense(float amount, String category, String date){
        expenses.add(new Expense(amount, category, date));
    }
    public void deleteExpense(Scanner scanner){
        if (expenses.isEmpty()){
            System.out.println("Inga utigfter hittades");
        } else {
            printExpenses();
            System.out.println("Valj en utgift for att ta bort!");
            int index = scanner.nextInt() - 1;
            expenses.remove(index);
            System.out.println("Utgift ar borttagen");
        }
    }
    public void printExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("Inga utgifter hittades!");
        } else {
            System.out.println("Dina utgifter!");
            for (Expense expense : expenses) {
                int num = expenses.indexOf(expense) + 1;
                System.out.printf("Utgift %d. Summa: %.2f. Datum: %s%n", num, expense.getAmount(), expense.getDate());
            }
        }
    }
}
