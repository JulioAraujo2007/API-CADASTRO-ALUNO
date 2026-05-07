 # API Cadastro de Alunos

Sistema desenvolvido em Java com comunicação com banco de dados MySQL utilizando JDBC.

O projeto permite:

- Cadastro de alunos
- Edição de alunos
- Exclusão de alunos
- Pesquisa de registros
- Integração com banco MySQL
- Testes unitários com JUnit

---

# Tecnologias Utilizadas

- Java JDK 8+
- Apache NetBeans
- JDBC
- MySQL
- JUnit 4
- Hamcrest

---

# Estrutura do Projeto

```text
src/
 ├── br.com.controle
 ├── br.com.model
 ├── br.com.view
 └── br.com.testes
```

---

# Pré-requisitos

Antes de executar o projeto, instale:

- Java JDK 8 ou superior
- Apache NetBeans
- MySQL Server

---

# Configuração do Banco de Dados

## 1. Abrir o MySQL

Crie o banco:

```sql
CREATE DATABASE cadastro_alunos;
```

---

## 2. Criar a tabela

```sql
CREATE TABLE alunos (
    mat INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    email VARCHAR(100)
);
```

---

# Configuração do Driver MySQL

O projeto utiliza o MySQL Connector/J manualmente.

## Download do Driver

Baixe o driver oficial:

https://dev.mysql.com/downloads/connector/j/

Selecione:

```text
Platform Independent
```

Extraia o arquivo `.zip` e utilize o arquivo:

```text
mysql-connector-j-9.7.0.jar
```

---

# Adicionando o Driver no NetBeans

## Passo a passo

1. Clique com botão direito no projeto
2. Properties
3. Libraries
4. Add JAR/Folder
5. Selecione:

```text
mysql-connector-j-9.7.0.jar
```

---

# Corrigindo erro de biblioteca quebrada

Caso apareça:

```text
Broken reference mysql-connector
```

Faça:

1. Properties
2. Libraries
3. Remova a referência vermelha
4. Adicione novamente o `.jar`

---

# Configuração da Conexão JDBC

Verifique os dados de conexão na classe:

```text
DAO.java
```

Exemplo:

```java
String url = "jdbc:mysql://localhost:3306/cadastro_alunos";
String usuario = "root";
String senha = "123456";
```

---

# Executando o Projeto

No NetBeans:

```text
Run Project
```

ou:

```text
F6
```

---

# Configuração do JUnit

O projeto utiliza JUnit 4.

## Download do JUnit 4

https://junit.org/junit4/

ou:

https://repo1.maven.org/maven2/junit/junit/4.13.2/

Baixe:

```text
junit-4.13.2.jar
```

---

# Download do Hamcrest

O JUnit 4 depende do Hamcrest.

Baixe:

https://repo1.maven.org/maven2/org/hamcrest/hamcrest/2.2/

Arquivo:

```text
hamcrest-2.2.jar
```

---

# Adicionando JUnit no NetBeans

1. Clique direito no projeto
2. Properties
3. Libraries
4. Add JAR/Folder
5. Adicione:

```text
junit-4.13.2.jar
hamcrest-2.2.jar
```

---

# Estrutura de Testes

```text
Test Packages
 └── br.com.testes
        └── AlunoTest.java
```

---

# Executando os Testes

## Executar todos os testes

Clique direito em:

```text
AlunoTest.java
```

Depois:

```text
Test File
```

---

## Executar teste individual

Clique dentro do método com `@Test`.

Depois:

```text
Run Focused Test Method
```

---

# Funcionalidades Testadas

- Cadastro de aluno
- Validação de campos obrigatórios
- Validação de email
- Listagem de alunos
- Atualização de dados
- Exclusão de aluno
- Mensagens de sucesso e erro

---

# Possíveis Erros

## Erro de conexão MySQL

Verifique:

- se o MySQL está rodando
- usuário e senha
- banco criado corretamente

---

## Erro:

```text
org/hamcrest/SelfDescribing
```

Adicione:

```text
hamcrest-2.2.jar
```

---

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

- Migração para Maven
- Migração para Spring Boot
- API REST
- Mockito
- Testes automatizados avançados
- Docker
- Integração contínua

---

# Autor
Grupo-05-Teste-de-software
