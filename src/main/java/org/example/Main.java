package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Conectando com o banco de dados
        Connection connection = new MYSQLConnection().conectaBD();
        Statement statement = connection.createStatement();

        // Fazendo chamada de consulta (SELECT * FROM ...)
        SelectAll selectAll = new SelectAll();
        selectAll.Consulta(connection, statement, "Unidade");
    }
}