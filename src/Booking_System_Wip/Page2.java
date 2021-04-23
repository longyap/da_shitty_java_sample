package Booking_System_Wip;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Page2 extends JFrame implements ActionListener {
    private Button check, book, pay, logout;
    public Page2(){
        setSize(250,100);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        check = new Button("Check");
        book = new Button("Book");
        pay = new Button("Pay");
        logout = new Button("Logout");
        check.addActionListener(this);
        book.addActionListener(this);
        pay.addActionListener(this);
        logout.addActionListener(this);
        add(check);
        add(book);
        add(pay);
        add(logout);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logout){
            setVisible(false);
            Sample.first.setVisible(true);
            Sample.whoLogin = null;
        } else if(e.getSource()==book){
            int size = Sample.whoLogin.getMyBooking().size();
            if(size==0 || Sample.whoLogin.getMyBooking().get(size-1).isPaid()){
                try{
                    String a = JOptionPane.showInputDialog("Hall:");
                    Hall a1 = Hall.valueOf(a);
                    String b = JOptionPane.showInputDialog("Day:");
                    Day b1 = Day.valueOf(b);
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if(c<9 || c>23){
                        throw new Exception();
                    }
                    boolean flag = true;
                    for(int i=0; i<Sample.allBooking.size(); i++){
                        Booking x = Sample.allBooking.get(i);
                        if(x.getHall().toString().equals(a) &&
                                x.getDay().toString().equals(b) &&
                                x.getTime() == c){
                            JOptionPane.showMessageDialog(book, "Not available!");
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        int id = 10001+Sample.allBooking.size();
                        Booking x = new Booking(id,a1,b1,c,false,Sample.whoLogin);
                        Sample.whoLogin.getMyBooking().add(x);
                        Sample.allBooking.add(x);
                        JOptionPane.showMessageDialog(book, "Id: "+id);
                    } 
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(book, "Wrong input!");
                }
            } else{
                JOptionPane.showMessageDialog(book,"You have unpaid booking!");
            }
        }else if(e.getSource()==check){
            try{
                String day= JOptionPane.showInputDialog("input day");
                Day b1 = Day.valueOf(day);
                int time = Integer.parseInt(JOptionPane.showInputDialog("input time"));
                if(time<9 || time >23){
                    throw new Exception();
                    }
                 boolean flag = true;
                for(int i=0; i<Sample.allBooking.size(); i++){
                    Booking x = Sample.allBooking.get(i);
                    if(
                        x.getDay().toString().equals(day) &&
                        x.getTime() == time){
                        JOptionPane.showMessageDialog(book, x.getHall());
                          flag = false;
                         break;
                        }
                    }     
                }
            catch(Exception ex){
                 JOptionPane.showMessageDialog(book, "Wrong input!");
            }
            
        }
        else{ 
            int size = Sample.whoLogin.getMyBooking().size();
            if(size==0 || Sample.whoLogin.getMyBooking().get(size-1).isPaid()){
                JOptionPane.showMessageDialog(pay,"You have no unpaid bookings!");
            } else{
                int id = Sample.whoLogin.getMyBooking().get(size-1).getId();
                Sample.third.getMessage1().setText("Your booking id is "+id+"!");
                setVisible(false);
                Sample.third.setVisible(true);
            }
        }
    }
}
