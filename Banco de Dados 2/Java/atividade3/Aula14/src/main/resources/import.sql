DROP TABLE IF EXISTS pessoa;
CREATE TABLE pessoas (
    ID int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    idade int,
    PRIMARY KEY (ID)
);
INSERT INTO pessoas (nome, idade) VALUES ("Ana", 10);
INSERT INTO pessoas (nome, idade) VALUES ("Bia", 20);