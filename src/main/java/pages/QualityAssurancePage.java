package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage {

	@FindBy(css = ".big-title")
	private WebElement mainTitle;

	@FindBy(css = ".button-group.d-flex.flex-row>a")
	private WebElement seeAllQAJobs;

	@FindBy(id = "wt-cli-accept-all-btn")
	private WebElement acceptAllCookiesBtn;

	public String getMainTitle() {
		return mainTitle.getText();
	}

	public void clickSeeAllQAJobs() {
		seeAllQAJobs.click();
	}

	public void clickAcceptAllCookies() {
		if (acceptAllCookiesBtn.isDisplayed()) {
			acceptAllCookiesBtn.click();
		}

	}

}
