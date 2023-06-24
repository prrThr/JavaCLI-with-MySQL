package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Blob {

    public static void download(Connection connection, int idPagamento, String newfilename) {
        try {
            String query = "SELECT comprovante FROM Pagamento WHERE idPagamento=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idPagamento);
            ResultSet rs = ps.executeQuery();

            File file = new File(newfilename);
            try (FileOutputStream output = new FileOutputStream(file)) {
                System.out.println("Writing to file " + file.getAbsolutePath());
                while (rs.next()) {
                    InputStream input = rs.getBinaryStream("comprovante");
                    byte[] buffer = new byte[1024];
                    while (input.read(buffer) > 0) {
                        output.write(buffer);
                    }
                }
            } catch (IOException e) { // catch da leitura de arquivo
                System.out.println("Não foi possível ler o arquivo. \n" + e);
            }
        } catch (Exception e) { // catch da conexão
            e.printStackTrace();
        }

    }
}