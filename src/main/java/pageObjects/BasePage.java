package pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public BasePage visit(String url) {
		driver.navigate().to(url);
		return new BasePage(driver);
	}
}
