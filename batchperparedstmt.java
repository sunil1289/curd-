import java.sql.*;
import java.util.Scanner;

public class batchperparedstmt {

    public static void main(String[] args) {
        // for database connection
        String url = "jdbc:mysql://localhost:3307/mydatabase";
        String username = "root";
        String password = "";

        try {

            //driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded successfully ");


        }
        catch (ClassNotFoundException  e){
            System.out.println(e.getMessage());
        }

        try {
            // for connection
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            String query = "INSERT INTO empolyes (name,job,salary) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("Enter your name ");
                String name = sc.nextLine();
                System.out.println("enter your job");
                String job = sc.nextLine();
                System.out.println("enter your salary");
                double salary = sc.nextDouble();
                sc.nextLine();
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,job);
                preparedStatement.setDouble(3,salary);
                preparedStatement.addBatch();
                System.out.println("add more values Y/N: ");
                String decsion = sc.nextLine();
                if (decsion.toUpperCase().equals("N")){
                    break;
                }
            }
int[] batchresult = preparedStatement.executeBatch();
            con.commit();
            System.out.println("batch execute sucess");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
