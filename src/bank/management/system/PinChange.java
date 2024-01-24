
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class PinChange extends JFrame implements ActionListener {
    
    JButton change , back;
    JPasswordField pin ,repin;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0, 0, 800, 670);
        add(image);
        
        JLabel text =new JLabel("CHANGE YOUR PIN ");
        text.setBounds(160,120, 400, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("raleway", Font.BOLD,16));
        image.add(text);
        
        JLabel pintext =new JLabel("New PIN              :");
        pintext.setBounds(150,190, 400, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        image.add(pintext);
        
        pin =new JPasswordField();
        pin.setBounds(310,190, 145, 25);
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        image.add(pin);
        
        JLabel repintext =new JLabel("Re-Enter new PIN :");
        repintext.setBounds(150,230, 400, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        image.add(repintext);
        
        repin =new JPasswordField();
        repin.setBounds(310,230, 145, 25);
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(310,310,150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(310,350,150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,670);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
      if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered pin doesnt match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, " plz enter pin ");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, " plz re-enter pin ");
                return;
            }
            
            conn cn =new conn();
            String query1 = "update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
            String query2 = "update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
            String query3 = "update signup3 set pin='"+rpin+"'where pin='"+pinnumber+"'";
            cn.stn.executeUpdate(query1);
            cn.stn.executeUpdate(query2);
            cn.stn.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "pin changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
      }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
      }
    }
    
    public static void main (String args[]){
        new PinChange("");
    }
}
