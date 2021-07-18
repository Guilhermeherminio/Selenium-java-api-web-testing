package webServiceTesting;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = "webServiceTesting",
		monochrome = true,
		plugin = {
				"pretty", "junit:target/JUnitReports/report.xml",
				"html:target/HtmlReports/ReportHtml"
		},
		tags = "@regression_api"
)

public class TestRunner {
}
