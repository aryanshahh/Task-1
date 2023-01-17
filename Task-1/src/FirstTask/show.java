package FirstTask;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class show {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="123456";
        Statement st;
        try {
            Connection con = DriverManager.getConnection(url,username,password);

            String query="select * from details";
            st= con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String city=rs.getString(3);
                String department=rs.getString(4);



                System.out.println("Employee ID: " +id+ ", Employee Name: " +name+ ", Employee City: " +city+ ", Employee Department: " +department+".");
            }

            rs.close();
            st.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
