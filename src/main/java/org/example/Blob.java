package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Blob {

    public static void download(Connection connection, int idPagamento, String filename) throws SQLException, IOException {
        try {
            PreparedStatement ps = connection.prepareStatement("select comprovante from Pagamento where idPagamento=?");
            ps.setInt(1, idPagamento);
            ResultSet rs = ps.executeQuery();

            File file = new File(filename);
            FileOutputStream output = new FileOutputStream(file);
            System.out.println("Writing to file " + file.getAbsolutePath());

            while (rs.next()) {
                InputStream input = rs.getBinaryStream("comprovante");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}