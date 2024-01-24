    
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
    JLabel l1,l2,name,fname,dob,gender,email,marital,address,city,pin,state;
    JTextField tname,tfname,temail ,taddress,tcity,tpin,tstate;
    JRadioButton rmale,rfemale,r3,r4,r5;
    JButton b;
    JDateChooser dateChooser;
    
    Random ran = new Random();
    long first = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
     SignupOne(){
        super("ScrollPane Demo");  
         
        setLayout(null);
           
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        l1 = new JLabel("APPLICATION FORM NO. "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        l1.setBounds(140,30,600,30);
        add(l1);
        
        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(290,80,400,30);
        add(l2);
        
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,130,100,30);
        add(name);
        
        tname = new JTextField();
        tname.setFont(new Font("Raleway", Font.BOLD, 14));
        tname.setBounds(300,130,400,30);
        add(tname);
        
        fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,170,200,30);
        add(fname);
        
        tfname = new JTextField();
        tfname.setFont(new Font("Raleway", Font.BOLD, 14));
        tfname.setBounds(300,170,400,30);
        add(tfname);
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,210,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
	dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300,210, 400, 30);
	add(dateChooser);
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,250,200,30);
        add(gender);
        
        rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Raleway", Font.BOLD, 14));
        rmale.setBackground(Color.WHITE);
         rmale.setBounds(300,250,60,30);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Raleway", Font.BOLD, 14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(450,250,90,30);
        add(rfemale);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(rmale);
        groupgender.add(rfemale);
        
        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,290,200,30);
        add(email );
        
        temail  = new JTextField();
        temail .setFont(new Font("Raleway", Font.BOLD, 14));
        temail .setBounds(300,290,400,30);
        add(temail );
        
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,330,200,30);
        add(marital);
        
        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300,330,100,30);
        add(r3);
        
        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450,330,100,30);
        add(r4);
        
        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        r5.setBounds(630,330,100,30);
        add(r5);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);
        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,370,200,30);
        add(address);
        
        taddress = new JTextField();
        taddress.setFont(new Font("Raleway", Font.BOLD, 14));
        taddress.setBounds(300,370,400,30);
        add(taddress);
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,410,200,30);
        add(city);
        
        tcity = new JTextField();
        tcity.setFont(new Font("Raleway", Font.BOLD, 14));
        tcity.setBounds(300,410,400,30);
        add(tcity);
        
        pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,450,200,30);
        add(pin);
        
        tpin = new JTextField();
        tpin.setFont(new Font("Raleway", Font.BOLD, 14));
        tpin.setBounds(300,450,400,30);
        add(tpin);
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,490,200,30);
        add(state);
        
        tstate = new JTextField();
        tstate.setFont(new Font("Raleway", Font.BOLD, 14));
        tstate.setBounds(300,490,400,30);
        add(tstate);
    
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(620,540,80,30); 
        b.addActionListener(this);
        add(b); 
        
        setSize(850,750);
        setVisible(true);
        setLocation(200,0);
    }
     

     public void actionPerformed(ActionEvent ae){
           String formno = "" + first;
           String Name =tname.getText();
           String Fname =tfname.getText();
           String Dob =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
           String Gender=null;
           if(rmale.isSelected()){
               Gender="male";
           }else if(rfemale.isSelected()){
               Gender="female";
           }
           String Email =temail.getText();
           String Marital =null;
           if(r3.isSelected()){
               Marital="Married";
           }else if(r4.isSelected()){
               Marital="Unmarried";
           }else if(r5.isSelected()){
               Marital="Other";
           }
           String Address=taddress.getText();
           String City=tcity.getText();
           String Pin=tpin.getText();
           String State=tstate.getText();
           
           try{
               if(Name.equals("")){
                  JOptionPane.showMessageDialog(null, "Name is Required");
               }else{
                   conn cnn=new conn();
                   String query="insert into signup values('"+formno+"','"+Name+"','"+Fname+"','"+Dob+"','"+Gender+"','"+Email+"','"+Marital+"','"+Address+"','"+City+"','"+Pin+"','"+State+"')";
                   cnn.stn.executeUpdate(query);
                   
                   setVisible(false);
                   new SignupTwo(formno).setVisible(true);
               }
           }catch (Exception e){
               System.out.println(e);
           }
           
    }
    
    public static void main(String args[]){
        new SignupOne();
        
    }
}
