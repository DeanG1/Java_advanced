import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Party {
    public static void main(String[] args) {
        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        // Reading reservation numbers until "PARTY"
        String guest = scanner.nextLine();
        while (!"PARTY".equals(guest)) {
            if (Character.isDigit(guest.charAt(0))) {
                VIP.add(guest);
            } else {
                regular.add(guest);
            }
            guest = scanner.nextLine();
        }

        // Guests start arriving
        guest = scanner.nextLine();
        while (!"END".equals(guest)) {
            if (VIP.contains(guest)) {
                VIP.remove(guest);
            } else if (regular.contains(guest)) {
                regular.remove(guest);
            }
            guest = scanner.nextLine();
        }

        // Print the count of absent guests
        System.out.println(VIP.size() + regular.size());

        // Print VIP guests who didn't come, followed by regular guests
        for (String vip : VIP) {
            System.out.println(vip);
        }
        for (String reg : regular) {
            System.out.println(reg);
        }
    }
}
