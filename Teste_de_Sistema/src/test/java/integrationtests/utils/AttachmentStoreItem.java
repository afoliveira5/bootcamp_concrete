package integrationtests.utils;

import io.cucumber.java.Scenario;

public class AttachmentStoreItem { //fazer e salvar screenshot de um item da tela quando da erro
	
	private final byte[] screenshot;
	private final String name;
	
	public AttachmentStoreItem(byte[] screenshot, String name) {
		this.screenshot = screenshot;
		this.name = name;
	}
	
	public void writeAttachment(Scenario scenario) {
		try {
			 scenario.embed(this.screenshot, "image/png", this.name);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}    
	}	
	
}
