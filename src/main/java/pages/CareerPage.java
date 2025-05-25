package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CareerPage extends BasePage {

	@FindBy(css = ".big-title")
	private WebElement mainTitle;

	@FindBy(xpath = "//h3[contains(.,'Our Locations')]")
	private WebElement locationsTitle;

	@FindBy(xpath = "//a[contains(.,'See all teams')]")
	private WebElement allTeamsTitle;

	@FindBy(xpath = "//h2[contains(.,'Life at Insider')]")
	private WebElement lifeAtInsiderTitle;

	public String getMainTitle() {
		return mainTitle.getText();
	}

	public String getLocationsTitle() {
		actions.moveToElement(locationsTitle).perform();
		BrowserUtils.wait(1);
		return locationsTitle.getText();
	}

	public String getAllTeamsTitle() {
		actions.moveToElement(allTeamsTitle).perform();
		BrowserUtils.wait(1);
		return allTeamsTitle.getText();
	}

	public String getLifeAtInsiderTitle() {
		actions.moveToElement(lifeAtInsiderTitle).perform();
		BrowserUtils.wait(3);
		return lifeAtInsiderTitle.getText();
	}

}
