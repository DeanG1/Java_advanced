import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Party {
    public static void main(String[] args){
        Set<String> vip = new TreeSet<String>();
        Set<String> regular = new TreeSet<String>();
        Scanner sc = new Scanner(System.in);
        String guest = sc.nextLine();

        while(!"PARTY".equals(guest)){
            if(Character.isDigit(guest.charAt(0))){
                vip.add(guest);
            }
            else{
                regular.add(guest);
            }
            guest = sc.nextLine();
        }
        while(!"END".equals(guest)){
            vip.remove(guest);
            regular.remove(guest);
            guest = sc.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        for(String vipGuest: vip){
            System.out.println(vipGuest);
        }
        for(String regularGuest: regular){
            System.out.println(regularGuest);
        }
    }
}
