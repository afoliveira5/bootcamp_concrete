package integrationtests.pages;
// import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import integrationtests.utils.Browser;
import integrationtests.utils.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class StrokePage extends Page {

	private final By BLANK_CLICK = By.xpath("//body");

	public StrokePage(Browser browser) {
		super(browser.getWebDriver());
	}

	public void setDelay() throws Throwable {
		Thread.sleep(2000);

	}

	public void setDelayUltra() throws Throwable {
		Thread.sleep(20000);

	}

	public void scroll() {
		click(BLANK_CLICK);
		int i = 0;
		while (i <= 10) {
			getElement(BLANK_CLICK).sendKeys(Keys.DOWN);
			i++;

		}
	}

	public void scroll_up() {
		click(BLANK_CLICK);
		int i = 0;
		while (i <= 2) {
			getElement(BLANK_CLICK).sendKeys(Keys.UP);
			i++;
		}
	}

	public void scroll_up_up() {
		click(BLANK_CLICK);
		int i = 0;
		while (i <= 60) {
			getElement(BLANK_CLICK).sendKeys(Keys.DOWN);
			i++;
		}
	}

	public void apagar_elemento() {
		ElementBy.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

	}

	public static void setDlay() {
	}

}
