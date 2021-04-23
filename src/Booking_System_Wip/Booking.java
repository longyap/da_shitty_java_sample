package Booking_System_Wip;
public class Booking {
    private int id;     //10001 and increase sequentially
    private Hall hall;
    private Day day;
    private int time;
    private boolean paid;
    private Customer owner;
    public Booking(int id, Hall hall, Day day, int time, boolean paid, Customer owner) {
        this.id = id;
        this.hall = hall;
        this.day = day;
        this.time = time;
        this.paid = paid;
        this.owner = owner;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Hall getHall() {
        return hall;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    public Day getDay() {
        return day;
    }
    public void setDay(Day day) {
        this.day = day;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public Customer getOwner() {
        return owner;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }    
}
