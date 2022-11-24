package com.simon;

import jdk.jshell.spi.SPIResolutionException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UploadStudents {

    public void mySQL() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(db,user,pass);
            System.out.println("Connected");

            String sql = "INSERT INTO student(student)" + "VALUES(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int x = 0;
            Scanner files = new Scanner(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt"));
            while (files.hasNextLine()){
                x++;
                files.nextLine();
            }

            String file = null;
            for (int i = 0; i < x; i++) {
                file = Files.readAllLines(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt")).get(i);

                preparedStatement.setString(1, file);

                preparedStatement.executeUpdate();

            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }

    }

    public void mySQLSupervisors() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(db,user,pass);
            System.out.println("Connected");

            String sql = "INSERT INTO supervisor(project-supervisor)" + "VALUES(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int x = 0;
            Scanner files = new Scanner(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt"));
            while (files.hasNextLine()){
                x++;
                files.nextLine();
            }

            String file = null;
            for (int i = 0; i < x; i++) {
                file = Files.readAllLines(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt")).get(i);

                preparedStatement.setString(1, file);

                preparedStatement.executeUpdate();

            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }

    }

    public void uploadStudentProject() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(db,user,pass);
            System.out.println("Connected");

            String sql = "INSERT INTO sp(studentp)" + "VALUES(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int x = 0;
            Scanner files = new Scanner(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\student-project.dat"));
            while (files.hasNextLine()){
                x++;
                files.nextLine();
            }

            String file = null;
            for (int i = 0; i < x; i++) {
                file = Files.readAllLines(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\student-project.dat")).get(i);

                preparedStatement.setString(1, file);

                preparedStatement.executeUpdate();

            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void uploadProjects() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(db,user,pass);
            System.out.println("Connected");

            String sql = "INSERT INTO projects(project)" + "VALUES(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int x = 0;
            Scanner files = new Scanner(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\projects.txt"));
            while (files.hasNextLine()){
                x++;
                files.nextLine();
            }

            String file = null;
            for (int i = 0; i < x; i++) {
                file = Files.readAllLines(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\projects.txt")).get(i);

                preparedStatement.setString(1, file);

                preparedStatement.executeUpdate();

            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void getStudents() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(db,user,pass);
            System.out.println("Connected");

            String sql = "SELECT student FROM student";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<String> students = new ArrayList<>();
            while(resultSet.next()){
                students.add(resultSet.getString("student"));
            }
            System.out.println(students);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void clearTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        Connection connection = DriverManager.getConnection(db,user,pass);
        System.out.println("Connected");

        String clear = "DELETE FROM sp";

        PreparedStatement preparedStatement = connection.prepareStatement(clear);

        preparedStatement.executeUpdate();
        System.out.println("Table Successfully cleared");
        connection.close();
    }

    public void uploadStudentLogin() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/sdd";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(db,user,pass);
            System.out.println("Connected");

            String sql = "INSERT INTO users(username, password, role)" + "VALUES(?, ?, 3)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int x = 0;
            Scanner files = new Scanner(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt"));
            while (files.hasNextLine()){
                x++;
                files.nextLine();
            }

            String file = null;
            for (int i = 0; i < x; i++) {
                file = Files.readAllLines(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt")).get(i);

                preparedStatement.setString(1, file);
                preparedStatement.setString(2, "admin");

                preparedStatement.executeUpdate();

            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void uploadStudentLoginFile() throws IOException {
        int x = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\src\\main\\java\\database\\logins2.txt", true));
        Scanner files = new Scanner(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt"));
        while (files.hasNextLine()){
            x++;
            files.nextLine();
        }

        for (int i = 0; i < x; i++) {
            String line = Files.readAllLines(Paths.get("C:\\Users\\smoya\\IdeaProjects\\FYPSystem0.9\\students.txt")).get(i);
            writer.append("\nUsername: " +line);
        }
        writer.close();
    }

    public UploadStudents() throws SQLException, IOException, ClassNotFoundException {
        mySQL();
        //mySQLSupervisors();
        //uploadStudentProject();
        //uploadProjects();
        //getStudents();
        //clearTable();
        //uploadStudentLogin();
        //uploadStudentLoginFile();
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        new UploadStudents();
    }
}
