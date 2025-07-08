Feature: Criar novo contato

  Scenario: Usuário cria um novo contato com sucesso
    Given que o aplicativo de contatos está aberto
    When eu toco para criar um novo contato
    And preencho o nome "NomeTeste"
    And preencho o sobrenome "SobrenomeTeste"
    And preencho o telefone "+5511999998888"
    And salvo o contato
    Then o contato deve ser salvo com sucesso