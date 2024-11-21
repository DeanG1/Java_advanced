import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        System.out.println("To add or remove a car enter: IN, car number/ OUT, car number");

        while(true){
            String carNumber = scanner.nextLine();
            if(carNumber.equals("END")){
                break;
            }
            else{
                String[] reminder = carNumber.split(", ");
                String direction = reminder[0];
                String number = reminder[1];
                if(reminder[0].equals("IN")){
                    parkingLot.add(number);
                    System.out.println("Car " + carNumber + " entered the parking lot.");
                }
                else if(reminder[0].equals("OUT")){
                    if(parkingLot.contains(number)){
                        parkingLot.remove(number);
                        System.out.println("Car " + carNumber + " removed the parking lot.");
                    }
                    else{
                        System.out.println("Car with " + number + " does not exist.");
                    }
                }
            }
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is empty.");
        }
        System.out.println("Parking lot is: " + parkingLot);

    }
}
