import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] reminder = input.split(", ");
                if (reminder[0].equals("IN")) {
                    parkingLot.add(reminder[1]);
                } else if (reminder[0].equals("OUT")) {
                    parkingLot.remove(reminder[1]);
                }
            }
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        System.out.println(parkingLot);
    }
}
