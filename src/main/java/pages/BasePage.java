package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public abstract class BasePage {

	protected WebDriver driver;

	protected Actions actions;

	protected WebDriverWait wait;

	/**
	 * This base page
	 *
	 */
	public BasePage() {
		driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		actions = new Actions(driver);

	}

}
