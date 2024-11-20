import java.util.Map;

public class VendingMachineDemo {
    public static void main(String[] args) {
        // Create Vending Machine
        VendingMachine vendingMachine = new VendingMachine();

        // Add initial products
        vendingMachine.addProduct("Coke", 1.50, 5);
        vendingMachine.addProduct("Pepsi", 1.75, 3);
        vendingMachine.addProduct("Water", 1.00, 10);

        // Demonstration of various operations
        try {
            // Scenario 1: Successful Purchase
            System.out.println("--- Scenario 1: Successful Purchase ---");
            // Insert coins
            vendingMachine.insertCoins(Denomination.FIVE);
            vendingMachine.insertCoins(Denomination.HUNDRED);

            double change = vendingMachine.purchaseProduct("Coke", 2);
            System.out.println(change);

            // Scenario 2: Insufficient Funds
            System.out.println("\n--- Scenario 2: Insufficient Funds ---");
            vendingMachine.insertCoins(Denomination.FIFTY);
            try {
                vendingMachine.purchaseProduct("Pepsi", 5);
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Scenario 3: Out of Stock
            System.out.println("\n--- Scenario 3: Restock and Purchase ---");
            // Purchase all Cokes
            for (int i = 0; i < 4; i++) {
                vendingMachine.insertCoins(Denomination.FIVE_HUNDRED);
                vendingMachine.insertCoins(Denomination.FIVE);
                vendingMachine.purchaseProduct("Coke", 10);
            }

            // Try to purchase when out of stock
            try {
                vendingMachine.insertCoins(Denomination.HUNDRED);
                vendingMachine.insertCoins(Denomination.FIFTY);
                vendingMachine.purchaseProduct("Coke", 4);
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Restock
            vendingMachine.addProduct("Coke", 50, 3);

            // Scenario 4: Money Collection
            System.out.println("\n--- Scenario 4: Money Collection ---");
            double collectedMoney = vendingMachine.collectionMoney();
            System.out.println("Total Money Collected: $" + collectedMoney);

            // Scenario 5: Inventory Check
            System.out.println("\n--- Scenario 5: Inventory Check ---");
            Map<String, Product> inventory = vendingMachine.getInventory();
            inventory.forEach((name, product) ->
                    System.out.println(name + ": Quantity = " + product.getAvailableQuantity() +
                            ", Price = $" + product.getPrice())
            );

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}