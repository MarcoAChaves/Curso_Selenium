Feature: Campo de Treinamento

  Scenario: Preencher campo Nome
    When o usuario preenche o campo Nome com "Teste de escrita"
    Then o campo Nome deve conter o valor "Teste de escrita"

