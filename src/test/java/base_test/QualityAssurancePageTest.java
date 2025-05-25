package base_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class QualityAssurancePageTest extends Hooks {

	@Test()
	public void verifyQualityAssuranceLandingPageTitle() {
		driver.navigate().to("https://useinsider.com/careers/quality-assurance/");

		String expectedHeader = "Quality Assurance";

		String actualHeader = pages.getQaHomePage().getMainTitle();

		Assert.assertEquals(actualHeader, expectedHeader, "wrong header");
	}

	@Test
	public void navigateToAllQAJobsPage() {
		pages.getQaHomePage().clickAcceptAllCookies();
		pages.getQaHomePage().clickSeeAllQAJobs();
		BrowserUtils.wait(1);

		String expectedHeader = "All open positions";

		String actualHeader = pages.getAllOpenPositionsPage().getOpenAllPositionsHeaderText();

		Assert.assertEquals(actualHeader, expectedHeader, "wrong header");

	}

}