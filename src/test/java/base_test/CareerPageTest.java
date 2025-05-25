package base_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This test class validates various headers and section titles on the Career page. Each
 * test method checks that a specific section is correctly displayed with the expected
 * text.
 */
public class CareerPageTest extends Hooks {

	/**
	 * This method is executed before each test method. It navigates from the home page to
	 * the career page by interacting with the header menu.
	 */
	@BeforeMethod
	public void navigateToCareerPage() {
		pages.getHomePage().clickOnCompanyListMenuItem(); // Clicks "Company" in the main
															// menu
		pages.getHomePage().clickOnCareersListMenuItem(); // Selects "Careers" from the
															// dropdown
	}

	/**
	 * Verifies that the main title of the Career page matches the expected text.
	 */
	@Test
	public void testMainTitle() {
		String expected = "Ready to disrupt?";
		String actual = pages.getCareerPage().getMainTitle();
		Assert.assertEquals(actual, expected, "Wrong main title");
	}

	/**
	 * Verifies that the "Our Locations" section header is present and correct.
	 */
	@Test
	public void testLocationsHeader() {
		String expected = "Our Locations";
		String actual = pages.getCareerPage().getLocationsTitle();
		Assert.assertEquals(actual, expected, "Wrong text title");
	}

	/**
	 * Verifies that the "See all teams" section header is displayed correctly.
	 */
	@Test
	public void testTeemsHeader() {
		String expected = "See all teams";
		String actual = pages.getCareerPage().getAllTeamsTitle();
		Assert.assertEquals(actual, expected, "Wrong text title");
	}

	/**
	 * Verifies that the "Life at Insider" section header matches the expected string.
	 */
	@Test
	public void testLifeAtInsiderHeader() {
		String expected = "Life at Insider";
		String actual = pages.getCareerPage().getLifeAtInsiderTitle();
		Assert.assertEquals(actual, expected, "Wrong text title");
	}

}
