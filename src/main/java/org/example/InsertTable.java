package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class InsertTable {

    public void insert_pagador(Connection connection, String nome, String email, String telefone) throws SQLException {
        String query = "{call insere_Pagador(?, ?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(query);

        callableStatement.setString(1, nome);
        callableStatement.setString(2, email);
        callableStatement.setString(3, telefone);

        callableStatement.execute();
        callableStatement.close();
    }

    public void insert_Unidade(Connection connection, String localizacao) throws SQLException {
        String query = "{call insere_Unidade(?)}";
        CallableStatement callableStatement = connection.prepareCall(query);

        callableStatement.setString(1, localizacao);

        callableStatement.execute();
        callableStatement.close();
    }

    public void insert_Pagamento(Connection connection, int idPagador, int idUnidade, Date data, String filepath,
                                 int anoReferencia, int mesReferencia) throws SQLException, FileNotFoundException {
        String query = "{call insere_Pagamento(?, ?, ?, ?, ?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(query);

        try (FileInputStream input = new FileInputStream(filepath)){
            callableStatement.setInt(1, idPagador);
            callableStatement.setInt(2, idUnidade);
            callableStatement.setDate(3, data);
            callableStatement.setBlob(4, input);
            callableStatement.setInt(5, anoReferencia);
            callableStatement.setInt(6, mesReferencia);
            System.out.println("Pagamento inserido!");
            callableStatement.execute();
        } catch (FileNotFoundException e) {
            System.out.println("O caminho do arquivo não existe.");
            System.out.println("Tente novamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

