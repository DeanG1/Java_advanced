import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Key materials with their required quantities
        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        // Junk materials
        Map<String, Integer> junkMaterials = new TreeMap<>();

        // Legendary item mapping
        Map<String, String> legendaryItems = Map.of(
                "shards", "Shadowmourne",
                "fragments", "Valanyr",
                "motes", "Dragonwrath"
        );

        String legendaryObtained = null;

        while (legendaryObtained == null) {
            // Read a line of input and split into tokens
            String[] inputs = sc.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < inputs.length; i += 2) {
                int quantity = Integer.parseInt(inputs[i]);
                String material = inputs[i + 1];

                if (keyMaterials.containsKey(material)) {
                    // Update key material count
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    // Check if legendary is obtained
                    if (keyMaterials.get(material) >= 250) {
                        legendaryObtained = legendaryItems.get(material);
                        keyMaterials.put(material, keyMaterials.get(material) - 250); // Reduce excess
                        break;
                    }
                } else {
                    // Update junk materials
                    junkMaterials.put(material, junkMaterials.getOrDefault(material, 0) + quantity);
                }
            }
        }

        // Print obtained legendary item
        System.out.println(legendaryObtained + " obtained!");

        // Print key materials in descending order of quantity and alphabetically
        keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    return cmp == 0 ? a.getKey().compareTo(b.getKey()) : cmp;
                })
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Print junk materials alphabetically
        junkMaterials.forEach((material, quantity) -> System.out.println(material + ": " + quantity));
    }
}
