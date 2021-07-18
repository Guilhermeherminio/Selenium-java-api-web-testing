package browserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.ProductSubscriptionPage;

public class Steps {

	WebDriver driver = new ChromeDriver();
	ProductSubscriptionPage productSubscriptionPage = new ProductSubscriptionPage(driver);
	BasePage basePage = new BasePage(driver);

	@Before
	public void before() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Given("^I open Chrome and launch the application$")
	public void openChromeAndLaunchApplication() {
		basePage.visit("https://qa-automation-challenge.github.io/sandbox/");
	}

	@When("^I select type (.*)$")
	public void selectTypeMethod(String type) {
		productSubscriptionPage.selectTypeMethod(type);
	}

	@When("^I select support plan (.*)$")
	public void selectSupportPlan(String plan) {
		productSubscriptionPage.selectSupportPlan(plan);
	}

	@When("^I write monthly duration of (.*)$")
	public void monthlyDurationInput(String duration) {
		productSubscriptionPage.monthlyDurationInput(duration);
	}

	@When("^I click in calculate price button")
	public void clickCalculatePriceButton() {
		productSubscriptionPage.clickCalculatePriceButton();
	}

	@Then("^I validate price is (.*)$")
	public void validatePrice(String price) {
		productSubscriptionPage.validatePrice(price);
	}

	@After
	public void after() {
		driver.close();
	}
}
