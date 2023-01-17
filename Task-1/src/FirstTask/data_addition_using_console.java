package FirstTask;
import java.sql.*;
import java.io.*;
public class data_addition_using_console{
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="123456";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =DriverManager.getConnection(url,username,password);

            String s="insert into details(Id,Name,City,Department) values(?,?,?,?)";

            PreparedStatement pst=con.prepareStatement(s);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.println("Enter the Employee ID: ");
                int id = Integer.parseInt(br.readLine());

                System.out.println("Enter the Employee name: ");
                String name = br.readLine();

                System.out.println("Enter the City: ");
                String city = br.readLine();

                System.out.println("Enter Department: ");
                String department = br.readLine();

                pst.setInt(1, id);
                pst.setString(2, name);
                pst.setString(3, city);
                pst.setString(4, department);
                pst.addBatch();
                System.out.println("Want to add more records Yes/No");
                String ans = br.readLine();
                if (ans.equals("no")) {
                    break;
                } else if (ans.equals("yes")) {

                }else {
                    System.out.println("Invalid Input");
                    break;
                }
            }
            pst.executeBatch();
            System.out.println("Inserted");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}