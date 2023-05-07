package integrationtests.utils;

import java.util.List;
import java.util.LinkedList;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

public class AttachmentsStore {//fazer e salvar screenshot da tela quando da erro

    private final Browser browser;
    private final HandleProperties handleProperties;
    private final List<AttachmentStoreItem> attachments;

    public AttachmentsStore(HandleProperties handleProperties, Browser browser) {
        this.handleProperties = handleProperties;
        this.browser = browser;
        this.attachments = new LinkedList<>();
    }

    public void addScreenshot() {
        addScreenshot("Item without name");
    }
    
    public void addScreenshot(String name) {
        if (!handleProperties.isAttachmentsStoreEnabled()) return;

        try {
            byte[] screenshot = ((TakesScreenshot)browser.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            attachments.add(new AttachmentStoreItem(screenshot, name));
        }
        catch (Exception e) {
            e.printStackTrace();
        }     
    }

    public void writeAttachments(Scenario scenario) {
        if (!handleProperties.isAttachmentsStoreEnabled()) return;

        for (AttachmentStoreItem attachment : attachments) {
        	attachment.writeAttachment(scenario);
        }
    }
}