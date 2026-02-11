@campo_treinamento
Feature: Campo de Treinamento

  @smoke @regression
  Scenario: Preencher campo Nome
    When o usuario preenche o campo Nome com "Teste de escrita"
    Then o campo Nome deve conter o valor "Teste de escrita"

  @regression
  Scenario: Preencher campo Sugestoes
    When o usuario preenche o campo Sugestoes com "Texto livre"
    Then o campo Sugestoes deve conter o valor "Texto livre"

  Scenario: Selecionar sexo
    When o usuario seleciona o sexo "Masculino"
    Then o sexo "Masculino" deve estar selecionado

  @regression
  Scenario: Comida favorita
    When o usuario seleciona a comida favorita "Carne"
    Then a comida favorita "Carne" deve estar selecionado

  Scenario: Selecionar escolaridade no combo
    When seleciono a escolaridade "Superior"
    Then a escolaridade selecionada deve ser "Superior"


