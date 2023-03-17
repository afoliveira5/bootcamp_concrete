package teste.de.sistema.integrationtests.utils;

import java.lang.IllegalArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Browser {

    private final WebDriver webDriver;
    private final HandleProperties handleProperties;

    public Browser(HandleProperties handleProperties) {
        this.handleProperties = handleProperties;
        this.webDriver = createDriverInstance();
    }    

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void quitBrowser() {
        webDriver.quit();
    }

    private WebDriver createDriverInstance() {
        String browserType = handleProperties.getTestsBrowser(); 

        if (browserType == null) {
            throw new IllegalArgumentException("TESTS_BROWSER environment variable not found.");
        }

        switch (browserType.toLowerCase()) {// fazer o projeto rodar feito prompt de comando e abrindo o navegador
            case "chrome":        
                ChromeOptions options = new ChromeOptions();

                if (handleProperties.isDevelopment()) {
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-web-security");
                    // options.addArguments("--start-fullscreen");
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-infobars");
                    options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" }); 
                    options.setExperimentalOption("useAutomationExtension", false);

                    // options.addArguments("--disable-gpu");                    
                    // options.addArguments("--no-first-run");
                    // options.addArguments("--allow-running-insecure-content");
                    // options.addArguments("--kiosk");//tela cheia sem borda
                    // DesiredCapabilities capabilities = DesiredCapabilities.chrome();                
                    // capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                }
                else {
    			    options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                }    

                options.addArguments("--ignore-certificate-errors");         
                
                return new ChromeDriver(options);        
            case "firefox":
                return new FirefoxDriver(); 
            case "edge":
                return new EdgeDriver();     
            case "ie":
                return new InternetExplorerDriver();          
            default:
                throw new IllegalArgumentException("Invalid TESTS_BROWSER environment variable: " + browserType + ". Valid values are: chrome, firefox, edge or ie");
        }
    }

}