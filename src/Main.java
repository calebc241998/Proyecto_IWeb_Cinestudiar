package src;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mysystem4";


        String sql = "select * from funciones";
        try (Connection conn = DriverManager.getConnection(url,user,pass);
             Statement statement =conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Conexión exitosa");

            while( resultSet.next()){
                int id = resultSet.getInt(1);
                Date fecha = resultSet.getDate(2);
                System.out.println("id: "+id+ "   |   fecha: "+fecha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

