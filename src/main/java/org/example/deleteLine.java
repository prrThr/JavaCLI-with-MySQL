package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class deleteLine {

    public void delete_Unidade(Connection connection, int idUnidade) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call delete_Unidade(?)}");

        callableStatement.setInt(1, idUnidade);

        callableStatement.execute();
        callableStatement.close();
    }

    public void delete_Pagador(Connection connection, int idPagador) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call delete_Pagador(?)}");

        callableStatement.setInt(1, idPagador);

        callableStatement.execute();
        callableStatement.close();
    }

    public void delete_Pagamento(Connection connection, int idPagamento) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call delete_Pagamento(?)}");

        callableStatement.setInt(1, idPagamento);

        callableStatement.execute();
        callableStatement.close();
    }
}
