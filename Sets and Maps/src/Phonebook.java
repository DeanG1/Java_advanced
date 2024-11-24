import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        System.out.println("Enter names and numbers in the phonebook or type search to search for phone numbers");
        while(true){
            String input = scanner.nextLine();
            if(input.equals("search")){
                break;
            }
            String[] parts = input.split(" ",2);
            if (parts.length < 2) {
                System.out.println("Invalid input. Please provide a name and phone number separated by a space.");
                continue;
            }
            String name = parts[0];
            String number = parts[1];
            phonebook.put(name, number);
        }
            System.out.println("Enter names to search for or type 'stop' to quit!");
        while(true){
            String input = scanner.nextLine();
            if(input.equals("stop")){
                break;
            }
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            }
            else{
                System.out.println("Contact " + input + " does not exist.");
            }

        }
    }
}
