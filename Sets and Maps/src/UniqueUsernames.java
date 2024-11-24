import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> names = new LinkedHashSet<>();
        System.out.println("How many names you want to enter");
        int count = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < count; i++){
            String name = sc.nextLine();
            names.add(name);
        }
        for(String name: names){
            System.out.println(name);
        }
    }
}
