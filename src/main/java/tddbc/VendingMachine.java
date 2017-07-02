package tddbc;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private int totalAmount;
    private static final int EMPTY_AMOUNT = 0;
    private int[] acceptMoneyType = new int[]{10, 50, 100, 500, 1000};
    private List<StoredDrink> storedDrinkList;

    public VendingMachine(){
        this.storedDrinkList = new ArrayList<>();
        this.storedDrinkList.add(new StoredDrink("コーラ", 120, 5));
        this.storedDrinkList.add(new StoredDrink("レモンウォーター", 110, 3));

    }

    public int insert(int amount) {
        for (int i : acceptMoneyType) {
            if(amount == i) {
                this.totalAmount += amount;
                return EMPTY_AMOUNT;
            }
        }
        return amount;
    }

    public int getTotalAmount(){
        return this.totalAmount;
    }

    public int refund() {
        int change = this.totalAmount;
        this.totalAmount = EMPTY_AMOUNT;
        return change;
    }

    public void storeDrink(String name, int price, int stock){
        this.storedDrinkList.add(new StoredDrink(name, price, stock));
    }

    public StoredDrink getStoredDrink(String name){
        for(StoredDrink drink : this.storedDrinkList){
            if(drink.getName().equals(name)){
                return drink;
            }
        }
        return null;
    }

    public boolean isBuyable(String name) {
        if (totalAmount >= 120) {
            return true;
        }
        return false;
    }
}

