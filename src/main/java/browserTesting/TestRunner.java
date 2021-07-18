package browserTesting;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = "browserTesting",
		monochrome = true,
		plugin = {
				"pretty", "junit:target/JUnitReports/report.xml",
				"html:target/HtmlReports/ReportHtml"
		},
		tags = "@regression_web"
)

public class TestRunner {
}
