CREATE DATABASE mocks;
DROP DATABASE mocks;
USE mocks;

CREATE TABLE LEILAO(
	leilao_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    descricao VARCHAR(255),
    data DATE,
    lances VARCHAR(255),
    encerrado BOOLEAN    
) ENGINE=INNODB;

CREATE TABLE USUARIO(
	usuario_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255)
) ENGINE=INNODB;

CREATE TABLE LANCES(
	lances_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    valor DECIMAL,
    usuario_id INT,
    CONSTRAINT fk_usuario
    FOREIGN KEY (usuario_id)
		REFERENCES usuario(usuario_id)
) ENGINE=INNODB;