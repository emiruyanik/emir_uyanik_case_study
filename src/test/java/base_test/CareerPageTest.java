package base_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CareerPageTest extends Hooks {

	@BeforeMethod
	public void navigateToCareerPage() {
		pages.getHomePage().clickOnCompanyListMenuItem();
		pages.getHomePage().clickOnCareersListMenuItem();
	}

	@Test
	public void testMainTitle() {
		String expected = "Ready to disrupt?";
		String actual = pages.getCareerPage().getMainTitle();
		Assert.assertEquals(actual, expected, "Wrong main title");
	}

	@Test
	public void testLocationsHeader() {
		String expected = "Our Locations";
		String actual = pages.getCareerPage().getLocationsTitle();
		Assert.assertEquals(actual, expected, "Wrong text title");
	}

	@Test
	public void testTeemsHeader() {
		String expected = "See all teams";
		String actual = pages.getCareerPage().getAllTeamsTitle();
		Assert.assertEquals(actual, expected, "Wrong text title");
	}

	@Test
	public void testLifeAtInsiderHeader() {
		String expected = "Life at Insider";
		String actual = pages.getCareerPage().getLifeAtInsiderTitle();
		Assert.assertEquals(actual, expected, "Wrong text title");
	}

}
