# Desenvolvendo uma API Profissional e Disponibilizando na Nuvem  
- Nesse projeto eu desenvolvi uma API para controle de um estacionamento de veículos, a qual controla a entrada e saída de veículos. Os dados são cadastrados em um banco de dados relacional e essa API está exposta na nuvem, porém com controle de acesso. 
- Apliquei todas as boas práticas de desenvolvimento de API’s incluindo segurança com Spring Security e acesso a banco de dados PostgreSQL. Realizei testes e relatórios de cobertura de testes. Após finalizar a aplicação, fiz o deploy na cloud do Heroku a fim de disponibilizar nossa API para a Internet.

## Comandos
Ver o projeto na nuvem (abra o navegador):
>https://cloud-parking-fmh.herokuapp.com/ 

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

## Conteúdo bônus
### O que é REST?
- REST é uma abreviação para representational state transfer, transferência do estado representacional. 
- Ele é um modelo de arquitetura para sistemas distribuídos.
- Quem o criou foi Roy Fielding, que também criou o HTTP. O REST é um modelo que pode ser usado na arquitetura de sistemas distribuídos.
- REST utiliza o protocolo HTPP que além de utilizar recursos através de URIs, utiliza os verbos HTTP.

### Verbos HTTP
- GET: Para recuperar representação / informação de recursos apenas.
- POST: Para criar novos recursos subordinados. 
- PUT: Para atualizar recursos existentes. 
- DELETE: Para excluir recursos. 
- PATCH: Para fazer uma atualização parcial em um recurso.

### Códigos de retorno HTTP
- 200-299: Resposta de sucesso! <br>
- 200 OK: Esse requisição foi bem sucedida. O significado do sucesso varia de acordo com o método HTTP. <br>
- 201 Create: A requisição foi bem sucedidade e um novo recurso foi criado como resultado. Esta é uma típica resposta enviada após uma requisição POST. <br>
- 204 No Content: Não há conteúdo para enviar para esta solicitação. <br>
- 300-399: Redirecionamentos. <br>
- 400-499: Erros de cliente. <br>
- 400 Bad Request: O servidor não atendeu, pois está com uma sintaxe inválida. <br>
- Not Found: O servidor não pode encontrar o recurso solicitado. <br>
- 500-599: Erros de servidor. <br>
