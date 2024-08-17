import java.io.*;
import java.sql.*;

public class imageretrive {
    public static void main(String[] args) throws ClassNotFoundException {

//for databse connection
        String url = "jdbc:mysql://localhost:3306/companydb";
        String username = "root";
        String password = "#12@Sunil34$";
        String folder_path  = "C:\\sunil\\";
        String query = "SELECT image_data from image_table WHERE image_id =(?)";



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


            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,1);


            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                byte[] image_data = resultSet.getBytes("image_data");
                String image_path = folder_path + "extracted_image.jpg";
                OutputStream outputStream = new FileOutputStream(image_path);
                outputStream.write(image_data);


            }else{
                System.out.println("image not found ");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



