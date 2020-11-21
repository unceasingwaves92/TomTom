package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/TomTom.feature"},
					glue = {"stepsTom", "Hooks"},
					monochrome = true)

public class RunCucumber extends AbstractTestNGCucumberTests {

}
