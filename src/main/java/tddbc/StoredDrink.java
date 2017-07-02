package tddbc;

/**
 * Created by naoya on 2017/07/01.
 */
public class StoredDrink {
    private String name;
    private int price;
    private int stock;


    public StoredDrink(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getStock() {
        return stock;
    }
}
