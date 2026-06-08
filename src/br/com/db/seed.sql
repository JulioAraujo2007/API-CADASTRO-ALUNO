```sql
USE cadastro;

-- ============================================================
-- PROFESSORES
-- ============================================================
INSERT INTO PROFESSOR (nome, email, materia) VALUES
('Ana Paula Ferreira', 'ana@escola.edu', 'Banco de Dados'),
('Carlos Lima', 'carlos@escola.edu', 'Programa??o Java'),
('Mariana Souza', 'mariana@escola.edu', 'Matem?tica');

-- ============================================================
-- ENDERE?OS DOS PROFESSORES
-- ============================================================
INSERT INTO ENDERECO (cidade, bairro, numero, rua, ra) VALUES
('S?o Paulo', 'Centro', 100, 'Rua das Flores', 1),
('Campinas', 'Jardim A', 250, 'Av. Brasil', 2),
('Bras?lia', 'Asa Norte', 501, 'SQN 315', 3);

-- ============================================================
-- ALUNOS
-- ============================================================
INSERT INTO ALUNOS (nome, idade, email) VALUES
('Jo?o Pedro', 20, 'joao@aluno.edu'),
('Fernanda Costa', 19, 'fernanda@aluno.edu'),
('Lucas Mendes', 21, 'lucas@aluno.edu'),
('Beatriz Lima', 18, 'beatriz@aluno.edu');

-- ============================================================
-- DISCIPLINAS
-- ============================================================
INSERT INTO DISCIPLINA (nome, codigo, carga_horaria) VALUES
('Banco de Dados', 'BD101', 60),
('Programa??o Java', 'PJ102', 80),
('Matem?tica', 'MT201', 60);

-- ============================================================
-- TURMAS
-- ============================================================
INSERT INTO TURMA (ra, id_disciplina, semestre, vagas) VALUES
(1, 1, '2024/1', 40),
(2, 2, '2024/1', 35),
(3, 3, '2024/1', 50);

-- ============================================================
-- MATR?CULAS
-- ============================================================
INSERT INTO MATRICULA
(mat, id_turma, data_matricula, nota_final, situacao)
VALUES
(1, 1, '2024-02-05', 8.50, 'Aprovado'),
(1, 3, '2024-02-05', 5.00, 'Reprovado'),
(2, 1, '2024-02-04', 9.00, 'Aprovado'),
(3, 2, '2024-02-03', 7.50, 'Aprovado'),
(4, 1, '2024-02-02', NULL, 'Cursando'),
(4, 2, '2024-02-01', NULL, 'Cursando');
```
