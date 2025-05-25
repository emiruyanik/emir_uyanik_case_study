package base_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import java.util.Iterator;
import java.util.Set;

public class ApplicationFormPageTest extends Hooks {

	@Test
	public void verifyViewRoleNavigationOpensCorrectJobDetailPage() {
		// Navigate to QA jobs page
		driver.navigate().to("https://useinsider.com/careers/quality-assurance/");
		BrowserUtils.wait(4);

		pages.getQualityAssurancePage().clickAcceptAllCookies();
		pages.getQualityAssurancePage().clickSeeAllQAJobs();
		BrowserUtils.wait(2);

		// Select filters
		String expectedLocation = "Istanbul, Turkiye";
		pages.getJobListingPage().selectLocationDropDown(expectedLocation);

		String expectedDepartment = "Quality Assurance";
		pages.getJobListingPage().selectDepartmentDropDown(expectedDepartment);

		// Scroll to view roles
		BrowserUtils.scrollDownWithPageDown();
		BrowserUtils.wait(1);

		// Click on "View Role" button
		pages.getJobListingPage().clickViewRoleButton();
		BrowserUtils.wait(1);

		// Handle new tab
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String originalWindow = it.next();

		if (it.hasNext()) {
			String newWindow = it.next();
			driver.switchTo().window(newWindow);
		}

		// Validate header and Apply button
		String expectedHeader = "Senior Software Quality Assurance Engineer";
		String actualHeader = pages.getApplicationFormPage().getHeaderText();
		Assert.assertEquals(actualHeader, expectedHeader, "Header text mismatch");

		boolean applyButtonIsVisible = pages.getApplicationFormPage().isSubmitButtonVisible();
		Assert.assertTrue(applyButtonIsVisible, "Apply button is missing");
	}

}
