# 🧪 Projeto de Automação – Campo de Treinamento (Selenium + Cucumber)

Este projeto tem como objetivo automatizar testes funcionais do **Campo de Treinamento**, utilizando **Java**, *
*Selenium WebDriver**, **Cucumber (BDD)** e **JUnit**, seguindo boas práticas de automação e organização de código.

Além da automação dos cenários, o projeto gera **evidências em PDF com screenshots**, permitindo fácil análise dos
resultados dos testes.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Selenium WebDriver 4**
- **Cucumber 7 (BDD)**
- **JUnit 4**
- **Maven**
- **iText PDF** (geração de evidências)
- **IntelliJ IDEA**

---

## 📁 Estrutura do Projeto

src
├── main
│ └── java
│ └── marco.chaves
│ ├── core # BasePage, DriverFactory, DSL
│ ├── page # Page Objects
│ └── steps # Step Definitions
│
└── test
└── java
└── marco.chaves
├── hooks # Hooks do Cucumber
├── listeners # Listener para capturar Steps
└── runner # Runner do Cucumber

src/test/resources
└── features
└── campo_treinamento.feature

reports
├── pdf # Evidências em PDF
└── screenshots # Screenshots temporários (apagados após uso)


---

## 🧩 Padrões Utilizados

- **Page Object Model (POM)**
- **BDD (Behavior Driven Development)**
- **Separação clara de responsabilidades**
- **Hooks para setup/teardown**
- **Listener para capturar texto real das Steps**
- **Evidências automáticas por cenário**

---

## 🧪 Cenários Automatizados

Atualmente o projeto cobre os seguintes cenários:

- Preencher campo **Nome**
- Preencher campo **Sugestões**
- Selecionar **Sexo** (Radio Button)
- Selecionar **Comida Favorita** (Checkbox)
- Selecionar **Escolaridade** (Combo / Select)
- Validação dos valores selecionados
- Geração automática de evidência em PDF

---

## 🏷️ Uso de Tags

Os cenários utilizam **tags** para facilitar a execução seletiva:

Exemplo:

```gherkin
@smoke
Scenario: Preencher campo Nome

Tags disponíveis:

@smoke – Testes críticos

@regression – Testes de regressão

@campo_treinamento – Agrupamento por funcionalidade

▶️ Executando os Testes
Via IntelliJ

Execute a classe RunCucumberTest

Ou clique com o botão direito no arquivo .feature

Executar por Tag

No Runner:

tags = "@smoke"


Ou via Maven:

mvn test -Dcucumber.filter.tags="@smoke"

📄 Evidências (PDF)

Ao final de cada cenário:

Um PDF é gerado automaticamente

Contém:

Nome do cenário

Data e hora da execução

Lista de Steps executadas

Status (PASS / FAIL) com cores

Screenshot do cenário

📌 Os screenshots não ficam salvos em disco, sendo apagados após a geração do PDF, evitando consumo excessivo de espaço.

📌 Observações Importantes

O navegador é inicializado automaticamente antes de cada cenário

O driver é encerrado corretamente ao final da execução

O projeto está preparado para fácil expansão de novos cenários

Estrutura pronta para integração com CI/CD futuramente

👨‍💻 Autor

Marco Chaves
Projeto desenvolvido com foco em aprendizado, boas práticas e qualidade de automação de testes.