import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int searchNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                if (matrix[row][col] == searchNumber) {
                    System.out.println(row + " " + col); isFound = true;
                }
        if(!isFound)
            System.out.println("not found");
    }
}
