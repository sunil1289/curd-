
import java.sql.*;

public class Retrive {
    public static void main(String[] args) throws ClassNotFoundException {

//for databse connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "#12@Sunil34$";
        String query =  " select * from employee;";

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
  //execute query
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("=================");
                System.out.println("id:" + id);
                System.out.println("name:" + name);
                System.out.println("job_title:" + job_title);
                System.out.println("salary:" + salary);
            }
            rs.close();
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


