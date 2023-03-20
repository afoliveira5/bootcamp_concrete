package teste.de.sistema.integrationtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import teste.de.sistema.integrationtests.utils.Browser;
import teste.de.sistema.integrationtests.utils.HandleProperties;
import teste.de.sistema.integrationtests.utils.Page;

public class LoginPage extends Page {

    private final String urlBase;

    private final By image = By.xpath("//*[@id=\"__next\"]/div/div[1]/span/img");
    private final By LOGIN_FIELD = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input");
    private final By PASSWORD_FIELD = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input");
    private final By ENTER_BUTTON = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]");
    private final By Button_instruction = By.xpath("/html/body/div[1]/div[3]/center/a");
    private final By AccountUser = By.id("textAccountNumber");


    public LoginPage(Browser browser, HandleProperties handleProperties) {
        super(browser.getWebDriver());

        this.urlBase = handleProperties.getValue("url_base");
    }

    public void visit(String url) {
        openUrl(urlBase);
        isUrlContainsValue(url);

    }

    public void fillLoginField(String user) {
        fillInput(user, LOGIN_FIELD);

    }


    public void fillPasswordField(String password) {
        fillInput(password, PASSWORD_FIELD);
    }

    public void clickEnterButton() {
        click(ENTER_BUTTON);
    }

 public String getUserAccountSucess() {
        WebElement webElement = getElement(AccountUser);
        return getTextOfVisibleElement(webElement);
    }


    public void makeLogin(String user, String password) {
        fillLoginField(user);
        fillPasswordField(password);
        clickEnterButton();
    }

    public void makeLoginPasswordNotFound(String user, String  PASSWORD_FIELD_NOTFOUND) {
        fillLoginField(user);
        fillPasswordField( PASSWORD_FIELD_NOTFOUND);
        clickEnterButton();
    }

    public void makeLoginAdress(String userAdress, String passwordAdress) {
        fillLoginField(userAdress);
        fillPasswordField(passwordAdress);
        clickEnterButton();
    }

    public boolean ButtonInstructionIsDisplayed() {
        return isVisible(Button_instruction);
    }

    public boolean ImageIsDisplayed() {
        return isVisible(image);
    }

}
