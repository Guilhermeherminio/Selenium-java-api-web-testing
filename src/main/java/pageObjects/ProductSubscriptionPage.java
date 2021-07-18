package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSubscriptionPage {
	protected WebDriver driver;

	private By typePlan = By.id("type");

	private By supportPlan = By.id("support");

	private By monthlyDuration = By.id("duration");
	
	private By calculateButton = By.id("calculate");
	
	private By priceText = By.id("price");


	public ProductSubscriptionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ProductSubscriptionPage selectTypeMethod(String type) {
		Select selectElement = new Select(driver.findElement(typePlan));
        selectElement.selectByVisibleText(type);
		return new ProductSubscriptionPage(driver);
	}
	
	public ProductSubscriptionPage selectSupportPlan(String plan) {
		Select selectElement = new Select(driver.findElement(supportPlan));
        selectElement.selectByVisibleText(plan);
		return new ProductSubscriptionPage(driver);
	}
	
	public ProductSubscriptionPage monthlyDurationInput(String duration) {
		driver.findElement(monthlyDuration).sendKeys(duration);
		return new ProductSubscriptionPage(driver);
	}
	
	public ProductSubscriptionPage clickCalculatePriceButton() {
		driver.findElement(calculateButton).click();
		return new ProductSubscriptionPage(driver);
	}
	
	public ProductSubscriptionPage validatePrice(String price) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceText));
        Assert.assertEquals(price, driver.findElement(priceText).getText());
		return new ProductSubscriptionPage(driver);
	}
}
