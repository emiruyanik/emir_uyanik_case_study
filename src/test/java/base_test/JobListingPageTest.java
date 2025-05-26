package base_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import java.util.List;

/**
 * JobListingPageTest contains automated test cases for verifying the job filtering
 * functionality on the Job Listing page of Insider's QA careers section.
 */
public class JobListingPageTest extends Hooks {

	// Expected filter values for location and department
	private final String expectedLocation = "Istanbul, Turkiye";

	private final String expectedDepartment = "Quality Assurance";

	/**
	 * This setup method runs before each test. It navigates to the QA careers page,
	 * accepts cookies, clicks to see all QA jobs, applies filters, and scrolls down.
	 */
	@BeforeMethod
	public void setUpJobFilter() {
		// Navigate directly to the QA careers page
		driver.navigate().to("https://useinsider.com/careers/quality-assurance/");
		BrowserUtils.wait(4);

		// Accept cookie policy if prompted
		pages.getQualityAssurancePage().clickAcceptAllCookies();

		// Click to view all Quality Assurance job listings
		pages.getQualityAssurancePage().clickSeeAllQAJobs();
		BrowserUtils.wait(2);

		// Apply filters: location and department
		pages.getJobListingPage().selectLocationDropDown(expectedLocation);
		pages.getJobListingPage().selectDepartmentDropDown(expectedDepartment);

		// Scroll to ensure jobs are loaded
		BrowserUtils.scrollDownWithPageDown();
		BrowserUtils.wait(2);
	}

	/**
	 * Verifies that job listings appear after applying department and location filters.
	 */
	@Test
	public void applyFiltersAndVerifyResultsAreNotEmpty() {
		int filteredJobListSize = pages.getJobListingPage().getAllJobsListSize();
		Assert.assertTrue(filteredJobListSize > 0, "No jobs found for the selected filters.");
	}

	/**
	 * Verifies that all filtered job results match the selected location and department
	 * criteria.
	 */
	@Test
	public void verifyAllFilteredJobsMatchSelectedCriteria() {
		// Retrieve lists of titles, departments, and locations for all filtered jobs
		List<String> titles = pages.getJobListingPage().getAllJobTitles();
		List<String> departments = pages.getJobListingPage().getAllJobDepartments();
		List<String> locations = pages.getJobListingPage().getAllJobLocations();

		// Loop through all results and assert correctness
		for (int i = 0; i < titles.size(); i++) {
			Assert.assertTrue(titles.get(i).contains("Quality Assurance"), "Mismatch in job title: " + titles.get(i));
			Assert.assertEquals(departments.get(i), expectedDepartment, "Mismatch in department at index: " + i);
			Assert.assertEquals(locations.get(i), expectedLocation, "Mismatch in location at index: " + i);
		}
	}

}
