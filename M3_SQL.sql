-- CRIANDO DATABASE ----------------------------------------------------------------------------------------------------

CREATE DATABASE IF NOT EXISTS M3;
USE M3;

-- DDL -----------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Pagador (
	rg INT AUTO_INCREMENT PRIMARY KEY,
    nomeCompleto varchar(50),
    email varchar(40),
    tel varchar(9)
);

CREATE TABLE IF NOT EXISTS Unidade (
	id INT AUTO_INCREMENT PRIMARY KEY,
    localizacao varchar(30)
);

CREATE TABLE IF NOT EXISTS Pagamento (
	idPagador INT,
    idUnidade INT,
    FOREIGN KEY (idPagador) REFERENCES Pagador (rg),
    FOREIGN KEY (idUnidade) REFERENCES Unidade (id),
    idPagamento INT AUTO_INCREMENT PRIMARY KEY,
    dataPagamento date,
    comprovante MEDIUMBLOB,
    anoReferencia INT,
    mesReferencia INT,
    dataRegistro date
);

-- CRIANDO UM USUÁRIO PADRÃO -------------------------------------------------------------------------------------------

CREATE USER 'padrao'@'localhost' IDENTIFIED BY 'tHs152A#';
GRANT ALL PRIVILEGES ON M3.* TO 'padrao'@'localhost';
# SHOW GRANTS FOR 'padrao'@'localhost';
FLUSH PRIVILEGES;

-- Trigger RNF06 -------------------------------------------------------------------------------------------------------

delimiter $
CREATE TRIGGER insert_date BEFORE insert on Pagamento
FOR EACH ROW BEGIN
	SET NEW.dataRegistro = now();
END$
delimiter ;

-- INSERTS -------------------------------------------------------------------------------------------------------------
INSERT INTO Pagador(nomeCompleto, email, tel) VALUES
("Arthur Pereira", "arthur@gmail.com", "912345678"),
("Cleber Oliveira", "cleber@protonmail.com", "987651234");

INSERT INTO Unidade(localizacao) VALUES
("Apartamento 101"),
("Apartamento 502");

# As seguintes inserções NÃO teram arquivo BLOB
# Inserções com arquivos devem ser feitas durante a execução do programa
INSERT INTO Pagamento(idPagador, idUnidade, dataPagamento, anoReferencia, mesReferencia) VALUES
("1", "1", "2023-05-20", "2023", "5"),
("2", "2", "2023-04-01", "2023", "4"),
("1", "1", "2021-06-20", "2021", "6"),
("2", "2", "2022-01-01", "2022", "1");

-- PROCEDURES ---------------------------------------------------------------------------------------------

delimiter $
create procedure insere_Pagador(in nome varchar(50), email varchar(50), telefone varchar(9))
begin
	insert into Pagador(nomeCompleto, email, tel) values
    (nome, email, telefone);
END$
delimiter ;

delimiter $
create procedure insere_Unidade(in localizacao varchar(30))
begin
	insert into Unidade(localizacao) values
    (localizacao);
END$
delimiter ;

delimiter $
create procedure insere_Pagamento(in idPagador int, in idUnidade int, in dataPagamento date, in comprovante mediumblob, in anoReferencia int, in mesReferencia int)
begin
    insert into Pagamento(idPagador, idUnidade, dataPagamento, comprovante, anoReferencia, mesReferencia) values
        (idPagador, idUnidade, dataPagamento, comprovante, anoReferencia, mesReferencia);
END$
delimiter ;

delimiter $
create procedure delete_Unidade(in idUnidade int)
begin
	delete from Unidade where id = idUnidade;
END$
delimiter ;

delimiter $
create procedure delete_Pagador(in idPagador int)
begin
	delete from Pagador where rg = idPagador;
END$
delimiter ;

delimiter $
create procedure delete_Pagamento(in id int)
begin
	delete from Pagamento where idPagamento = id;
END$
delimiter ;

/*-- RF5 -----------------------------------------------------------------------------------------------------------------
SELECT Pagamento.anoReferencia, pagamento.mesReferencia, pagador.nomeCompleto as nomePagador, pagamento.idUnidade, pagamento.idPagamento, pagamento.dataPagamento, pagamento.comprovante, pagamento.dataRegistro
FROM Pagamento
JOIN Pagador ON pagamento.idPagador = pagador.rg
ORDER BY pagamento.anoReferencia, pagamento.mesReferencia;

-- Testes ------------------------------------------------------------------------------------------------------- 
CALL insere_Pagador("Para Excluir", "excluir@gmail.com", "998462215");
CALL insere_Unidade("Apartamento 503");
CALL insere_Pagamento("5", "1", "2023-06-23", "2023", "6");
CALL delete_Unidade(6);
CALL delete_Pagador(9);
CALL delete_Pagamento(8);

select * from Pagamento;
select * from Pagador;
select * from Unidade;*/