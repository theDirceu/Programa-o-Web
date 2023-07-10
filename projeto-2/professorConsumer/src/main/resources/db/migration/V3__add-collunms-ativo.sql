alter table alunos add ativo tinyint;
update alunos set ativo = 1;
alter table projetos add ativo tinyint not null;
update projetos set ativo = 1;
alter table turmas add ativo tinyint not null;
update turmas set ativo = 1;
alter table professores add ativo tinyint not null;
update professores set ativo = 1;