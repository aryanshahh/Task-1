package FirstTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class update {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="123456";
        try {
            Connection con = DriverManager.getConnection(url,username,password);

            String u="update details set Name=?, City=?, Department=? where Id=?";
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the New Name: ");
            String name= br.readLine();
            System.out.println("Enter the New City: ");
            String city=br.readLine();
            System.out.println("Enter the New Department: ");
            String Department=br.readLine();
            System.out.println("Enter the Employee ID: ");
            int id=Integer.parseInt(br.readLine());

            PreparedStatement pst=con.prepareStatement(u);
            pst.setString(1,name);
            pst.setString(2,city);
            pst.setString(3,Department);
            pst.setInt(4,id);

            pst.executeUpdate();
            System.out.println("Updated");

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
