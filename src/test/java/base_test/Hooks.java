package base_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.DriverManager;
import utils.Pages;

/**
 * Hooks is a base test class providing setup and teardown functionality for all test
 * classes that extend it.
 *
 * It initializes the WebDriver and Page Object instances before each test and ensures
 * proper cleanup afterward.
 */
public class Hooks {

	// Page object manager to access all page classes
	protected Pages pages;

	// SoftAssert instance to allow multiple assertions in a single test
	public SoftAssert softAssert = new SoftAssert();

	// WebDriver instance used in tests
	WebDriver driver;

	/**
	 * This method runs before each test method. It initializes the WebDriver and the
	 * Pages object.
	 */
	@BeforeMethod
	public void setUpTestEnvironment() {
		// Initialize the WebDriver from the DriverManager utility class
		DriverManager.getWebDriver();

		// Instantiate the Pages object to access page-level actions
		pages = new Pages();

		// Get the WebDriver instance to be used in the test class
		driver = DriverManager.getWebDriver();
	}

	/**
	 * This method runs after each test method. It ensures the browser is closed and
	 * WebDriver is cleaned up.
	 */
	@AfterMethod
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
	}

}
