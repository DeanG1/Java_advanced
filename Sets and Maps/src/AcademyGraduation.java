import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> students = new LinkedHashMap<>();
        int number =  Integer.parseInt(sc.nextLine());

        for(int i = 0; i < number; i++){
            String name = sc.nextLine();
            String[] gradesInput = sc.nextLine().split("\\s+");
            List<Double> gradeList = new ArrayList<>();
            for(String grade: gradesInput){
                gradeList.add(Double.parseDouble(grade));
            }
            students.put(name, gradeList);
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            String name = entry.getKey();
            List<Double> scores = entry.getValue();

            // Calculate average
            double average = scores.stream().mapToDouble(Double::doubleValue).average().orElse(0);

            // Print formatted result
            System.out.printf("%s is graduated with %.3f%n", name, average);
        }
    }
}
