package com.simon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MoyanaSKConnect {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbname = "jdbc:mysql://moyanask.com:3306/moyanask_login";
            String user = "moyanask_admin";
            String password = "simon";
            Connection connection = null;
            connection = DriverManager.getConnection(dbname, user, password);
            System.out.println("Successfully Connected to MoyanaSK Database");
            connection.close();
        }
        catch(SQLException | ClassNotFoundException exception){
            System.out.println("Error, Did not Connect");
            exception.printStackTrace();
        }
    }
}
