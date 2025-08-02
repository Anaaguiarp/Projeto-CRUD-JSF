# Projeto CRUD JSF
### Objetivo do projeto
Nosso grupo foi responsável por desenvolver um sistema funcional com foco em gestão de pessoas, utilizando microserviços e front-end JSF. As entidades principais foram Pessoa Física e Pessoa Jurídica, e a ideia era permitir o cadastro, edição, exclusão e listagem dessas pessoas por meio de uma API separada, com integração ao front-end.

### Ferramentas Utilizadas
- Java versão 17 e 24
- SpringBoot
- JSF (PrimeFaces) com Tomcat
- JavaScript
- Docker
- Mysql

### Estrutura do Projeto
```
projeto-sistema/
├── pessoa-fisica-service/           # Microserviço responsável pela Pessoa Física
│   ├── src/
│   │   └── main/
│   │       ├── java/com/microservicos/pessoa_fisica/
│   │       │   ├── PessoaFisicaApplication.java      # Classe principal (Spring Boot)
│   │       │   ├── controller/                       # Endpoints REST
│   │       │   ├── entity/                           # Entidade JPA (tabela Pessoa Física)
│   │       │   ├── model/                            # DTOs e VOs (dados de entrada/saída)
│   │       │   ├── repository/                       # Interfaces JPA para acesso ao banco
│   │       │   └── service/                          # Regras de negócio
│   │       └── resources/application.properties      # Configurações do microserviço
│   └── Dockerfile                                    # Container do serviço
│
├── pessoa-juridica-service/         # Microserviço responsável pela Pessoa Jurídica
│   ├── src/
│   │   └── main/
│   │       ├── java/com/microservicos/pessoa_juridica/
│   │       │   ├── PessoaJuridicaApplication.java    # Classe principal (Spring Boot)
│   │       │   ├── controller/                       # Endpoints REST
│   │       │   ├── entity/                           # Entidade JPA (tabela Pessoa Jurídica)
│   │       │   ├── model/                            # DTOs e VOs (dados de entrada/saída)
│   │       │   ├── repository/                       # Interfaces JPA para acesso ao banco
│   │       │   └── service/                          # Regras de negócio
│   │       └── resources/application.properties      # Configurações do microserviço
│   └── Dockerfile                                    # Container do serviço
│
├── relatorio-service/              # Microserviço para gerar relatórios com dados combinados
│   ├── src/
│   │   └── main/
│   │       ├── java/com/microservicos/relatorio/
│   │       │   ├── RelatorioApplication.java         # Classe principal
│   │       │   ├── controller/                       # Endpoints REST para relatórios
│   │       │   ├── dto/                              # Dados de resposta dos relatórios
│   │       │   └── service/                          # Lógica de geração de relatórios
│   │       └── resources/application.properties
│   └── Dockerfile
│
└── FrontEnd/                        # Interface do usuário (JSF + PrimeFaces)
    ├── src/
    │   └── main/
    │       ├── java/com/projeto/
    │       │   ├── bean/                             # Managed Beans (JSF) com lógica das páginas
    │       │   └── model/                            # Classes modelo/DTO usadas no front
    │       └── webapp/
    │           ├── home.xhtml                        # Página home do sistema
    │           ├── usuario/                          # Telas JSF de CRUD (PF e PJ)
    │           ├── resources/
    │           │   ├── css/                          # Estilos visuais
    │           │   └── js/                           # Scripts auxiliares (validações, api-correios)
    │           └── WEB-INF/
    │               ├── web.xml                       # Configuração JSF
    │               └── templates/template.xhtml      # Template visual comum às páginas
    └── Dockerfile
```
### Créditos
É válido ressaltar nosso agradecimento especial a nosso gestor Nelson Konishi que nos prestou todo apoio e nos permitiu explorar os conhecimentos adquiridos, além de nos guiar muito bem, realmente se comprometendo com nosso aprendizado. Também os créditos ao Felipe Henrique que nos ajudou muito na base de conhecimento em JSF e microserviços, se disponibilizando também para nos auxiliar no que fosse possível. Nosso muito obrigada!
