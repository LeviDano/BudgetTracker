package org.example;

import java.util.Scanner;

public class user {
    private String firstName;
    private String lastName;
    private ExpenseStorage expenseStorage;
    private IncomeStorage incomeStorage;


    public user(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.expenseStorage = new ExpenseStorage();
        this.incomeStorage = new IncomeStorage();

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void addIncome(float amount, String category, String date){
        incomeStorage.addIncome(amount, category, date);
    }
    public void deleteIncome(Scanner scanner){
        incomeStorage.deleteIncome(scanner);
    }
    public void printIncomes(){
        incomeStorage.printIncomes();
    }
    public void addExpense(float amount, String category, String date){
        expenseStorage.addExpense(amount, category, date);
    }
    public void deleteExpense(Scanner scanner){
        expenseStorage.deleteExpense(scanner);
    }
    public void printExpenses(){
        expenseStorage.printExpenses();
    }
}
