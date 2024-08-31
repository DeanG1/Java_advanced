import java.util.*;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of students
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        // TreeMap to store student names and their scores
        TreeMap<String, ArrayList<Double>> graduationList = new TreeMap<>();

        // Input handling
        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];  // First part is the student's name

            // Parse the grades and store them in a list
            ArrayList<Double> scores = new ArrayList<>();
            for (int j = 1; j < input.length; j++) {
                scores.add(Double.parseDouble(input[j]));
            }

            // Add or update the student's grades in the TreeMap
            graduationList.putIfAbsent(name, new ArrayList<>()); // If student doesn't exist, add them
            graduationList.get(name).addAll(scores);  // Add all the grades to the student's list
        }

        // Iterate over the TreeMap to print the results
        for (Map.Entry<String, ArrayList<Double>> entry : graduationList.entrySet()) {
            String name = entry.getKey();
            ArrayList<Double> scores = entry.getValue();

            // Calculate the average grade
            double sum = 0;
            for (Double score : scores) {
                sum += score;
            }
            double average = sum / scores.size();

            // Print the student's name, their grades, and the average
            System.out.print(name + " -> ");
            for (Double score : scores) {
                System.out.printf("%.2f ", score);
            }
            System.out.printf("(avg: %.2f)\n", average);
        }
    }
}
