
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton r1 ,r2 ,r3 ,r4;
    JCheckBox c1, c2, c3, c4, c5 ,c6 ,c7 ;
    JButton submit ,cancel;
    String formno;
    
    Signup3( String formno){
        
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD , 25));
        l1.setBounds(280 ,30,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type  :");
        type.setFont(new Font("Raleway",Font.BOLD , 22));
        type.setBounds(100 ,100,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD , 16));
        r1.setBackground(Color.white);
        r1.setBounds(150 ,140,250,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD , 16));
        r2.setBackground(Color.white);
        r2.setBounds(450 ,140,250,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD , 16));
        r3.setBackground(Color.white);
        r3.setBounds(150 ,170,250,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD , 16));
        r4.setBackground(Color.white);
        r4.setBounds(450 ,170,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
         JLabel card=new JLabel("Card Number    :");
        card.setFont(new Font("Raleway",Font.BOLD , 22));
        card.setBounds(100 ,220,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD , 22));
        number.setBounds(330 ,220,400,30);
        add(number);
        
        JLabel details=new JLabel("Your 16 digit Card Number");
        details.setFont(new Font("Raleway",Font.ITALIC , 12));
        details.setBounds(100 ,250,400,15);
        add(details);
        
        JLabel pin=new JLabel("PIN                     :");
        pin.setFont(new Font("Raleway",Font.BOLD , 22));
        pin.setBounds(100 ,290,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD , 22));
        pnumber.setBounds(330 ,290,400,30);
        add(pnumber);
        
        JLabel pindetails=new JLabel("Your 4 digit Password");
        pindetails.setFont(new Font("Raleway",Font.ITALIC , 12));
        pindetails.setBounds(100 ,320,400,15);
        add(pindetails);
        
        JLabel services=new JLabel("Services Required        :");
        services.setFont(new Font("Raleway",Font.BOLD , 22));
        services.setBounds(100 ,350,400,30);
        add(services);
        
        c1 =new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD , 16));
        c1.setBackground(Color.white);
        c1.setBounds(100 ,400,200,30);
        add(c1);
        
        c2 =new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD , 16));
        c2.setBackground(Color.white);
        c2.setBounds(350 ,400,200,30);
        add(c2);
        
        c3 =new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD , 16));
        c3.setBackground(Color.white);
        c3.setBounds(100 ,440,200,30);
        add(c3);
        
        c4 =new JCheckBox("Email/SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD , 16));
        c4.setBackground(Color.white);
        c4.setBounds(350 ,440,200,30);
        add(c4);
        
        c5 =new JCheckBox("Checkbook");
        c5.setFont(new Font("Raleway",Font.BOLD , 16));
        c5.setBackground(Color.white);
        c5.setBounds(100 ,480,200,30);
        add(c5);
        
        c6 =new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD , 16));
        c6.setBackground(Color.white);
        c6.setBounds(350 ,480,200,30);
        add(c6);
        
        c7 =new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD , 12));
        c7.setBackground(Color.white);
        c7.setBounds(100,530,600,30);
        add(c7);
        
        submit=new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD , 14));
        submit.setBounds(250,580,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD , 14));
        cancel.setBounds(420,580,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,820);
        setVisible(true);
        setLocation(200,0);
    }
    
    public void actionPerformed(ActionEvent ae){
      
        if(ae.getSource()==submit){
          if(c7.isSelected()){
            String acctype=null;
            if(r1.isSelected()){
                acctype="Saving Account";
            }else if(r2.isSelected()){
                acctype="Fixed Deposit Account";
            }else if(r3.isSelected()){
                acctype="Current Account";
            }else if(r4.isSelected()){
                acctype="Recurring Deposit Account";
            }
            
            Random random =new Random();
            String cardnumber= "" + Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
            String pinnumber= "" + Math.abs((random.nextLong() % 9000L)+ 1000L);
            
            String facility ="";
            if(c1.isSelected()){
                facility=facility+ "ATM Card";
            }else if(c2.isSelected()){
                facility=facility+ "Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+ "Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility+ "Email/SMS Alerts";
            }else if(c5.isSelected()){
                facility=facility+ "Cheque Book";
            }else if(c6.isSelected()){
                facility=facility+ "E-Statement";
            }
            
            try{
                if(acctype.equals("")){
                  JOptionPane.showMessageDialog(null, "Account Type is Required");
               }else{
                   conn cnn=new conn();
                   String query1="insert into signup3 values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                   String query2 ="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                   cnn.stn.executeUpdate(query1);
                   cnn.stn.executeUpdate(query2);
                  
                   JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber + "\n Pin : "+pinnumber);
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(true);
                   
               }
            }catch(Exception e){
                System.out.println(e);
            }
          }else {
            JOptionPane.showMessageDialog(null, "Tick the below cheque box");
          }
        }else if (ae.getSource()==cancel){
            setVisible(false);
             new Login().setVisible(true);
        }
       
    }
    
    public static void main(String args[]){
        new Signup3("");
    }

}
