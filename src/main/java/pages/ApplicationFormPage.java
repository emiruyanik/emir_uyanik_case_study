package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ApplicationFormPage extends BasePage {

	@FindBy(xpath = "//h2[contains(text(),'Senior Software Quality Assurance Engineer')]")
	private WebElement header;

	@FindBy(css = ".postings-btn.template-btn-submit")
	private List<WebElement> submitButtons;

	public String getHeaderText() {
		return header.getText();
	}

	public boolean isSubmitButtonVisible() {
		return submitButtons.get(0).isDisplayed();
	}

}
