import java.util.*;

public class UserLogs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }

            // Parse the input string
            String[] parts = input.split(" ");
            String ip = parts[0].split("=")[1];
            String username = parts[2].split("=")[1];

            // Update the data structure
            userLogs.putIfAbsent(username, new LinkedHashMap<>());
            Map<String, Integer> ips = userLogs.get(username);
            ips.put(ip, ips.getOrDefault(ip, 0) + 1);
        }

        // Print the output
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : userLogs.entrySet()) {
            System.out.println(entry.getKey() + ":");
            List<String> ipEntries = new ArrayList<>();
            for (Map.Entry<String, Integer> ipEntry : entry.getValue().entrySet()) {
                ipEntries.add(ipEntry.getKey() + " => " + ipEntry.getValue());
            }
            System.out.println(String.join(", ", ipEntries) + ".");
        }
    }
}
