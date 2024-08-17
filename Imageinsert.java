import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class Imageinsert {
    public static void main(String[] args) throws ClassNotFoundException {

//for databse connection
        String url = "jdbc:mysql://localhost:3306/companydb";
        String username = "root";
        String password = "#12@Sunil34$";
        String img_path = "C:\\sunil\\download.jpeg";
        String query = "INSERT INTO image_table(image_data) VALUES(?)";


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
//conevert img or file into binnary from
            FileInputStream fileInputStream = new FileInputStream(img_path);
            //after converting wee have to store in array
            byte[] imagedata = new byte[fileInputStream.available()];
            //store binaery data
            fileInputStream.read(imagedata);


            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setBytes(1,imagedata);


            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println( "image inserted sucess");

            }else{
                System.out.println("image inserted failed");
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



