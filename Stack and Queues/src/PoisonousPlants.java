import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pesticides = new int[N];
        for (int i = 0; i < N; i++) {
            pesticides[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(daysToStabilize(pesticides));
    }

    public static int daysToStabilize(int[] pesticides) {
        int N = pesticides.length;
        int[] days = new int[N];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!queue.isEmpty() && pesticides[i] > pesticides[queue.peek()]) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                days[i] = days[queue.peek()] + 1;
            } else {
                days[i] = 1;
            }

            queue.offer(i);
        }

        return Arrays.stream(days).max().getAsInt();
    }
}


