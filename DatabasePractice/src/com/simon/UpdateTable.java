package com.simon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdd","root", "");
            System.out.println("Connected!");

            String sql = "UPDATE fyprojects SET students = 'simon' WHERE id_num = 1";
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql);
            System.out.println("Added Successfully");

            conn.close();
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
