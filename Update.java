
import java.sql.*;

public class Update {
    public static void main(String[] args) throws ClassNotFoundException {

//for databse connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "#12@Sunil34$";
        String query =  "UPDATE employee\n" +
        "SET name = 'syam',job_title = 'full stack devloper',salary = 4000\n"+
                " WHERE id = 2";

        try {

            //driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded successfully ");

        }
        catch (ClassNotFoundException  e){
            System.out.println(e.getMessage());
        }

        try {
            //for connection

            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connection establish successfully");

            //satement to execute query
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);
            if(rowsaffected>0){
                System.out.println("update sucessfully." + rowsaffected +"row(s) affected.");

            }else{
                System.out.println("failed");
            }


            stmt.close();
            con.close();
            System.out.println();
            System.out.println("connection close succcess fully");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
