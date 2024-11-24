import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Input lengths of the sets
        System.out.println("Enter the number of elements you wish to enter for the first set: ");
        int firstSetCount = sc.nextInt();
        System.out.println("Enter the number of elements you wish to enter for the second set: ");
        int secondSetCount = sc.nextInt();

        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        for(int i = 0; i < firstSetCount; i++){
            firstSet.add(sc.nextInt());
        }
        for(int i = 0; i < firstSetCount; i++){
            secondSet.add(sc.nextInt());
        }
        firstSet.retainAll(secondSet);
        System.out.println("Set that contains all repeating elements:");
        for(Integer element : firstSet){
            System.out.println(element + " ");
        }
    }
}
