# Desenvolvendo uma API Profissional e Disponibilizando na Nuvem  
- Nesse projeto eu desenvolvi uma API para controle de um estacionamento de veículos, a qual controla a entrada e saída de veículos. Os dados são cadastrados em um banco de dados relacional e essa API está exposta na nuvem, porém com controle de acesso. 
- Apliquei todas as boas práticas de desenvolvimento de API’s incluindo segurança com Spring Security e acesso a banco de dados PostgreSQL. Realizei testes e relatórios de cobertura de testes. Após finalizar a aplicação, fiz o deploy na cloud do Heroku a fim de disponibilizar nossa API para a Internet.

## Como eu desenvolvi esse projeto?
### Iniciando o projeto
- [Acessei esse site](https://start.spring.io/)
- Project: Maven Project
- Spring Boot: 2.4.0
- Language: Java
- Packaging: Jar
- Dependencies: Spring Web, Spring Boot Dev Tools (faz a aplicação é atualizada no navegador automaticamente)

### Deploy no Heroku
- Criei um novo app
- Region: United States
- Pipeline: stage (production)
- Conectei o Heroku com esse repositório do Github
- Cliquei em `Enable Automatic Deploys`
- Selecionei a branch correta e fiz o deploy
- Atenção: criei um arquivo `system.properties` e adicionei o código: `java.runtime.version=11` para o Heroku conseguir fazer o deploy
