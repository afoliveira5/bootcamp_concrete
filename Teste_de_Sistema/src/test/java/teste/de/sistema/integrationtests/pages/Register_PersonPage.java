package teste.de.sistema.integrationtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import teste.de.sistema.integrationtests.utils.Browser;
import teste.de.sistema.integrationtests.utils.HandleProperties;
import teste.de.sistema.integrationtests.utils.Page;

public class Register_PersonPage extends Page {

	private final String urlBase;
	private final By Create_an_Account = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]");//botao de criar conta de usuario
	private final By Authentication = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input"); // verifica se esta na tela de cadastro de usuario
	private final By User_Name = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input"); //digita o nome do usuario
	private final By User_Email = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input"); //digita o email do usuario
	private final By User_Password = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input");//digita o senha do usuario
	private final By User_Password_Confirmation = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input");//digita o a confirmação da senha do usuario
	private final By Account_balance = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[6]/label/span"); //radio button para criar a conta com valor 	
	private final By Register_Button = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button"); //botão de cadastro
	private final By USER_PASSWORD_WRONG_MESSAGE = By.id("modalText"); // mensagem de usuario cadastrado com sucesso
	private final By LOGIN_FIELD_NOT_FOUND = By.id("user_email");
	private final By User_Registry_account_Wrong_Message = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/p");

	
	
	
	public Register_PersonPage(Browser browser, HandleProperties handleProperties) {
        super(browser.getWebDriver());

        this.urlBase = handleProperties.getValue("url_base");
    } // monta a url

	public void visit(String url) {
        openUrl(urlBase);
        isUrlContainsValue(url);
    }// acessa a url

	public void click_Create_An_Account() {
		click(Create_an_Account);
	}//verifica se esta na tela do bugbank
	
	public boolean Authentication_IsDisplayed() {
		return isVisible(Authentication);
	}//verifica se esta na tela de cadastro

	public void fill_Name(String Name) {
		fillInput(Name, User_Name);
	}// escreve no campo de nome

	public void fill_Email(String Name) {
		fillInput(Name, User_Email);
	}// escreve no campo de email

	public void fill_Password(String PWD) {
		fillInput(PWD, User_Password);
	} //escreve no campo de senha

	public void fill_Password_Confirmation(String PWD) {
		fillInput(PWD, User_Password_Confirmation);
	} //escreve no campo de senha de confirmação 

	public void click_Account_balance() {
		click(Account_balance);
	}//clica no radio button do saldo da conta

	public void clickRegisterButton() {
		click(Register_Button);
	}//clica no botão de cadasrar usuario 


	public String getUsersPasswordWrongMessage() {
		WebElement webElement = getElement(USER_PASSWORD_WRONG_MESSAGE);
		return getTextOfVisibleElement(webElement);
	} //verifica se a mensagem de erro quando nao fornece um password na hora do cadastro

	public String getUsersRegistryaccountWrongMessage() {
		WebElement webElement = getElement(User_Registry_account_Wrong_Message);
		return getTextOfVisibleElement(webElement);
	} //verifica se a mensagem de usuario cadastrado com sucesso

}
