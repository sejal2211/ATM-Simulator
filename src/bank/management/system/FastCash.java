package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton R100, R500, R1000, R2000, R5000, R10000, back;
    String pinnumber;

    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 670);
        add(image);

        JLabel text = new JLabel("Select Withdraw Amout");
        text.setBounds(160, 120, 400, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(text);

        R100 = new JButton("Rs 100");
        R100.setBounds(140, 250, 150, 30);
        R100.addActionListener(this);
        image.add(R100);

        R500 = new JButton("Rs 500");
        R500.setBounds(310, 250, 150, 30);
        R500.addActionListener(this);
        image.add(R500);

        R1000 = new JButton("Rs 1000");
        R1000.setBounds(140, 285, 150, 30);
        R1000.addActionListener(this);
        image.add(R1000);

        R2000 = new JButton("Rs 2000");
        R2000.setBounds(310, 285, 150, 30);
        R2000.addActionListener(this);
        image.add(R2000);

        R5000 = new JButton("Rs 5000");
        R5000.setBounds(140, 320, 150, 30);
        R5000.addActionListener(this);
        image.add(R5000);

        R10000 = new JButton("Rs 10000");
        R10000.setBounds(310, 320, 150, 30);
        R10000.addActionListener(this);
        image.add(R10000);

        back = new JButton("BACK");
        back.setBounds(230, 355, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 670);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            conn cn = new conn();
            try {
                ResultSet rs = cn.stn.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else if (rs.getString("type").equals("recieve")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','withdraw','" + amount + "')";
                cn.stn.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs :" + amount + " withdraw Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
