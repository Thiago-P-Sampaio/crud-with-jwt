## Crud com autenticação Jason Web Token
-- --
#### CRUD:
refere-se a um conjunto de operações básicas para manipular dados de um sistema. É 
um acrônimo para as palavras: Create, Read, Update e Delete.
Ou seja, Criar, Ler, Atualizar e Deletar dados 
-- --
#### JWT ou Jason Web Token:
Consiste em um sistema de autenticação com base em "TOKENS", para autorizar o acesso
de usuários e garantir a proteção dos dados. Assim as operações variam de acordo com autorização "ROLE" de cada usuário
-- --
### Aplicação:

Inserção e manipulação de dados que envolve o gerenciamento de produtos
````JSON
{
  "nameProduct": "nome",
  "priceProduct": 1234
}
````

Endereço:<br>
`` http://localhost:8080/`` <br>
<br>
### Autenticação
- Endpoint - *Registrar*
  `` http://localhost:8080/auth/register``

- Body Json
````JSON
{
  "login": "nome",
  "password": 1234, 
  "role": "ADMIN" -> ou USER
}
````

Endpoint - *Autenticar* & Receber token
`` http://localhost:8080/auth/login``
````JSON
{
  "login": "nome",
  "password": 1234 

}
````



-- --

## GET
`` http://localhost:8080/product``
<br>
*AUTH* <br> - Token: <br> - Prefix: Bearer
````JSON
{
  "idProduct": "5c304187-251f-4e4a-b437-be13facc2969",
  "nameProduct": "Camisa Lacoste",
  "priceProduct": 203.0
}, ...
````
-- --
## POST
`` http://localhost:8080/product``
<br>
*AUTH* <br> - Token: <br> - Prefix: Bearer
-- --
## PUT
`` http://localhost:8080/idProduct``
<br>
*AUTH* <br> - Token: <br> - Prefix: Bearer
-- --
## DELETE
`` http://localhost:8080/idProduct``
<br>
*AUTH* <br> - Token: <br> - Prefix: Bearer
--- 