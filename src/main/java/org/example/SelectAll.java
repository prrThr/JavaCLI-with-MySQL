package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAll {
    public SelectAll() {
    }

    public void Consulta (Connection connection, Statement statement, String entidade) {
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM " + entidade);
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
