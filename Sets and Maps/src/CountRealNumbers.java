import java.util.*;
import java.util.stream.Collectors;
public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> input = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (Double num : input) {
            numbers.putIfAbsent(num, 0);
            int newCount = numbers.get(num) + 1;
            numbers.put(num, newCount);
        }

        // Print the map, which contains each number and its corresponding count
        System.out.println(numbers);
    }
}