# API Cadastro de Alunos

Sistema acadêmico desenvolvido em **Java** com integração ao banco de dados **MySQL** utilizando **JDBC**.

O projeto foi desenvolvido para gerenciamento acadêmico, permitindo o controle de:

* Cadastro de alunos
* Cadastro de professores
* Cadastro de disciplinas
* Criação de turmas
* Matrículas de alunos
* Controle de notas e situação acadêmica
* Relacionamentos entre entidades
* Consultas utilizando **Views SQL**
* Integração com banco MySQL
* Testes unitários com **JUnit**

---

# Tecnologias Utilizadas

* Java JDK 8+
* Apache NetBeans
* JDBC
* MySQL
* SQL
* JUnit 4
* Hamcrest

---

# Estrutura do Projeto

```text
API-CADASTRO-ALUNO/
│── src/
│   ├── br.com.controle
│   ├── br.com.model
│   ├── br.com.view
│   └── br.com.testes
│
│── db/
│   ├── schema.sql
│   └── seed.sql
│
│── docs/
│
│── README.md
```

---

# Funcionalidades do Sistema

## Alunos

* Cadastro de alunos
* Edição de dados
* Exclusão de registros
* Pesquisa de alunos

## Professores

* Cadastro de professores
* Associação com disciplinas
* Relacionamento com endereço

## Disciplinas

* Cadastro de disciplinas
* Código único
* Controle de carga horária

## Turmas

* Associação entre professor e disciplina
* Controle de semestre
* Controle de vagas

## Matrículas

* Relacionamento entre aluno e turma
* Controle de situação:

  * Cursando
  * Aprovado
  * Reprovado
  * Trancado
* Registro de nota final
* Data de matrícula

---

# Banco de Dados

O sistema utiliza o banco **MySQL** com modelagem relacional completa.

### Entidades principais

* ALUNOS
* PROFESSOR
* ENDERECO
* DISCIPLINA
* TURMA
* MATRICULA

### Recursos utilizados

* Primary Key (PK)
* Foreign Key (FK)
* Constraints (`CHECK`, `UNIQUE`, `DEFAULT`)
* Relacionamentos
* `ENUM`
* `AUTO_INCREMENT`
* `VIEWS`

---

# Views Implementadas

### `vw_alunos_matriculados`

Consulta completa de alunos matriculados com:

* aluno
* disciplina
* professor
* semestre
* nota final
* situação acadêmica

### `vw_professores_completo`

Consulta de professores com endereço completo.

### `vw_vagas_turma`

Consulta de:

* vagas totais
* alunos matriculados
* vagas disponíveis por turma

---

# Pré-requisitos

Antes de executar o projeto, instale:

* Java JDK 8 ou superior
* Apache NetBeans
* MySQL Server

---

# Configuração do Banco de Dados

## 1. Criar o banco

Abra o MySQL e execute:

```sql
CREATE DATABASE cadastro;
USE cadastro;
```

## 2. Executar os scripts

Na pasta:

```text
db/
```

Execute:

### Estrutura do banco

```sql
schema.sql
```

### Dados de teste

```sql
seed.sql
```

Ou execute diretamente:

```sql
source schema.sql;
source seed.sql;
```

---

# Configuração do Driver MySQL

O projeto utiliza o **MySQL Connector/J**.

## Download do Driver

Baixe o driver oficial:

https://dev.mysql.com/downloads/connector/j/

Selecione:

```text
Platform Independent
```

Extraia o `.zip` e utilize o arquivo:

```text
mysql-connector-j-9.7.0.jar
```

---

# Adicionando o Driver no NetBeans

1. Clique com botão direito no projeto
2. **Properties**
3. **Libraries**
4. **Add JAR/Folder**
5. Selecione:

```text
mysql-connector-j-9.7.0.jar
```

---

# Configuração da Conexão JDBC

Verifique os dados de conexão na classe:

```text
DAO.java
```

Exemplo:

```java
String url = "jdbc:mysql://localhost:3306/cadastro";
String usuario = "root";
String senha = "123456";
```

---

# Executando o Projeto

No NetBeans:

```text
Run Project
```

ou pressione:

```text
F6
```

---

# Configuração do JUnit

O projeto utiliza **JUnit 4**.

## Download do JUnit

https://repo1.maven.org/maven2/junit/junit/4.13.2/

Arquivo:

```text
junit-4.13.2.jar
```

## Download do Hamcrest

https://repo1.maven.org/maven2/org/hamcrest/hamcrest/2.2/

Arquivo:

```text
hamcrest-2.2.jar
```

---

# Executando os Testes

### Executar todos os testes

Clique direito em:

```text
AlunoTest.java
```

Depois:

```text
Test File
```

### Executar teste individual

Clique dentro do método `@Test` e execute:

```text
Run Focused Test Method
```

---

# Funcionalidades Testadas

* Cadastro de alunos
* Atualização de dados
* Exclusão de registros
* Validação de campos obrigatórios
* Integração com banco MySQL
* Validação de regras do sistema

---

# Possíveis Erros

## Erro de conexão MySQL

Verifique:

* se o MySQL está rodando
* usuário e senha
* porta do MySQL
* banco criado corretamente

## Erro:

```text
org/hamcrest/SelfDescribing
```

Adicione:

```text
hamcrest-2.2.jar
```

## Erro:

```text
package org.junit does not exist
```

Adicione:

```text
junit-4.13.2.jar
```

---

# Melhorias Futuras

* Migração para Maven
* API REST
* Spring Boot
* Docker
* Mockito
* Testes automatizados avançados
* Integração contínua (CI/CD)

---

# Autor

**Banco-de-Dados**
