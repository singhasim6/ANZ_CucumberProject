package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/AppFeatures/StartOver.feature"},
		glue = {"StepDefinitions"},
		plugin = {"pretty"},
		monochrome = true
		)

public class TestRunner {

}
