package integrationtests.steps;

import integrationtests.pages.Register_PersonPage;
import integrationtests.pages.StrokePage;
import integrationtests.utils.HandleProperties;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Register_PersonSteps {

	private final String userLogin;
    private final String passwordLogin;
	private final Register_PersonPage register_PersonPage;
	

	public Register_PersonSteps(Register_PersonPage register_PersonPage,
			StrokePage strokePage, HandleProperties handleProperties) {
		
				
		this.register_PersonPage = register_PersonPage;
		this.userLogin = handleProperties.getValue("user_login");
        this.passwordLogin = handleProperties.getValue("user_password");

	}

	// Cenario 1
	@Dado("^que estou na tela Principal do sistema$")
	public void que_estou_na_tela_Principal_do_sistema() throws Throwable {
		register_PersonPage.visit("/#/search");

	}

	@Quando("^tocar em registrar uma conta$")
	public void tocar_em_registrar_uma_conta() throws Throwable {
		register_PersonPage.click_Create_An_Account();

	}

	@Então("^vejo a tela de cadastro de conta$")
	public void vejo_a_tela_de_cadastro_de_conta() throws Throwable {
		register_PersonPage.Authentication_IsDisplayed();
	}
//cenario2
	@Dado("^que estou na tela de cadastro de conta$")
	public void que_estou_na_tela_de_cadastro_de_conta() throws Throwable {
		register_PersonPage.visit("/#/search");
		register_PersonPage.click_Create_An_Account();

	}

	@Quando("^fornecer os dados validos$")
	public void fornecer_os_dados_validos() throws Throwable {
		register_PersonPage.fill_Name("Testando pereiras da silvas");
		register_PersonPage.makeLogin(userLogin, passwordLogin);
		// register_PersonPage.fill_Email("userqatestando@gmail.com ");
		// register_PersonPage.fill_Password("teste1234");
		register_PersonPage.fill_Password_Confirmation("teste1234");
		register_PersonPage.click_Account_balance();
		register_PersonPage.clickRegisterButton();
		

	}

	@Então("^vejo Conta cadastrado com sucesso$")
	public void vejo_Conta_cadastrado_com_sucesso() throws Throwable {
		register_PersonPage.getUsersPasswordWrongMessage().equals(
				"foi criada com sucesso");
	}
//cenario3
	@Quando("Não fornecer os dados validos")
	public void não_fornecer_os_dados_validos() {
		register_PersonPage.clickRegisterButton();

	}

	@Então("Então vejo mensagem de usuario erro")
	public void então_vejo_mensagem_de_usuario_erro() {
		register_PersonPage.getUsersRegistryaccountWrongMessage().equals(
				"É campo obrigatório.");

	}

}




