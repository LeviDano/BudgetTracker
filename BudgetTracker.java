package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetTracker {
    public static boolean finduser(ArrayList<user> userArrayList, String firstName, String lastName){
        boolean sameFirst = false;
        boolean sameLast = false;
        for(user user:userArrayList){
            sameFirst = firstName.equals(user.getFirstName());
            sameLast = lastName.equals(user.getLastName());
            if (sameFirst && sameLast){
                return true;
            }
        }
        return false;
    }
    //Använder boolean får att se om min user finns i min fill, i arraylistan
    public static ArrayList<user> readfile(Gson gson) {
        try {
            FileReader fr = new FileReader("src/main/user.json");
            ArrayList<user> userList = gson.fromJson(fr, new TypeToken<ArrayList<user>>() {}.getType());
            if (userList == null) {
                userList = new ArrayList<>();
            }
            return userList;
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }
    // Skapar arraylist fran filen sa java kan anvanda den
    public static void printMenu(){
        System.out.println("MENU");
        System.out.println("1. Lagg till inkomst");
        System.out.println("2. Lagg till utgift");
        System.out.println("3. Ta bort utgift");
        System.out.println("4. Ta bort inkomst");
        System.out.println("5. Skriva inkomst");
        System.out.println("6. Skriva utgift");
        System.out.println("0. Exit");
    }
    public static user getUser(ArrayList<user> userArrayList, String firstName, String lastName){
        boolean sameFirst = false;
        boolean sameLast = false;
        user foundUser = null;
        for(user user : userArrayList){
            sameFirst = firstName.equals(user.getFirstName());
            sameLast = lastName.equals(user.getLastName());
            if (sameFirst && sameLast){
                foundUser = user;
            }
        }
        return foundUser;
    }
    // Tar annavendaren fran arralistan, sa jag kan upddatera hans varde

// nasta steg ar min main
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String fileName = "src/main/user.json";
        ArrayList<user> userArrayList = readfile(gson);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv ditt namn!");
        String firstName = scanner.nextLine();
        System.out.println("Skriv ditt efternamn!");
        String lastName = scanner.nextLine();
        boolean userExists = finduser(userArrayList, firstName, lastName);

        if (!userExists) {
            userArrayList.add(new user(firstName, lastName));
            System.out.println("Välkommen till Budget Tracker");
        } else {
            System.out.println("Välkommen tillbaka!");
        }
        int num = 0;
        do{
            printMenu();
            num = scanner.nextInt();
            scanner.nextLine();
            switch (num){
                case 1:
                    System.out.println("Vilken manad skede transaktion?");
                    String dateIncome = scanner.nextLine();
                    System.out.println("Ange summan!");
                    float amountIncome = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Vilken kategori? Salary, Gifts, Investments, Other");
                    String categoryIncome = scanner.nextLine();
                    getUser(userArrayList, firstName, lastName).addIncome(amountIncome, categoryIncome, dateIncome);
                    break;
                case 2:
                    System.out.println("Vilken manad skede transaktion?");
                    String dateExpense = scanner.nextLine();
                    System.out.println("Ange summan!");
                    float amountExpense = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Vilken kategori? Gifts, Rent, Transport, Food, Other");
                    String categoryExpense = scanner.nextLine();
                    getUser(userArrayList, firstName, lastName).addExpense(amountExpense, categoryExpense, dateExpense);
                    break;
                case 3:
                    getUser(userArrayList, firstName, lastName).deleteExpense(scanner);
                    break;
                case 4:
                    getUser(userArrayList, firstName, lastName).deleteIncome(scanner);
                    break;
                case 5:
                    getUser(userArrayList, firstName, lastName).printIncomes();
                    break;
                case 6:
                    getUser(userArrayList, firstName, lastName).printExpenses();
                    break;
                default:
                    System.out.println("Valj fran meny!");
            }
        } while (num != 0);

        FileWriter fw = new FileWriter(fileName);
        gson.toJson(userArrayList, fw);
        fw.close();
        scanner.close();
    }
}