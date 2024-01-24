package bank.management.system;

import java.sql.*;

public class conn {
    public Connection cn=null;
    public Statement stn=null;
    
   public conn(){
       try{ 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","");    
            stn =cn.createStatement(); 
            
       }catch(Exception e){
            System.out.println(e);
       }
   }
}













//?useSSL=false&allowPublicKeyRetrieval=true