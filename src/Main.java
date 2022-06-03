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

        try {
            Connection conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión exitosa");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from funciones");

            resultSet.next();
            int idSala = resultSet.getInt(1);
            Date fecha = resultSet.getDate(2);
            System.out.println("id: "+idSala);
            System.out.println("fecha: "+fecha);



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

