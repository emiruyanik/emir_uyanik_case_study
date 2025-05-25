package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[contains(text(),'Company')]")
	private WebElement companyListMenuItem;

	@FindBy(xpath = "//a[contains(.,'Careers')]")
	private WebElement careersListMenuItem;

	@FindBy(css = "img[alt='insider_logo']")
	private WebElement logoImage;

	public void clickOnCompanyListMenuItem() {
		actions.moveToElement(companyListMenuItem).perform();
		BrowserUtils.wait(2);
	}

	public void clickOnCareersListMenuItem() {
		careersListMenuItem.click();
	}

	public boolean isInsiderLogoDisplayed() {
		return logoImage.isDisplayed();
	}

}
