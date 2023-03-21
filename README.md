# password-validator-service

**password-validator-service** é um microsserviço validador de senha desenvolvido em Kotlin e Spring Boot.

O serviço expõe um **endpoint:** ```POST /validate``` que será utilizado para validar a senha.

Essa API foi desenvolvida com:
- [Kotlin (JDK 8)](https://kotlinlang.org/)
- [Spring Boot](https://spring.io/)
- [OpenAPI 3](https://swagger.io/docs/specification/about/)

### Visão geral

É um microsserviço simples no qual validará uma senha seguindo as definições:
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto
> **_Nota:_** Espaços em branco não devem ser considerados como caracteres válidos.

### Como executar
Ambiente Linux/macOS:
```bash
./gradlew bootRun
```
Ambiente Windows:
```cmd
gradlew bootRun
```
Para verificar se o serviço está pronto, execute o seguinte comando no terminal:

Ambiente Linux/macOS:
```bash
curl -X GET 'http://localhost:7000/health-check'
```
Ambiente Windows:
```cmd
curl -X GET "http://localhost:7000/health-check"
```
### Documentação da API (Swagger)

* URL: [http://localhost:7000/docs](http://localhost:7000/docs)

### Validando uma senha
[`Abra o Postman`](https://www.postman.com/)

* Definir tipo de solicitação: POST
* Definir URL: http://localhost:7000/validate
* Definir cabeçalho da solicitação: Content-Type:application/json
* Defina o corpo como: {"password": "AbTp9!fok"}
* Clique em "Enviar"

Na resposta, obteremos uma propriedade `valid` se a senha é válida ou não.

`Comando curl`

Ambiente Linux/macOS:
```bash
curl -X POST 'http://localhost:7000/validate' -H 'Content-Type: application/json' -d '{"password": "AbTp9!fok"}'
```
Ambiente Windows:
```cmd
curl -X POST "http://localhost:7000/validate" -H "Content-Type: application/json" -d "{\"password\": \"AbTp9!fok\"}"
```
