import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, String> creadentials = new HashMap<String, String>();

        while(true){
            String name = sc.nextLine();
            if(name.equals("stop")){
                break;
            }
            String email = sc.nextLine();
            String loweredEmail = email.toLowerCase();
            if (!(loweredEmail.endsWith(".us") || loweredEmail.endsWith(".uk") || loweredEmail.endsWith(".com"))) {
                creadentials.put(name, email);
            }
        }
        for(Map.Entry<String, String> entry : creadentials.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
