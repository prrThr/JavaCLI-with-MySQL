package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnection {
    public Connection conectaBD() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/M3?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String passwd = "galinha20";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, passwd);
    }
}