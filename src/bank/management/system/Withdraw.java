package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdraw(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 670);
        add(image);

        JLabel text = new JLabel("Enter the amount you want withdraw :");
        text.setBounds(160, 120, 400, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway ", Font.BOLD, 22));
        amount.setBounds(150, 200, 300, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(310, 310, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
            String number = amount.getText();
            Date date = new Date();
            if (ae.getSource() == withdraw) {
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    conn cn = new conn();
                    ResultSet rs = cn.stn.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if(rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else if (rs.getString("type").equals("recieve")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }

                    String query = "insert into bank values('" + pinnumber + "','" + date + "','withdraw','" + number + "')";
                    cn.stn.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdraw Successfully");

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

    public static void main(String args[]) {
        new Withdraw("");
    }
}
