# language: pt
Funcionalidade: Register_Person

 
  Cenário: Acessar a tela de cadastro de conta
    Dado que estou na tela Principal do sistema
    Quando tocar em registrar uma conta
    Então vejo a tela de cadastro de conta

  @Register @smokeTest  @Register1
  Cenário: Registrar conta com sucesso
    Dado que estou na tela de cadastro de conta
    Quando fornecer os dados validos
    Então vejo Conta cadastrado com sucesso
    

    Cenário: Não Registrar conta com sucesso
    Dado que estou na tela de cadastro de conta
    Quando Não fornecer os dados validos
    Então Então vejo mensagem de usuario erro
    