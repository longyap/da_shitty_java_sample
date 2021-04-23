package Booking_System_Wip;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Sample {
    public static Page1 first = new Page1();
    public static Page2 second = new Page2();
    public static Page3 third = new Page3();
    public static Customer whoLogin = null;
    public static ArrayList<Customer> allCustomer = new ArrayList<Customer>();
    public static ArrayList<Booking> allBooking = new ArrayList<Booking>();
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("customer.txt"));
            while(s.hasNext()){
                String a = s.nextLine();
                int b = Integer.parseInt(s.nextLine());
                s.nextLine();
                Customer c = new Customer(a,b);
                allCustomer.add(c);
            }
            s = new Scanner(new File("booking.txt"));
            while(s.hasNext()){
                int a = Integer.parseInt(s.nextLine());
                Hall b = Hall.valueOf(s.nextLine());
                Day c = Day.valueOf(s.nextLine());
                int d = Integer.parseInt(s.nextLine());
                boolean e = Boolean.parseBoolean(s.nextLine());
                String f = s.nextLine();
                s.nextLine();
                for(int i=0; i<allCustomer.size(); i++){
                    Customer x = allCustomer.get(i);
                    if(f.equals(x.getName())){
                        Booking y = new Booking(a,b,c,d,e,x);
                        x.getMyBooking().add(y);
                        allBooking.add(y);
                    }
                }
            }
        } catch(Exception ex){
            System.out.println("Error in read!");
        }
    }    
}
