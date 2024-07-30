import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] childrens =  scanner.nextLine().split("\\s");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for(String child : childrens){
            queue.offer(child);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            System.out.println("Removed " + queue.poll());
        }
        System.out.println("The last is " + queue.poll());
    }
}
