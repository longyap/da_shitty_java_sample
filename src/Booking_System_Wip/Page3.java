package Booking_System_Wip;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Page3 extends JFrame implements ActionListener{
    private Label message1, message2;
    private TextField input;
    public Page3(){
        setSize(250,150);
        setLocation(700,100);
        setLayout(new FlowLayout());
        message1 = new Label("Your booking id is 10001!");
        message1.setFont(new Font(Font.SERIF,Font.BOLD,14));
        message2 = new Label("You need to pay RM20.");
        message2.setFont(new Font(Font.SERIF,Font.BOLD,14));
        input = new TextField(20);
        input.addActionListener(this);
        add(message1);
        add(input);
        add(message2);
        //setVisible(true);
    }
    public Label getMessage1(){
        return message1;
    }
    private int charge = 20;
    public void actionPerformed(ActionEvent e){
        String amt = input.getText();
        input.setText("");
        try{
            int payment = Integer.parseInt(amt);
            if(payment<1){
                throw new Exception();
            }
            if(payment<charge){
                charge = charge-payment;
                message2.setText("You need to pay RM"+charge+".");
                JOptionPane.showMessageDialog(input,"You must make full payment!");
            } else{
                JOptionPane.showMessageDialog(input, "Your change is RM"+(payment-charge));
                charge = 20;
                message2.setText("You need to pay RM20.");
                int size = Sample.whoLogin.getMyBooking().size();
                Sample.whoLogin.getMyBooking().get(size-1).setPaid(true);
                Sample.whoLogin = null;
                setVisible(false);
                Sample.first.setVisible(true);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(input,"Wrong input!");
        }
    }
}
