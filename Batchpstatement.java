import java.sql.*;

public class Batchpstatement {

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
                Statement statement = con.createStatement();
                statement.addBatch("INSERT INTO empolyes (name,job,salary) VALUES ('hari','java devloper',2000.00)");
                statement.addBatch("INSERT INTO empolyes (name,job,salary) VALUES ('shital','c  devloper',3000.00)");
                statement.addBatch("INSERT INTO empolyes (name,job,salary) VALUES ('ram','python devloper',1000.00)");
                statement.addBatch("INSERT INTO empolyes (name,job,salary) VALUES ('kirshna','javascprit devloper',1000.00)");
                int[] batchresult = statement.executeBatch();
                con.commit();
                System.out.println("batch sucess");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }
