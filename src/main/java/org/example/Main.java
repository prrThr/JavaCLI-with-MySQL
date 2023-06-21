package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Connection connection = new MYSQLConnection().conectaBD();
        //Statement statement = connection.createStatement();
        Teste te = new Teste();
        te.Chama();
    }
}