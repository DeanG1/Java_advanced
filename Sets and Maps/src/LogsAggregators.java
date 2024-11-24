import java.util.*;

public class LogsAggregators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // Number of log entries

        // TreeMap to store users alphabetically
        Map<String, UserLog> logs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            // Parse input line
            String[] parts = sc.nextLine().split(" ");
            String ip = parts[0];
            String user = parts[1];
            int duration = Integer.parseInt(parts[2]);

            // Add or update the log for the user
            logs.putIfAbsent(user, new UserLog());
            UserLog userLog = logs.get(user);

            userLog.addDuration(duration);
            userLog.addIP(ip);
        }

        // Print the output
        for (Map.Entry<String, UserLog> entry : logs.entrySet()) {
            String user = entry.getKey();
            UserLog userLog = entry.getValue();
            System.out.println(user + ": " + userLog.getTotalDuration() + " " + userLog.getSortedIPs());
        }
    }

    // Helper class to manage a user's log data
    static class UserLog {
        private int totalDuration;
        private Set<String> ips;

        public UserLog() {
            this.totalDuration = 0;
            this.ips = new HashSet<>();
        }

        public void addDuration(int duration) {
            this.totalDuration += duration;
        }

        public void addIP(String ip) {
            this.ips.add(ip);
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public String getSortedIPs() {
            List<String> sortedIPs = new ArrayList<>(ips);
            Collections.sort(sortedIPs); // Sort IPs alphabetically
            return "[" + String.join(", ", sortedIPs) + "]";
        }
    }
}
