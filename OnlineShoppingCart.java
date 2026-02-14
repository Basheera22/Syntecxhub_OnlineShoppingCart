import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store item prices
        HashMap<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Pen", 10);
        priceMap.put("Notebook", 50);
        priceMap.put("Bag", 500);

        // Store cart items and quantity
        HashMap<String, Integer> cart = new HashMap<>();

        int choice;

        do {
            System.out.println("\n--- Online Shopping Cart ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Cart");
            System.out.println("3. Calculate Total Price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Available Items:");
                    for (String item : priceMap.keySet()) {
                        System.out.println(item + " - Rs." + priceMap.get(item));
                    }

                    System.out.print("Enter item name: ");
                    String itemName = sc.next();

                    if (priceMap.containsKey(itemName)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        cart.put(itemName, cart.getOrDefault(itemName, 0) + qty);
                        System.out.println("Item added to cart.");
                    } else {
                        System.out.println("Item not available.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Your Cart ---");
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (String item : cart.keySet()) {
                            System.out.println(item + " - Quantity: " + cart.get(item));
                        }
                    }
                    break;

                case 3:
                    int total = 0;
                    for (String item : cart.keySet()) {
                        total += priceMap.get(item) * cart.get(item);
                    }
                    System.out.println("Total Price: Rs." + total);
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}