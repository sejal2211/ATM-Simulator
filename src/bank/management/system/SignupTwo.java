    
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel l2,Religion, Category ,Income ,Education ,Qualification,Occupation ,PAN ,Adhar ,Seniorcitizen ,ExistingAcc;
    JTextField tPAN,tAdhar;
    JRadioButton r1,r2,r3,r4;
    JButton b;
    JComboBox religion, category ,income ,education ,occupation;
    String formno;
    
     SignupTwo(String formno){
         this.formno=formno;
        setLayout(null);
           
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        
        l2 = new JLabel("Page 2: Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(290,20,400,30);
        add(l2);
        
        Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion.setBounds(100,80,100,30);
        add(Religion);
        
        String valReligion[]={"Hindu","Muslim" ,"Sikh" ,"others"};
        religion =new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,80,400,30);
        add(religion);
        
        Category= new JLabel("Category:");
        Category.setFont(new Font("Raleway", Font.BOLD, 20));
        Category.setBounds(100,130,200,30);
        add(Category);
        
        String valCategory[]={"General","OBC" ,"SC/ST" ,"others"};
        category =new JComboBox(valCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300,130,400,30);
        add(category);
        
        Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(100,180,200,30);
        add(Income);
        
        String incomeCategory[]={"Null","<1,50,000" ,"<2,50,000" ,"upto 10lakh"};
        income =new JComboBox(incomeCategory);
        income.setBackground(Color.WHITE);
        income.setBounds(300,180, 400, 30);
        add(income);
        
        Education = new JLabel("Educational");
        Education.setFont(new Font("Raleway", Font.BOLD, 20));
        Education.setBounds(100,230,200,30);
        add(Education);
        
        Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(100,260,200,30);
        add(Qualification );
        
        String educationval[]={"Non Graduate","Graduate" ,"Post Graduate" ,"Doctorate" ,"Others"};
        education =new JComboBox(educationval);
        education.setBackground(Color.WHITE);
        education.setBounds(300,260, 400, 30);
        add(education);
        
        Occupation= new JLabel("Ocupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100,310,200,30);
        add(Occupation);
        
        String occupationval[]={"Salaried","Busiiness-man" ,"Self-Employed" ,"Student" ,"Retired","others"};
        occupation =new JComboBox(occupationval);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,310, 400, 30);
        add(occupation);
        
        PAN = new JLabel("PAN No:");
        PAN.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN.setBounds(100,360,200,30);
        add(PAN);
        
        tPAN = new JTextField();
        tPAN.setFont(new Font("Raleway", Font.BOLD, 14));
        tPAN.setBounds(300,360,400,30);
        add(tPAN);
        
        Adhar= new JLabel("Adhar No:");
        Adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Adhar.setBounds(100,410,200,30);
        add(Adhar);
        
        tAdhar = new JTextField();
        tAdhar.setFont(new Font("Raleway", Font.BOLD, 14));
        tAdhar.setBounds(300,410,400,30);
        add(tAdhar);
        
        Seniorcitizen= new JLabel("Senior Citizen:");
        Seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        Seniorcitizen.setBounds(100,460,200,30);
        add(Seniorcitizen);
        
        r1 = new JRadioButton("yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(300,460,100,30);
        add(r1);
        
        r2 = new JRadioButton("no");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(450,460,100,30);
        add(r2);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(r1);
        senior.add(r2);
        
        ExistingAcc= new JLabel("Existing Account:");
        ExistingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        ExistingAcc.setBounds(100,500,200,30);
        add(ExistingAcc);
        
        
        r3 = new JRadioButton("yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300,500,100,30);
        add(r3);
        
        r4 = new JRadioButton("no");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450,500,100,30);
        add(r4);
        
        ButtonGroup eaccount = new ButtonGroup();
        eaccount.add(r3);
        eaccount.add(r4);
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(620,550,80,30); 
        b.addActionListener(this);
        add(b); 
        
        setSize(850,750);
        setVisible(true);
        setLocation(200,0);
    }
     

     public void actionPerformed(ActionEvent ae){
          
           String sreligion =(String)religion.getSelectedItem();
           String scategory =(String)category.getSelectedItem();
           String sincome =(String)income.getSelectedItem();
           String seducation =(String)education.getSelectedItem();
           String soccupation =(String)occupation.getSelectedItem();
           String SN=null;
           if(r1.isSelected()){
               SN="yes";
           }else if(r2.isSelected()){
               SN="no";
           }
   
           String EA =null;
           if(r3.isSelected()){
               EA="yes";
           }else if(r4.isSelected()){
               EA="no";
           }
           String span=tPAN.getText();
           String sadhar=tAdhar.getText();
           
           try{
               
                   conn cnns=new conn();
                   String query="insert into signuptwo values( '"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+SN+"','"+EA+"')";
                   cnns.stn.executeUpdate(query);
                   
                   setVisible(false);
                   new Signup3(formno).setVisible(true);
           }catch (Exception e){
               System.out.println(e);
           }
           
    }
    
    public static void main(String args[]){
        new SignupTwo("");
        
    }
}

