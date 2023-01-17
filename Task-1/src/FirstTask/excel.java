package FirstTask;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class excel {
    public static void main(String args[]) throws IOException {
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Data");
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
        int batchSize = 20;

        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="123456";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String s = "insert into details(Id,Name,City,Department) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(s);

            for (File file : filesList) {
                System.out.println("File name: " + file.getName());
                BufferedReader br=new BufferedReader(new FileReader(file));

                String h=null;
                int count=0;
                br.readLine();
                while((h= br.readLine())!=null){
                    String[] data=h.split(",");
                    String id=data[0];
                    String name=data[1];
                    String city=data[2];
                    String department=data[3];

                    pst.setInt(1, Integer.parseInt(id));
                    pst.setString(2,name);
                    pst.setString(3,city);
                    pst.setString(4,department);
                    pst.addBatch();
                    if (count%batchSize==0) {
                        pst.executeBatch();
                    }
                }

                br.close();
            }
            System.out.println("Inserted");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
