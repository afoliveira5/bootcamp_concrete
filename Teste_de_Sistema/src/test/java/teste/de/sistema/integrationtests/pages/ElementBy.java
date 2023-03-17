package teste.de.sistema.integrationtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import teste.de.sistema.integrationtests.utils.Browser;

public abstract class ElementBy extends By {

	public final By dataAttribute(String data) {
		return By.cssSelector("[data-test='" + data + "']");
	}

	public static void sendKeys(String chord, Keys backSpace) {
	}
}