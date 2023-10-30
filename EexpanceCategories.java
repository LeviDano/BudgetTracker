package org.example;

public enum EexpanceCategories {
    GIFTS,
    RENT,
    TRANSPORT,
    OTHER,
    FOOD;

    public static EexpanceCategories getCategory(String inputCategory){
        if(inputCategory.equals("Gifts")){
            return GIFTS;
        } else if (inputCategory.equals("Rent")){
            return RENT;
        } else if(inputCategory.equals("Transport")){
            return TRANSPORT;
        } else if(inputCategory.equals("Food")){
            return FOOD;
        } else {
            return OTHER;
        }
    }
}
