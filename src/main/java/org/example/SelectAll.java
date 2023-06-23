package org.example;

import java.sql.ResultSet;
import java.sql.Statement;


public class SelectAll {
    public SelectAll() {
    }

    public void ConsultaPagamento(Statement statement){
        try{
            ResultSet rs = statement.executeQuery("SELECT Pagamento.anoReferencia, Pagamento.mesReferencia, Pagador.nomeCompleto" +
                    " as nomePagador, Pagamento.idUnidade, Pagamento.idPagamento, Pagamento.dataPagamento, Pagamento.comprovante, " +
                    "Pagamento.dataRegistro FROM Pagamento JOIN Pagador ON Pagamento.idPagador = Pagador.rg ORDER BY " +
                    "Pagamento.anoReferencia, Pagamento.mesReferencia");

            while (rs.next()){
                System.out.println(rs.getInt(1) + " "+ rs.getInt(2)+ " " +
                        rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5) +
                        " " + rs.getDate(6) + " " + rs.getBlob(7) + " " + rs.getDate(8));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ConsultaPagador(Statement statement){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM Pagador");
            while(rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                            rs.getString(3) + " " + rs.getString(4));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ConsultaUnidade(Statement statement){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM Unidade");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
