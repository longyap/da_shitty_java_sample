package Booking_System_Wip;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Page1 extends JFrame implements ActionListener{
    private Button register, login, stop;
    public Page1(){
        setSize(250,100);
        setLocation(700,300);
        setLayout(new FlowLayout());
        register = new Button("Register");
        login = new Button("Login");
        stop = new Button("Stop");  //ActionEvent
        //this == first
        register.addActionListener(this);
        login.addActionListener(this);
        stop.addActionListener(this);
        add(register);
        add(login);
        add(stop);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==stop){
            String input = JOptionPane.showInputDialog("Password:");
            if(input.equals("12345")){
                try{
                    PrintWriter p = new PrintWriter("customer.txt");
                    for(int i=0; i<Sample.allCustomer.size(); i++){
                        Customer c = Sample.allCustomer.get(i);
                        p.println(c.getName());
                        p.println(c.getPin());
                        p.println();
                    }
                    p.close();
                    p = new PrintWriter("booking.txt");
                    for(int i=0; i<Sample.allBooking.size(); i++){
                        Booking b = Sample.allBooking.get(i);
                        p.println(b.getId());
                        p.println(b.getHall());
                        p.println(b.getDay());
                        p.println(b.getTime());
                        p.println(b.isPaid());
                        p.println(b.getOwner().getName());
                        p.println();
                    }
                    p.close();
                    System.exit(0);
                } catch(Exception ex){
                    System.out.println("Error in stop!");
                }
            } else{
                JOptionPane.showMessageDialog(stop,"Wrong password!");
            }
        } else if(e.getSource()==register){
            String a = JOptionPane.showInputDialog("Enter name:");
            boolean flag = true;
            for(int i=0; i<Sample.allCustomer.size(); i++){
                Customer c = Sample.allCustomer.get(i);
                if(a.equals(c.getName())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Pin"));
                Customer c = new Customer(a,pin);
                Sample.allCustomer.add(c);
            } else{
                JOptionPane.showMessageDialog(register, "Name has been used!");
            }
        } else{
            String s = JOptionPane.showInputDialog("Username:");
            for(int i=0; i<Sample.allCustomer.size(); i++){
                Customer c = Sample.allCustomer.get(i);
                if(s.equals(c.getName())){
                    Sample.whoLogin = c;
                    break;
                }
            }
            if(Sample.whoLogin==null){
                JOptionPane.showMessageDialog(login, "Worng username!");
            } else{
                s = JOptionPane.showInputDialog("Password:");
                if(Integer.parseInt(s) != Sample.whoLogin.getPin()){
                    JOptionPane.showMessageDialog(login, "Wrong password!");
                    Sample.whoLogin = null;
                } else{
                    setVisible(false);  //same as this.setVisible(false);
                    Sample.second.setVisible(true);
                }
            }
        }
    }
}
