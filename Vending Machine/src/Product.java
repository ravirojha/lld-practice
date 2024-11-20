import java.math.BigDecimal;

public class Product {
    private double price;
    private int quantityAvailable;
    private String name;

    public Product(double price, int quantity, String name) {
        this.price = price;
        this.quantityAvailable = quantity;
        this.name = name;
    }

    public void addQuantity(int quantity) {
        this.quantityAvailable += quantity;
    }

    public boolean purchase(int quantity) {
        this.quantityAvailable -= quantity;
        return true;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAvailableQuantity() {
        return this.quantityAvailable;
    }


    public String getName() {
        return this.name;
    }
}
