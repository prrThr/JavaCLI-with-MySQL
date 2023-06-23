package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

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

    public void insert_Pagamento(Connection connection, int idPagador, int idUnidade, Date data, int anoReferencia, int mesReferencia) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call insere_Pagamento(?, ?, ?, ?, ?)}");

        callableStatement.setInt(1, idPagador);
        callableStatement.setInt(2, idUnidade);
        callableStatement.setDate(3, data);
        callableStatement.setInt(4, anoReferencia);
        callableStatement.setInt(5, mesReferencia);


        callableStatement.execute();
        callableStatement.close();
    }
}

