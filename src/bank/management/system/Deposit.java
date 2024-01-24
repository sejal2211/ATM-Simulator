
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit ,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0, 0, 800, 670);
        add(image);
        
        JLabel text =new JLabel("Enter the amount you want deposit :");
        text.setBounds(160,120, 400, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);
        
        amount =new JTextField();
        amount.setFont(new Font("Raleway ",Font.BOLD ,22));
        amount.setBounds(150,200, 300, 25);
        image.add(amount);
        
        deposit =new JButton("Deposit");
        deposit.setBounds(310,310,150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back =new JButton("Back");
        back.setBounds(310,350,150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,670);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                try{
                conn cn=new conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                cn.stn.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+number+"Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }else if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
}
