import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        System.out.println("To enter or remove a car -> IN, car number/OUT, car number");
        while(true){
            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }
            else{
                String[] storage = line.split(", ");
                String direction = storage[0];
                String car = storage[1];
                if(direction.equals("IN")){
                    parkingLot.add(car);
                }
                else if(direction.equals("OUT") && parkingLot.contains(car)){
                    parkingLot.remove(car);
                }
                else{
                    System.out.println("There is no parking lot with car number " + car);
                }
            }
        }
        System.out.println("Parking lot is " + parkingLot);
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
    }
}
