package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class InsertTable {

    public void insert_pagador(Connection connection, String nome, String email, String telefone) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call insere_Pagador(?, ?, ?)}");

        callableStatement.setString(1, nome);
        callableStatement.setString(2, email);
        callableStatement.setString(3, telefone);

        callableStatement.execute();
        callableStatement.close();
    }

    public void insert_Unidade(Connection connection, String localizacao) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call insere_Unidade(?)}");

        callableStatement.setString(1, localizacao);

        callableStatement.execute();
        callableStatement.close();
    }

    public void insert_Pagamento(Connection connection, int idPagador,int idUnidade, Date data, String comprovante,
                                 int anoReferencia, int mesReferencia) {
        try (PreparedStatement callableStatement =
                     connection.prepareStatement("insert into Pagamento(idPagador, idUnidade, dataPagamento, comprovante, anoReferencia, mesReferencia) values " +
                             "    (?, ?, ?, ?, ?, ?);")){
            callableStatement.setInt(1, idPagador);
            callableStatement.setInt(2, idUnidade);
            callableStatement.setDate(3, data);

            //File file = new File(comprovante);
            FileInputStream input = new FileInputStream("/home/arthur/IdeaProjects/m3bancodedados/arquivo.pdf");
            callableStatement.setBlob(4, input);
            //System.out.println("Lendo arquivo " + file.getAbsolutePath());
            //System.out.println("Arquivo armazenado no banco de dados");

            callableStatement.setInt(5, anoReferencia);
            callableStatement.setInt(6, mesReferencia);

            //callableStatement.executeUpdate();
            callableStatement.execute();
            //callableStatement.close();
        } catch (SQLException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

