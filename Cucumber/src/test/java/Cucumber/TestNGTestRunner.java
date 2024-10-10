package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//features option specifies the path to the feature files.
//The glue option specifies the package where the step definitions are located.
//This option ensures that the consoleThe plugin option specifies the reporting format and output location.
//In this case, plugin = "html:target/cucumber.html" generates an HTML report of the test results and stores it in the target directory. output is readable and clean. When monochrome is set to true, Cucumber removes unnecessary characters and color codes from the console output.
@CucumberOptions(features = "src/test/java/Cucumber",tags = "@Regression", glue = "Cucumber.stepdefinitions", monochrome = true, plugin = {
		"html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
//The IDE provides built-in support for running Cucumber feature files without explicitly needing a TestNG or JUnit runner.
//You need a runner (TestNG, JUnit, etc.) to run your Cucumber feature files. The runner serves to execute your feature files, bind the step definitions, and integrate the test results with the framework. Without a runner, the feature files cannot be executed directly.