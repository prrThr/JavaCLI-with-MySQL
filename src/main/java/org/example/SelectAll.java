package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class SelectAll {
    public SelectAll() {
    }

    public void Consulta (Connection connection, Statement statement, String entidade) {
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM " + entidade);
            while(rs.next()){
                if (Objects.equals(entidade, "Pagador"))
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+
                            rs.getString(3) + rs.getString(4));
                else if (Objects.equals(entidade, "Unidade"))
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                else // TODO: Alterar formatos corretos do rs.get() ou reduzir código <-Pagamento->
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+
                            rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+
                            " "+rs.getString(6)+" "+rs.getString(7));
            }
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
