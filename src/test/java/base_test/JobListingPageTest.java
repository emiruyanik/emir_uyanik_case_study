package base_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import java.util.List;

public class JobListingPageTest extends Hooks {

	private final String expectedLocation = "Istanbul, Turkiye";

	private final String expectedDepartment = "Quality Assurance";

	@BeforeMethod
	public void setUpJobFilter() {
		pages.getQaHomePage().clickAcceptAllCookies();
		pages.getQaHomePage().clickSeeAllQAJobs();
		BrowserUtils.wait(2);

		pages.getAllOpenPositionsPage().selectLocationDropDown(expectedLocation);
		pages.getAllOpenPositionsPage().selectDepartmentDropDown(expectedDepartment);
		BrowserUtils.wait(2);
		BrowserUtils.scrollDownWithPageDown();
	}

	@Test
	public void applyFiltersAndVerifyResultsAreNotEmpty() {
		int filteredJobListSize = pages.getAllOpenPositionsPage().getAllJobsListSize();
		Assert.assertTrue(filteredJobListSize > 0, "No jobs found for the selected filters.");
	}

	@Test
	public void verifyAllFilteredJobsMatchSelectedCriteria() {
		List<String> titles = pages.getAllOpenPositionsPage().getAllJobTitles();
		List<String> departments = pages.getAllOpenPositionsPage().getAllJobDepartments();
		List<String> locations = pages.getAllOpenPositionsPage().getAllJobLocations();

		for (int i = 0; i < titles.size(); i++) {
			Assert.assertTrue(titles.get(i).contains("Quality Assurance"), "Mismatch in job title: " + titles.get(i));
			Assert.assertEquals(departments.get(i), expectedDepartment, "Mismatch in department at index: " + i);
			Assert.assertEquals(locations.get(i), expectedLocation, "Mismatch in location at index: " + i);
		}
	}

}
