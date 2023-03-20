package teste.de.sistema.integrationtests.steps;

import teste.de.sistema.integrationtests.pages.LoginPage;
import teste.de.sistema.integrationtests.utils.HandleProperties;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final String userLogin;
    private final String passwordLogin;

    private final LoginPage loginPage;



    public LoginSteps(
            HandleProperties handleProperties,
            LoginPage loginPage) {
        this.userLogin = handleProperties.getValue("user_login");
        this.passwordLogin = handleProperties.getValue("user_password");

        this.loginPage = loginPage;
    }
// cenario 1
    @Dado("^que estou na tela de login$")
    public void que_estou_na_tela_de_login() throws Throwable {
        loginPage.visit("/#/search");
        loginPage.ImageIsDisplayed();
    }

    @Quando("^realizar login na aplicacao$")
    public void realizar_login_na_aplicacao() throws Throwable {
        loginPage.makeLogin(userLogin, passwordLogin);
    }

    @Então("^visualizo a pagina inicial do site$")
    public void visualizo_a_pagina_inicial_do_site() throws Throwable {
        assertTrue("A mensagem [Usuário ou senha inválido] não foi exibida corretamente.",
                    loginPage.getUserAccountSucess().equals("Conta digital: 309-8"));
    }

}
