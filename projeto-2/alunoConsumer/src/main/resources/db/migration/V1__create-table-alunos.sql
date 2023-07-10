create table alunos(

        id bigint not null auto_increment,
        nome varchar(100) not null,
        email varchar(100) not null unique,
        matricula varchar(8) not null unique,
        funcao varchar(100) not null,

        primary key(id)
);