package teste.de.sistema.integrationtests.utils;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class HandleProperties {
    private final Properties properties;
    private final String PROPERTIES_FILE;	
	private final String TESTS_ENVIRONMENT;

    public HandleProperties() { //utilizado para rodar em varios ambientes 
        properties = new Properties();
        PROPERTIES_FILE = System.getenv("PROPERTIES_FILE");	
	    TESTS_ENVIRONMENT = System.getenv("TESTS_ENVIRONMENT");

        loadProperties();
    }

    public String getValue(String key) {
		return properties.getProperty(key);
	}

    public String getTestsBrowser() {
        return System.getenv("TESTS_BROWSER");
    }

    public boolean isAttachmentsStoreEnabled() {
        return "true".equalsIgnoreCase(System.getenv("ENABLE_ATTACHMENTS_STORE"));
    }

    public boolean isDevelopment() {
        return "development".equalsIgnoreCase(System.getenv("EXECUTION_ENVIRONEMENT"));
    }

    private void loadProperties() {
        try (
            FileInputStream inputStream = new FileInputStream(getPropertiesPath());
        ) { 
			properties.load(inputStream);			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private String getPropertiesPath() {
		String pathFile = "./src/test/resources/";
		String file;

		if (PROPERTIES_FILE != null && !PROPERTIES_FILE.isEmpty()) {
			
			pathFile = PROPERTIES_FILE.toString();

		} else if (TESTS_ENVIRONMENT != null && !TESTS_ENVIRONMENT.isEmpty()) {
			
			switch (TESTS_ENVIRONMENT) {
				case "local":
					file = "config_local.properties";
					break;
				case "pipeline":
					file = "config_pipeline.properties";
					break;
				case "itau-dev":
					file = "config_sistema_dev.properties";
					break;
				case "itau-hom":
					file = "config_itau_hom.properties";
					break;
				case "pismo-ext":
					file = "config_pismo_ext.properties";
					break;
				default:
					file = "config_sistema_dev.properties";
					break;
			}

			pathFile = pathFile + file;

		} else {

			pathFile = pathFile + "config_itau_dev.properties";

		}

		System.out.println("Config file: " + pathFile.toString());
        
		return pathFile;
	}
}
