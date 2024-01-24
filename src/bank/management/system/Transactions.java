
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl , fastcash, ministatement, pinchange , enquiry,exit ,transfer;
    String pinnumber;
 
    Transactions(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0, 0, 800, 670);
        add(image);
        
        JLabel text =new JLabel("Please select your Transaction");
        text.setBounds(160,120, 400, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(text);
        
        deposit =new JButton("Deposit");
        deposit.setBounds(140, 250, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Withdraw");
        withdrawl.setBounds(310, 250, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(140, 285, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement =new JButton("Mini Statement");
        ministatement.setBounds(310, 285, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange =new JButton("PIN Change");
        pinchange.setBounds(140, 320, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        enquiry =new JButton("Balance Enquiry");
        enquiry.setBounds(310, 320, 150, 30);
        enquiry.addActionListener(this);
        image.add(enquiry);
        
        exit =new JButton("Exit");
        exit.setBounds(310, 355, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        transfer=new JButton("Transfer");
        transfer.setBounds(140, 355, 150, 30);
        transfer.addActionListener(this);
        image.add(transfer);
        
        setSize(800,670);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()==withdrawl){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource()==enquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }else if (ae.getSource()==transfer){
            new Transfer(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
}
