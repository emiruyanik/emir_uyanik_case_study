package base_test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Hooks {

	@Test
	public void test() {
		Assert.assertTrue(pages.getHomePage().isInsiderLogoDisplayed(), "Insider logo is not visible on homepage");

	}

}
