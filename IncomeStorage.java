package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class IncomeStorage {
    private ArrayList<Income> incomes;

    public IncomeStorage(){
        this.incomes = new ArrayList<>();
    }
    public void addIncome(float amount, String category, String date){
        incomes.add(new Income(amount, category, date));
    }
    public void deleteIncome(Scanner scanner){
        if (incomes.isEmpty()){
            System.out.println("Ingen iknkomst hittades");
        } else {
            printIncomes();
            System.out.println("Valj en inkomst for att ta bort!");
            int index = scanner.nextInt() - 1;
            incomes.remove(index);
            System.out.println("Inkomst ar borttagen");
        }
    }
    public void printIncomes(){
        if(incomes.isEmpty()){
            System.out.println("Inga inkomster hittades");
        } else {
            System.out.println("Dina utgifter!");
            for (Income income : incomes) {
                int num = incomes.indexOf(income) + 1;
                System.out.printf("Inkomst %d. Summa: %.2f. Datum: %s%n", num, income.getAmount(), income.getDate());
            }
        }
    }
}
