# language: pt

Funcionalidade: Login

@login1 @smokeTest 
Cenário: Realizar login com sucesso
Dado que estou na tela de login
Quando realizar login na aplicacao
Então visualizo a home do site

@login 
Cenário: Realizar login com usuario invalido
Dado que estou na tela de login
Quando realizar login com usuario invalido
Então vejo mensagem de usuario ou senha invalido

@login
Cenário: Realizar login com senha invalida
Dado que estou na tela de login
Quando realizar login com senha invalida
Então vejo mensagem de usuario ou senha invalido

@manual
Cenário: Realizar login sem acesso a internet
Dado que estou na tela de login do usuario
E estou sem conexão com a internets
Quando realizar login na aplicacao sem internet
Então nao consigo realizar login na aplicacao

@manual 
Cenário: Acessar esqueceu a senha
Dado que estou na tela de login
Quando tocar em esqueceu a senha
Então vejo a tela de esqueci a senha

@manual 
Cenário: Lembrar a senha
Dado que estou na tela login de esqueci a senha
Quando tocar em lembrou
Então volto para tela de login

@manual  
Cenário: Preencher campo esqueci a senha
Dado que estou na tela login de esqueci a senha
Quando envio o email para prosseguir
Então retorno para a tela de login