package base_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.DriverManager;
import utils.Pages;

public class Hooks {

	protected Pages pages;

	public SoftAssert softAssert = new SoftAssert();

	WebDriver driver;

	@BeforeMethod
	public void setUpTestEnvironment() {
		DriverManager.getWebDriver();
		pages = new Pages();
		driver = DriverManager.getWebDriver();
	}

	@AfterMethod
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
	}

}
