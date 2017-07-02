package tddbc;

/**
 * Created by naoya on 2017/07/01.
 */
public class Drink {
    private String name;
    private int price;
    private int stock;


    public Drink(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Drink(String name, int price){
        this.name = name;
        this.price = price;
        this.stock = 5;
    }

    public int getStock() {
        return stock;
    }
}
