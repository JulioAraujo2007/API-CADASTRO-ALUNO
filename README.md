# API-CADASTRO-ALUNO
JAVA com comunicação com o banco de dados MYSQL.

🚀 Como executar a API de Cadastro de Alunos

Este guia explica como configurar e executar o projeto localmente.

📋 Pré-requisitos

Antes de começar, você precisa ter instalado:

☕ Java (JDK 8 ou superior)

🛠️ Maven ou Gradle (dependendo do projeto)

🛢️ MySQL Server

🧪 Postman ou Insomnia (opcional, para testar a API)

📥 Clonando o repositório:
```Bash
git clone https://github.com/JulioAraujo2007/API-CADASTRO-ALUNO.git
cd API-CADASTRO-ALUNO
```

🛢️ Configuração do banco de dados

Abra o MySQL

Crie o banco de dados:
```SQL
CREATE DATABASE cadastro_alunos;
```

Crie a tabela:
```SQL
CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    idade INT
);
```

⚙️ Configuração da aplicação

No arquivo de configuração (geralmente application.properties ou application.yml), ajuste os dados do seu MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cadastro_alunos
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

▶️ Executando o projeto

Se estiver usando Maven:
```Bash
mvn spring-boot:run
```

Ou compile e execute:
```Bash
mvn clean install
java -jar target/*.jar
```

🌐 Acessando a API

Após iniciar, a API estará disponível em:
```
http://localhost:8080
```

⚠️ Possíveis erros

❌ Erro de conexão com banco
→ Verifique usuário, senha e se o MySQL está rodando

❌ Porta 8080 em uso
→ Altere no application.properties:
```properties
server.port=8081
```

✅ Pronto!
