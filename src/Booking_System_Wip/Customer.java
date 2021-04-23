package Booking_System_Wip;
import java.util.ArrayList;
public class Customer {
    private String name;
    private int pin;
    private ArrayList<Booking> myBooking = new ArrayList<Booking>();
    //Student[] x = new Student[10];
    //Student[] y = new Student[11];
    public Customer(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public ArrayList<Booking> getMyBooking() {
        return myBooking;
    }
    public void setMyBooking(ArrayList<Booking> myBooking) {
        this.myBooking = myBooking;
    }
}
