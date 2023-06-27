package org.example;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new MYSQLConnection().conectaBD();
        Statement statement = connection.createStatement();

        Scanner s = new Scanner(System.in);
        SelectAll selectall = new SelectAll();
        InsertTable insert = new InsertTable();
        deleteLine deleteline = new deleteLine();
        int opc = 0;

        while (opc != 11) {
            System.out.println("------Menu------");
            System.out.println("1. Inserir novo registro de Pagamento");
            System.out.println("2. Listar todos os registros de Pagamento");
            System.out.println("3. Excluir registro de Pagamento");
            System.out.println("4. Baixar comprovante de Pagamento");
            System.out.println("5. Inserir novo registro de Pagador");
            System.out.println("6. Listar todos os registros de Pagador");
            System.out.println("7. Excluir registro de Pagador");
            System.out.println("8. Inserir novo registro de Unidade");
            System.out.println("9. Listar todos os registros de Unidade");
            System.out.println("10. Excluir registro de Unidade");
            System.out.println("11. Sair");
            System.out.println("Escolha uma opção: ");
            opc = s.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.println("Informe o id do Pagador: ");
                    int idPagador = s.nextInt();
                    System.out.println("Informe o id da Unidade: ");
                    int idUnidade = s.nextInt();
                    s.nextLine();

                    System.out.println("Informe a data do Pagamento (YYYY-MM-DD): ");
                    String data = s.nextLine();

                    // Transforma a String data em DateSQL
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date utilDate;
                    Date novaData = null;
                    try {
                        utilDate = dateFormat.parse(data);
                        novaData = new Date(utilDate.getTime());
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. \n" + e);
                    }
                    System.out.println("Informe o ano de referencia do pagamento: ");
                    int anoReferencia = s.nextInt();
                    System.out.println("Informe o mes de referencia do pagamento: ");
                    int mesRereferncia = s.nextInt();
                    s.nextLine();
                    System.out.println("Insira o comprovante: ");
                    String comprovante = s.nextLine();
                    insert.insert_Pagamento(connection, idPagador, idUnidade, novaData, comprovante, anoReferencia, mesRereferncia);
                }
                case 2 -> selectall.ConsultaPagamento(statement);
                case 3 -> {
                    s.nextLine();
                    System.out.println("Informe o id do Pagamento: ");
                    int deleteId1 = s.nextInt();
                    deleteline.delete_Pagamento(connection, deleteId1);
                    System.out.println("Pagamento excluído!");
                }
                case 4 -> {
                    System.out.println("Informe o código do pagamento:");
                    int idPagamento = s.nextInt();
                    Blob.download(connection, idPagamento, "blobbaixado.pdf");
                }
                case 5 -> {
                    s.nextLine();
                    System.out.println("Informe o nome do pagador: ");
                    String nome = s.nextLine();
                    System.out.println("Informe o e-mail do pagador: ");
                    String email = s.nextLine();
                    System.out.println("Informe o telefone do pagador: ");
                    String telefone = s.nextLine();
                    insert.insert_pagador(connection, nome, email, telefone);
                    System.out.println("Pagador inserido!");
                }
                case 6 -> selectall.ConsultaPagador(statement);
                case 7 -> {
                    System.out.println("Informe o id do Pagador: ");
                    int deleteId2 = s.nextInt();
                    deleteline.delete_Pagador(connection, deleteId2);
                    System.out.println("Pagador excluído!");
                }
                case 8 -> {
                    s.nextLine();
                    System.out.println("Informe a localizacao da Unidade: ");
                    String localizacao = s.nextLine();
                    insert.insert_Unidade(connection, localizacao);
                    System.out.println("Unidade inserida!");
                }
                case 9 -> selectall.ConsultaUnidade(statement);
                case 10 -> {
                    System.out.println("Informe o id da Unidade: ");
                    int deleteId3 = s.nextInt();
                    deleteline.delete_Unidade(connection, deleteId3);
                    System.out.println("Unidade excluída!");

                }
                case 11 -> {
                    connection.close();
                    System.out.println("Saindo...");
                }
            }
        }
    }
}