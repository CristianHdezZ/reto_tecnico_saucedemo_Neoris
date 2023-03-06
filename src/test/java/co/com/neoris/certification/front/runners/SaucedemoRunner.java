package co.com.neoris.certification.front.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/saucedemo.feature",
        glue = "co.com.neoris.certification.front.steps",
        tags = "@Successful_Purchase",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SaucedemoRunner {
}
