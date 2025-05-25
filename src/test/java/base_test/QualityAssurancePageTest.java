package base_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * QualityAssurancePageTest contains test cases related to the Quality Assurance careers
 * page on Insider's website. It verifies the correct landing content and navigation
 * behavior.
 */
public class QualityAssurancePageTest extends Hooks {

	/**
	 * This method runs before each test method. It navigates directly to the QA careers
	 * landing page.
	 */
	@BeforeMethod()
	public void navigateToQAHomePage() {
		driver.navigate().to("https://useinsider.com/careers/quality-assurance/");
	}

	/**
	 * Verifies that the header/title text of the QA careers landing page is correct.
	 */
	@Test()
	public void verifyQualityAssuranceLandingPageTitle() {
		String expectedHeader = "Quality Assurance";

		// Get the actual header from the page
		String actualHeader = pages.getQualityAssurancePage().getMainTitle();

		// Assert that the actual header matches the expected
		Assert.assertEquals(actualHeader, expectedHeader, "Wrong header text on QA landing page");
	}

	/**
	 * Tests the navigation functionality by clicking the "See All QA Jobs" button and
	 * verifies the header of the redirected page.
	 */
	@Test
	public void navigateToAllQAJobsPage() {
		// Accept cookies if the prompt is shown
		pages.getQualityAssurancePage().clickAcceptAllCookies();

		// Click on the "See All QA Jobs" button
		pages.getQualityAssurancePage().clickSeeAllQAJobs();
		BrowserUtils.wait(1); // Small wait to allow the page to load

		String expectedHeader = "All open positions";

		// Get the header text of the job listing page
		String actualHeader = pages.getJobListingPage().getOpenAllPositionsHeaderText();

		// Verify that the expected header appears
		Assert.assertEquals(actualHeader, expectedHeader, "Wrong header text on All QA Jobs page");
	}

}
