package integrationtests.steps;

import java.lang.Exception;
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import integrationtests.utils.AttachmentsStore;
import integrationtests.utils.Browser;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.OutputType;

public class Hooks {
    private final AttachmentsStore attachmentsStore;
    private final Browser browser;

    public Hooks(Browser browser, AttachmentsStore attachmentsStore) {
        this.attachmentsStore = attachmentsStore;
        this.browser = browser;
    }

    @After
    public void quitBrowser(Scenario scenario) {
        embedFailureScreenshot(scenario);
        
        writeFailureLogs(scenario);

        embedAttachmentsStore(scenario);

        browser.quitBrowser();
    }    

	private void embedFailureScreenshot(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot)browser.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png", "Scenario Failure Screenshot");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }   
    }
	
	private void writeFailureLogs(Scenario scenario) {
    	try {
            if (scenario.isFailed()) {                
                LogEntries entries = browser.getWebDriver().manage().logs().get("browser");
                List<LogEntry> logs = entries.getAll();
                
                for (LogEntry log : logs) {
                	scenario.write(log.getMessage());
                }
            }
        }        
        catch (Exception e) {
            e.printStackTrace();
        } 
	}

	private void embedAttachmentsStore(Scenario scenario) {
        try {
            attachmentsStore.writeAttachments(scenario);                    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
