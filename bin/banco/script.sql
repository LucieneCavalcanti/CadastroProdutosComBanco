create database BDLPINOITE
USE BDLPINOITE
CREATE TABLE TBPRODUTOS(
id int not null primary key identity,
nome varchar(100) not null,
preco decimal(10,2) not null,
categoria varchar(50) not null
)
