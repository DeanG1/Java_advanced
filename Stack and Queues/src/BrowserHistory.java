import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String line = scanner.nextLine();
        while(!"Home".equals(line)){
            if(!"back".equals(line)){
                stack.push(line);
                System.out.println(line);
            }
            else{
                if(stack.size() <= 1){
                    System.out.println("no previous urls!");
                }else{
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }
        line = scanner.nextLine();
        }
    }
}
