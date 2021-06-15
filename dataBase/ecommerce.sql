CREATE DATABASE ecommerce;

CREATE TABLE endereco (
 enderecoid serial CONSTRAINT pk_id_endereco PRIMARY KEY,
 cep varchar(12) NOT NULL, 
 rua varchar(100) NOT NULL,
 bairro varchar(100) NOT NULL,
 cidade varchar(100) NOT NULL,
 numero int4 NOT NULL,
 complemento varchar,
 estado varchar(30)
 );

CREATE TABLE client (
 clientid serial CONSTRAINT pk_id_client PRIMARY KEY,
 email varchar(50) NOT NULL UNIQUE, 
 username varchar(50) NOT NULL UNIQUE,
 senha varchar NOT NULL ,
 nome varchar(40) NOT NULL,
 cpf varchar NOT NULL UNIQUE,
 telefone varchar(20) NOT NULL,
 datadenascimento date NOT NULL,
 enderecoid int4 NOT NULL REFERENCES endereco(enderecoid)
 );

CREATE TABLE pedido (
 pedidoid serial CONSTRAINT pk_id_pedido PRIMARY KEY,
 numeropedido int4  , 
 valortotal real NOT NULL ,
 datadopedido date DEFAULT now(),
 status varchar NOT NULL,
 clientid int4 NOT NULL REFERENCES client(clientid)
 );

CREATE TABLE categoria (
 categoriaid serial CONSTRAINT pk_id_categoria PRIMARY KEY,
 nome varchar(40) NOT NULL, 
 descricao varchar NOT NULL
 );

CREATE TABLE Produto (
 produtoid serial CONSTRAINT pk_id_produto PRIMARY KEY,
 nome varchar(40) NOT NULL, 
 descricao varchar NOT NULL, 
 preco real NOT NULL,
 quantidadeestoque int4 NOT NULL,
 datadecadastro date DEFAULT now(),
 categoriaid int4 NOT NULL REFERENCES categoria(categoriaid)
 );

CREATE TABLE produtos_pedidos (
 produtospedidosid serial CONSTRAINT pk_id_ppid PRIMARY KEY,
 produtoid int4 NOT NULL REFERENCES produto(produtoid) ,
 pedidoid int4 NOT NULL REFERENCES pedido(pedidoid),
 quantidade int4 NOT NULL ,
 preco real NOT NULL 
 );