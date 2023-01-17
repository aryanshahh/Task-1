package FirstTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class delete {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="123456";
        try {

            Connection con = DriverManager.getConnection(url, username, password);
            String s = "delete from details where Id=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PreparedStatement pst;

            System.out.println("Enter the Employee ID: ");
            int id = Integer.parseInt(br.readLine());

            pst = con.prepareStatement(s);
            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("Deleted");

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
