package FirstTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class create {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="123456";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);

            String s="create table details(Id int(20) primary key auto_increment, Name varchar(200) not null, City varchar(400), Department varchar(200))";
            Statement st= con.createStatement();
            st.executeUpdate(s);
            System.out.println("Table Created");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
