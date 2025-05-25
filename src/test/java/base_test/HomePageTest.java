package base_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * This test class contains a sanity check for the homepage. It validates the page title
 * and ensures that key UI elements are visible.
 */
public class HomePageTest extends Hooks {

	/**
	 * Verifies that: 1. The page title matches the expected Insider homepage title. 2.
	 * The Insider logo is displayed on the homepage.
	 */
	@Test
	public void test() {
		// Wait for 2 seconds to allow the page to load properly
		BrowserUtils.wait(2);

		// Define the expected title
		String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";

		// Get the actual title from the browser
		String actualTitle = driver.getTitle();

		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page title");

		// Assert that the Insider logo is visible on the homepage
		Assert.assertTrue(pages.getHomePage().isInsiderLogoDisplayed(), "Insider logo is not visible on the homepage");
	}

}
