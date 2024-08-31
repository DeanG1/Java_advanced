import java.util.*;
import java.util.stream.Collectors;
public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object to read input from the console

        // Read a line of input, split it by spaces, convert each part to a Double, and collect them into a List
        List<Double> input = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)   // Convert each string in the array to a Double
                .collect(Collectors.toList()); // Collect all Doubles into a List

        // Create a LinkedHashMap to store each unique number and its count
        Map<Double, Integer> numbers = new LinkedHashMap<>();

        // Iterate over each number in the input list
        for (Double num : input) {
            numbers.putIfAbsent(num, 0);  // If the number is not already in the map, add it with a count of 0
            int newCount = numbers.get(num) + 1;  // Increment the count of the current number
            numbers.put(num, newCount);  // Update the count of the number in the map
        }

        // Print the map, which contains each number and its corresponding count
        System.out.println(numbers);
    }
}