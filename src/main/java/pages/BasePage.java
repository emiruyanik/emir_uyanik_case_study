package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import java.time.Duration;

/**
 * BasePage serves as the parent class for all Page Object classes. It initializes common
 * web driver utilities such as: - WebDriver instance - PageFactory elements - Actions for
 * mouse/keyboard interactions - WebDriverWait for explicit waits
 * <p>
 * Any page class that extends BasePage will inherit these setups, providing a consistent
 * and reusable testing framework foundation.
 */
public abstract class BasePage {

	protected WebDriver driver; // WebDriver instance to interact with the browser

	protected Actions actions; // Used for advanced user interactions (e.g., hover,
								// drag-and-drop)

	protected WebDriverWait wait; // Can be used for implementing explicit waits (if
									// needed manually)

	/**
	 * Constructor that initializes the driver, waits, actions, and the PageFactory
	 * elements for the current page class.
	 */
	public BasePage() {
		driver = DriverManager.getWebDriver(); // Get the current WebDriver instance
		PageFactory.initElements(driver, this); // Initialize WebElements with PageFactory
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit
																			// wait

		actions = new Actions(driver); // Initialize Actions for interaction
	}

}
