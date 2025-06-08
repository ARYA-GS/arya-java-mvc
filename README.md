# Arya MVC - Painel de Gestão Operacional

# Aluno	RM

#### Keven Ike Pereira da Silva	553215

#### Vitor Cruz dos Santos  553621

#### José Ribeiro dos Santos Neto 553844


Link do Video [video](https://youtu.be/8YhITEJctlA)

## Visão Geral
O Arya MVC é uma aplicação web completa que serve como a interface de usuário para a plataforma de gerenciamento de operações Arya. Construído com Spring Boot e o padrão MVC, este painel fornece uma experiência rica e interativa para operadores, permitindo o gerenciamento de recursos, a visualização de dados em tempo real e a interação com serviços de inteligência artificial.

A aplicação atua como um front-end robusto que se comunica com uma API de back-end central para realizar todas as suas operações, garantindo uma separação clara de responsabilidades.

## Funcionalidades Principais

### Autenticação de Usuário Completa:
- Página de login segura.
- Cadastro de novos usuários.
- Fluxo de recuperação de senha via token.
- Logout e gerenciamento de sessão.

### Dashboard Interativo:
- Mapa de Riscos em Tempo Real: Visualização de ocorrências ativas em um mapa dinâmico (Leaflet.js), com marcadores personalizados para diferentes tipos de risco.
- Gráficos Analíticos: Gráficos (Chart.js) que exibem um resumo de ocorrências, a distribuição de drones por modelo e a localização de hubs por cidade.
- Assistente de IA: Um chatbot integrado que permite aos usuários fazer perguntas em linguagem natural para obter insights sobre os dados operacionais.

### Gerenciamento de Drones:
- Interface CRUD (Criar, Ler, Atualizar, Deletar) completa para drones.
- Formulários para cadastrar e editar drones, associando-os a um hub operacional.
- Listagem e busca de todos os drones no sistema.

### Gerenciamento de Hubs Operacionais:
- Interface CRUD completa para hubs.
- Formulários para cadastrar e editar hubs, incluindo seus detalhes de endereço.
- Listagem de todos os hubs com informações de status e localização.

### Internacionalização (i18n):
- Suporte a múltiplos idiomas com detecção automática baseada na localização do IP do usuário (via GeoIP2) e nas preferências do navegador.

## Tecnologias Utilizadas
Este projeto foi construído utilizando um conjunto de tecnologias modernas e eficientes:

| Categoria   | Tecnologia                                                |
|------------|-----------------------------------------------------------|
| Backend    | Java 21, Spring Boot, Spring Web MVC, Spring Cloud OpenFeign |
| Frontend   | Thymeleaf, HTML5, CSS3, JavaScript                        |
| Bibliotecas| Lombok, GeoIP2, Leaflet.js, Chart.js                      |
| Construção | Apache Maven                                              |

## Arquitetura
A aplicação segue uma arquitetura MVC clara e desacoplada.

- **Comunicação com o Back-end**: A comunicação com a API central (`api.central.url`) é realizada através de clientes REST declarativos usando Spring Cloud OpenFeign.
- **Autenticação**: O sistema utiliza autenticação baseada em token. Após o login, um token é armazenado na sessão do usuário (`UsuarioSession`) e um `RequestInterceptor` do Feign o anexa automaticamente ao cabeçalho Authorization de todas as solicitações subsequentes.

## Como Executar o Projeto

Para executar este projeto corretamente, é necessário rodá-lo em conjunto com a aplicação arya-java.

🔗 Link do GitHub: https://github.com/ARYA-GS/arya-java

### Pré-requisitos
- Java Development Kit (JDK) 21 ou superior.
- Apache Maven 3.9 ou superior.
- API Central Arya rodando em `http://localhost:8080`.

### Configuração
Edite o arquivo `src/main/resources/application.yml`:

```yaml
server:
  port: 8081

api:
  central:
    url: http://localhost:8080
```

### Execução

```bash
git clone <URL_DO_SEU_REPOSITORIO>
cd arya-java-mvc
./mvnw spring-boot:run
```

Acesse a aplicação em: [http://localhost:8081](http://localhost:8081)

## Estrutura do Projeto

```
.
└── src
    ├── main
    │   ├── java/com/arya/api/mvc
    │   │   ├── client/      # Clientes Feign para a API de back-end
    │   │   ├── config/      # Configurações do Spring (Feign, i18n)
    │   │   ├── controller/  # Controladores Spring MVC
    │   │   ├── dto/         # Data Transfer Objects (Request/Response)
    │   │   ├── service/     # Lógica de negócio da aplicação
    │   │   └── session/     # Beans com escopo de sessão
    │   └── resources
    │       ├── geolite2/        # Base de dados para GeoIP
    │       ├── static/          # Arquivos estáticos (CSS, JS, imagens)
    │       ├── templates/       # Templates Thymeleaf (HTML)
    │       └── application.yml  # Arquivo de configuração principal
    └── test/                    # Testes da aplicação
```
