package org.example;

public enum EIncomeCategories {
    SALARY,
    GIFTS,
    INVESTMENTS,
    OTHER;
    public static EIncomeCategories getCategory(String inputCategory){
        if(inputCategory.equals("Gifts")){
            return GIFTS;
        } else if (inputCategory.equals("Salary")){
            return SALARY;
        } else if(inputCategory.equals("Investments")){
            return INVESTMENTS;
        } else {
            return OTHER;
        }
    }
}
