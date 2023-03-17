package teste.de.sistema.integrationtests.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    features = "src/test/resources/features",
    glue = "teste/de/sistema/integrationtests/steps",
    plugin = { 
        "pretty",
        "json:target/cucumber-reports/Report.json",
        "html:target/cucumber-html-reports"
    }
)
public class RunCucumberTest {

}
