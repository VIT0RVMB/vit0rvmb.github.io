Create database comicstore
use comicstore
go


CREATE TABLE cliente(
cpf varchar(11) primary key,
nome varchar(100),
nascimento date,
endereco varchar(100),
complemento varchar(30),
telefone varchar(11))
go

Create Table produto(
id int not null auto_increment primary key,
nome varchar(100),
descricao varchar(240),
preco decimal,
estoque int)
GO
Create TABLE jogos(
id  int  not null auto_increment primary key,
distribuidora varchar(100),
genero varchar(30),
foreign key (id) references produto(id))
GO
CREATE TABLE livro(
id int  not null auto_increment primary key,
isbn varchar(13),
editora varchar(100),
autor varchar (100),
foreign key (id) references produto(id))

drop table livro
go
drop table jogos
go
drop table produto

drop table cliente

Start Transaction prod
Insert into produto(nome, descricao, preco, estoque)values('sahfuahsf','hsahasuh', 50.90, 500)
insert into jogos(id,distribuidora, genero)
values(,'saijfsaif', 'jsaifjai')

Commit prod


select * from produto
select * from livro
select * from jogos 
select * from cliente
delete from livro where ID>0
go
delete from jogos where codigo>0
go
delete  from produto where id>2

select produto.*, jogos.*  from produto inner join jogos on produto.id =  jogos.codigo

insert into produto(nome, descricao, preco)
values('aaa','descricao', 56.90)
go
insert into jogos(distribuidora, genero)
values('distribuidora', 'genero')
