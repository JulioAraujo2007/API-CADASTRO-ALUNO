create database CADASTRO;
use CADASTRO;

create table ALUNOS (
MAT INT auto_increment primary key,
NOME VARCHAR(100) not null,
IDADE INT not null,
EMAIL VARCHAR(100) not null unique,
constraint CHK_ALUNO_IDADE check (IDADE between 5 and 100)
);

create table PROFESSOR (
RA INT auto_increment primary key,
NOME VARCHAR(100) not null,
EMAIL VARCHAR(100) not null unique,
MATERIA VARCHAR(100) not NULL
);

create table ENDERECO (
ID_ENDERECO INT auto_increment primary key,
CIDADE VARCHAR(100) not null,
BAIRRO VARCHAR(100) not null,
NUMERO INT  not null,
RUA VARCHAR(150) not null,
RA INT not null,
foreign KEY(RA) references PROFESSOR(RA)
on update cascade on delete cascade,
constraint CHK_NUMERO check (NUMERO > 0)
);


create table DISCIPLINA (
ID_DISCIPLINA INT auto_increment primary key,
NOME VARCHAR(100) not null,
CODIGO VARCHAR(100) not null UNIQUE,
CARGA_ORARIA INT not null default 60,
constraint CHK_CARGA check (CARGA_ORARIA between 20 and 120)
);

create table TURMA (
ID_TURMA INT auto_increment primary key,
RA INT not null,
ID_DISCIPLINA INT not null,
SEMESTRE CHAR(6) not null,
VAGAS  INT not null default 40,
unique (RA,ID_DISCIPLINA,SEMESTRE),
foreign  KEY(RA) references PROFESSOR(RA) on update cascade on delete restrict,
foreign key (ID_DISCIPLINA) references DISCIPLINA(ID_DISCIPLINA) on update cascade on delete restrict,
constraint CHK_VAGAS check (VAGAS between 5 and 100)
);

create table MATRICULA (
ID_MATRICULA INT  auto_increment primary key,
MAT INT not null,
ID_TURMA INT not null,
DATA_MATRICULA DATE not null,
NOTA_FINAL DECIMAL (4,2) null,
SITUACAO ENUM ('Cursando','Aprovado','Reprovado','Trancado') not null default 'Cursando',
unique (MAT, ID_TURMA),
foreign key (MAT) references ALUNOS(MAT) on update cascade on delete restrict,
foreign KEY(ID_TURMA) references TURMA(ID_TURMA) on update cascade on delete restrict,
constraint CHK_NOTA check (NOTA_FINAL IS null or NOTA_FINAL between 0 and 100)
);

-- Pra ver todos os alunos matriculados
CREATE VIEW vw_alunos_matriculados AS
SELECT
a.mat, a.nome AS aluno, a.idade,
d.nome AS disciplina, d.codigo,
p.nome AS professor, p.materia,
t.semestre, m.nota_final, m.situacao
FROM matricula m
JOIN alunos a ON a.mat = m.mat
JOIN turma t ON t.id_turma = m.id_turma
JOIN disciplina d ON d.id_disciplina = t.id_disciplina
JOIN PROFESSOR p ON p.ra = t.ra;
 
-- Professores com os dados do enderen?o completo
CREATE VIEW vw_professores_completo AS
SELECT
p.ra, p.nome, p.email, p.materia,
e.rua, e.numero, e.bairro, e.cidade
FROM PROFESSOR p
LEFT JOIN ENDERECO e ON e.ra = p.ra;