create database dbfestasinfantis;
use dbfestasinfantis;

create table cliente (
  idCliente integer not null auto_increment,
  nomeCliente varchar(100) not null,
  telefone varchar(25),
  email varchar(255),
  cpf varchar(11),
  constraint cliente_pk primary key (idCliente)
);

create table funcionario (
  idFuncionario integer not null auto_increment,
  nomeFuncionario varchar(100) not null,
  salarioFuncionario float not null,
  idadeFuncionario integer,
  constraint funcionario_pk primary key (idFuncionario)
);

create table tema (
  idTema integer not null auto_increment,
  nomeTema varchar(50) not null,
  corPrincipal varchar(25) not null,
  constraint tema_pk primary key (idTema)
);

create table itemtema (
  idItem integer not null auto_increment,
  descricaoItem varchar(100) not null,
  idTema integer not null,
  constraint itemtema_pk primary key (idItem),
  constraint itemtem_tema_fk foreign key (idTema) references tema (idTema) on delete cascade
);

create table festa (
  idFesta integer not null auto_increment,
  localFesta varchar(255) not null,
  dataFesta datetime not null,
  horaFesta datetime not null,
  valorFesta float not null,
  observacao varchar(255),
  idTema integer not null,
  idFuncionario integer not null,
  idCliente integer not null,
  constraint festa_pk primary key (idFesta),
  constraint festa_tema_fk foreign key (idTema) references tema (idTema),
  constraint festa_funcionario_fk foreign key (idFuncionario) references funcionario (idFuncionario),
  constraint festa_cliente_fk foreign key (idCliente) references cliente (idCliente)
);
  
