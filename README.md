# passw0rd-validator-service

**passw0rd-validator-service** é um micro serviço validador de senha seguindo definições parametrizadas para uma senha válida.

O serviço foi desenvolvido em Kotlin e com [Vert.x-Web](https://vertx.io/docs/vertx-web/java/) para subir um servidor Web.

O serviço expõe um **Endpoint:** ```POST http://localhost:9000/validate``` que será utilizado para validar a senha.

## Visão geral

É um serviço RESTful simples no qual validará uma senha seguindo as definições:
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto
> **_Nota:_** Espaços em branco não devem ser considerados como caracteres válidos.

Além dessas definições acima, foi incluído outra definição para número máximo de caracteres na `camada de aplicação`. 
> Considerei importante limitar também o número máximo de caracteres no corpo da mensagem (payload) limitando o tamanho para o envio no serviço.

Na solução para validação da senha, separei cada definição acima em uma classe que chamo de **validador**.

Esses **validadores** estão na `camada de domínio` no pacote ```validators``` na estrutura abaixo:

```shell
├───application
│   ├───configs
│   ├───extensions
│   ├───modules
│   └───web
│       ├───constants
│       ├───controllers
│       ├───handlers
│       ├───requests
│       ├───responses
│       ├───routes
│       └───validators
├───domain
│   ├───exceptions
│   ├───handlers
│   ├───password
│   ├───services
│   └───validators
└───resource
```

Esses **validadores** utlizam [variáveis de ambiente](#definir-variveis-de-ambiente-obrigatrias) que possibilita redefinir para cada **validador** sua regra de negócio.

O código é auto-explicativo e se encaixa na arquitetura de micro serviço. A requisição da validação da senha é enviada para `camada de aplicação` que possui uma parte da validação para garantir dados válidos.
Ela executa seu código e depois chama na `camada de domínio` a classe de serviço para executar toda parte da lógica de negócios nos **validadores**.

## Requerimentos

* [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Kotlin 1.4.10](https://github.com/JetBrains/kotlin/blob/master/ChangeLog.md#1410)

### Configuração

```git clone https://github.com/leandrochp/passw0rd-validator-service.git```

### Definir variáveis de ambiente obrigatórias
```
SERVER_PORT=9000
SERVICE_NAME=passw0rd-validator-service

# Validators
VALIDATOR_PASSWORD_MIN_LENGTH=9
VALIDATOR_PASSWORD_MAX_LENGTH=15
VALIDATOR_PASSWORD_MIN_LOWERCASE=1
VALIDATOR_PASSWORD_MIN_UPPERCASE=1
VALIDATOR_PASSWORD_MIN_DIGITS=1
VALIDATOR_PASSWORD_MIN_SPECIAL=1
VALIDATOR_PASSWORD_VALID_SPECIAL_CHARS=!@#$%^&*()-+
VALIDATOR_PASSWORD_MIN_REPEAT=0
```
> dica: para configurar [dev.env](dev.env) por exemplo, no [IntelliJ](https://www.jetbrains.com/pt-br/idea/) você pode usar o plugin [Envfile](https://plugins.jetbrains.com/plugin/7861-envfile) para ajudar nas configurações na IDE.

### Buildar
```bash
./gradlew clean build
```

### Testar
```bash
./gradlew test
```

### Rodar
```bash
./gradlew run
```

## Testando
Para testar o serviço, vamos usar a ferramenta [POSTMAN](https://www.getpostman.com/) ou comando cURL.

Certifique-se que o serviço está em execução. A saída no console deve ser algo como isso:

```passw0rd-validator-service started on port 9000```

### Validando uma senha
`Abra o POSTMAN`

* Definir tipo de solicitação: POST
* Definir URL: http://localhost:9000/validate
* Definir cabeçalho da solicitação: Content-Type:application/json
* Defina o corpo como: {"password": "AbTp9!fok"}
* Clique em "Enviar"

Na resposta, obteremos uma propriedade se a senha é válida ou não.

`Comando cURL`

```shell
curl -X POST -d '{"password": "AbTp9!fok"}' 'http://localhost:9000/validate'
```

> Nota: Sinta-se livre em criar outros cenários para validação da sua senha.

