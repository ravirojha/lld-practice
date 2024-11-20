import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Map<String, Product> products;
    private List<Denomination> insertedCoins;
    private double totalAmountCollected;

    public VendingMachine() {
        products = new HashMap<String, Product>();
        insertedCoins = new ArrayList<>();
        totalAmountCollected = 0;
    }

    public synchronized void addProduct(String name, double price, int quantity) {
        products.put(name, new Product( price, quantity,name));
    }

    public double collectionMoney() {
        double total = totalAmountCollected;
        totalAmountCollected = 0;
        return total;
    }

    public void restockProducts(String productName, int quantity) {
        Product present = products.get(productName);
        if(present != null) {
            present.addQuantity(quantity);
        } else {
            throw new IllegalArgumentException("Product is not available in invenstory");
        }
    }

    public Map<String, Product> getInventory() {
        return new HashMap<>(products);
    }

    public void insertCoins(Denomination coin) {
        insertedCoins.add(coin);
    }

    public double purchaseProduct(String productName, int quantity) {
        Product purchasedProduct = products.get(productName);
        if(purchasedProduct == null) {
            throw new IllegalArgumentException("Product not in inventory");
        }
        if(purchasedProduct.getAvailableQuantity() < quantity) {
            throw new IllegalArgumentException("Product out of stock");
        }
        double productPrice = purchasedProduct.getPrice() * quantity;
        double insertedAmount = insertedCoins.stream().mapToDouble(Denomination::getValue).sum();
        if(productPrice > insertedAmount) {
            throw new IllegalArgumentException("Not enough amount");
        }

        purchasedProduct.purchase(quantity);
        totalAmountCollected += productPrice;

        double change = insertedAmount - productPrice;
        insertedCoins.clear();

        return change;
    }



}
