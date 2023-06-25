package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MYSQLConnection {
    public Connection conectaBD() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/M3?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        Scanner scanner = new Scanner(System.in);
        String user = "";
        String passwd = "";

        while (isUserValid(user, passwd)) {
            System.out.print("Digite o usuário: ");
            user = scanner.nextLine();

            System.out.print("Digite a senha: ");
            passwd = scanner.nextLine();

            if (isUserValid(user, passwd)) {
                System.out.println("Usuário ou senha incorretos. Tente novamente.");
            }
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, passwd);
    }

    private boolean isUserValid(String user, String passwd) {
        return !user.equals("padrao") || !passwd.equals("tHs152A#");
    }
}