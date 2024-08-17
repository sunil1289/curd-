import java.sql.*;

public class TransactionHandling {
    public static void main(String[] args) {
        // for database connection
        String url = "jdbc:mysql://localhost:3307/mydatabase";
        String username = "root";
        String password = "";
        String withdrawQuery = "UPDATE account SET balance = balance - ? WHERE account_num = ?";
        String depositQuery = "UPDATE account SET balance = balance + ? WHERE account_num = ?";

        try {
            // for connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
            con.setAutoCommit(false);

            try (PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                 PreparedStatement depositStatement = con.prepareStatement(depositQuery)) {

                withdrawStatement.setDouble(1, 100.50);
                withdrawStatement.setString(2, "account123");
                depositStatement.setDouble(1, 20);
                depositStatement.setString(2, "account4856");

                int rowsAffectedWithdraw = withdrawStatement.executeUpdate();
                int rowsAffectedDeposit = depositStatement.executeUpdate();
                if(rowsAffectedDeposit>0 && rowsAffectedWithdraw>0){
                    con.commit();
                    System.out.println("Transaction successful");
                }else{
                    con.rollback();
                    System.out.println("Transaction failed:");
                }

            } catch (SQLException e) {
                System.out.println( e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
