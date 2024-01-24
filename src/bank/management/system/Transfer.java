package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Transfer extends JFrame implements ActionListener {

    String pinnumber;
    JButton transfer, back;
    JTextField amount, tpin;
    JLabel pinnum, money;

    Transfer(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 670);
        add(image);

        pinnum = new JLabel("ENTER RECEIVER PIN :");
        pinnum.setBounds(150, 120, 400, 25);
        pinnum.setForeground(Color.WHITE);
        pinnum.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(pinnum);

        tpin = new JTextField();
        tpin.setFont(new Font("Raleway ", Font.BOLD, 22));
        tpin.setBounds(150, 150, 300, 25);
        image.add(tpin);

        money = new JLabel("AMOUNT TO BE TRANSFER :");
        money.setBounds(150, 185, 400, 25);
        money.setForeground(Color.WHITE);
        money.setFont(new Font("System", Font.BOLD, 16));
        image.add(money);

        amount = new JTextField();
        amount.setFont(new Font("Raleway ", Font.BOLD, 22));
        amount.setBounds(150, 220, 300, 25);
        image.add(amount);

        transfer = new JButton("Transfer");
        transfer.setBounds(310, 310, 150, 30);
        transfer.addActionListener(this);
        image.add(transfer);

        back = new JButton("Back");
        back.setBounds(310, 350, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 670);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String rpin = tpin.getText();
            String number = amount.getText();
            Date date = new Date();
            if (ae.getSource() == transfer) {
                if (number.equals("") || rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the required information ");
                } else {
                    conn cn = new conn();
                    ResultSet rs = cn.stn.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                    int ownerbalance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            ownerbalance += Integer.parseInt(rs.getString("amount"));
                        }else if(rs.getString("type").equals("recieve")){
                            ownerbalance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            ownerbalance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (ownerbalance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }
                    
                    String query1 ="insert into bank values('"+pinnumber+"','"+date+"','transfer','"+number+"')";
                    cn.stn.executeUpdate(query1);
                    String query2 ="insert into bank values('"+rpin+"','"+date+"','recieve','"+number+"')";
                    cn.stn.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" transfer Successfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Transfer("");
    }
}
