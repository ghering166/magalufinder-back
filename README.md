# Informações de configuração

## Requisitos obrigatórios
Desenvolvimento realizado com Java, framework Spring Boot e banco de dados MYSQL.<br/> **Java        (v1.8)**<br/>**Spring Boot  (v1.5.3.RELEASE)**<br/>**Mysql        (v5.1.35)**

## Dependências (jars)
O projeto faz uso do **maven** para gerenciamento das dependências, o arquivo **pom.xml** possui todas
as dependências utilizadas com suas devidas versões.

## Configurações do Spring JPA
O BD utilizado foi **MYSQL**, crie o banco e configure os dados de acesso no arquivo **application.properties**. Uma 
cópia do mesmo encontra-se na pasta **resources/bd/magalufinder.sql**

## Executando o Projeto
Execute a classe **Boot.java**, por padrão será iniciado na porta **http://localhost:8080**, entretanto, confira no 
console a porta executada, uma mensagem como **Tomcat started on port(s): 8080 (http)** deve ser exibida..

## Acessando o Swagger
Após iniciar o projeto basta acessar a url **http://localhost:8080/swagger-ui.html#/**.



  	

