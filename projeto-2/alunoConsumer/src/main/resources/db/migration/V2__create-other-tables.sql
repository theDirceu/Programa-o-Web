create table professores(

          id bigint not null auto_increment,
          nome varchar(100) not null,
          formacao varchar(150),
          email varchar(100) not null unique,
          matricula varchar(8) not null unique,
          funcao varchar(100),

          primary key(id)
  );
create table projetos(

        id bigint not null auto_increment,
        nome varchar(100) not null,
        descricao varchar(150),

        primary key(id)
);

create table turmas(

        id bigint not null auto_increment,
        nome varchar(100) not null,
        sala varchar(50),

        primary key(id)
);