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

    @Então("^visualizo a home do site$")
    public void visualizo_a_home_do_site() throws Throwable {
        assertTrue("A mensagem [Usuário ou senha inválido] não foi exibida corretamente.",
                    loginPage.getUserAccountSucess().equals("Conta digital: 309-8"));
    
    }

    // @Quando("^realizar login com usuario invalido$")
    // public void realizar_login_com_usuario_invalido() throws Throwable {
        // loginPage.makeLoginEmailNotFound("qatestando@gmail.com", passwordLogin);
    // }

    // @Então("^vejo mensagem de usuario ou senha invalido$")
    // public void vejo_mensagem_de_usuario_ou_senha_invalido() throws Throwable {
    //     assertTrue("A mensagem [Usuário ou senha inválido] não foi exibida corretamente.",
                // loginPage.getUserPasswordWrongMessage().equals("Invalid email or password."));
    // }

    // @Quando("^realizar login com senha invalida$")
    // public void realizar_login_com_senha_invalida() throws Throwable {
    //     loginPage.makeLoginPasswordNotFound(userLogin, "Senhaxpto1");
    // }

    // @Quando("^tocar em esqueceu a senha$")
    // public void tocar_em_esqueceu_a_senha() throws Throwable {
    // }

    // @Então("^vejo a tela de esqueci a senha$")
    // public void vejo_a_tela_de_esqueci_a_senha() throws Throwable {
    // }

    // @Dado("^que estou na tela login de esqueci a senha$")
    // public void que_estou_na_tela_login_de_esqueci_a_senha() throws Throwable {
    // }

    // @Quando("^tocar em lembrou$")
    // public void tocar_em_lembrou() throws Throwable {
    // }

    // @Então("^volto para tela de login$")
    // public void volto_para_tela_de_login() throws Throwable {
    // }

    // @Quando("^envio o email para prosseguir$")
    // public void envio_o_email_para_prosseguir() throws Throwable {
    // }

    // @Então("^retorno para a tela de login$")
    // public void retorno_para_a_tela_de_login() throws Throwable {
    // }

    // @Dado("^que estou na tela de login do usuario$")
    // public void que_estou_na_tela_de_login_do_usuario() throws Throwable {
    // }

    // @Quando("^estou sem conexão com a internets$")
    // public void estou_sem_conexão_com_a_internets() throws Throwable {
    // }

    // @Quando("^realizar login na aplicacao sem internet$")
    // public void realizar_login_na_aplicacao_sem_internet() throws Throwable {
    // }

    // @Então("^nao consigo realizar login na aplicacao$")
    // public void nao_consigo_realizar_login_na_aplicacao() throws Throwable {
    // }

}
