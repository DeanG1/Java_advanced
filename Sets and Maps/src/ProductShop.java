import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // TreeMap to store shops and their products (TreeMap ensures shops are ordered by name)
        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"Revision".equals(input)) {
            // Split input into shop, product, and price
            String[] parts = input.split(",\\s+");
            String shop = parts[0];
            String product = parts[1];
            double price = Double.parseDouble(parts[2]);

            // If the shop doesn't exist, add it
            shops.putIfAbsent(shop, new TreeMap<>());

            // Add or update the product and its price for the shop
            shops.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        // Print the output ordered by shop name
        for (Map.Entry<String, Map<String, Double>> shopEntry : shops.entrySet()) {
            System.out.println(shopEntry.getKey() + "->");

            for (Map.Entry<String, Double> productEntry : shopEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productEntry.getKey(), productEntry.getValue());
            }
        }
    }
}
