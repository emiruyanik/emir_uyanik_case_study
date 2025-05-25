package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import java.util.ArrayList;
import java.util.List;

public class JobListingPage extends BasePage {

	@FindBy(css = ".mb-2")
	private WebElement openAllPositionsHeader;

	@FindBy(css = "#filter-by-location")
	private WebElement filterByLocationDropDown;

	@FindBy(id = "filter-by-department")
	private WebElement filterByDepartmentDropDown;

	@FindBy(css = ".position-list-item-wrapper")
	private List<WebElement> allJobsList;

	@FindBy(css = ".position-title.font-weight-bold")
	private List<WebElement> positionTitles;

	@FindBy(css = ".position-department")
	private List<WebElement> positionDepartments;

	@FindBy(css = ".position-location.text-large")
	private List<WebElement> positionLocations;

	@FindBy(css = ".btn.btn-navy.rounded.pt-2")
	private List<WebElement> viewRoleButtons;

	public String getOpenAllPositionsHeaderText() {
		return openAllPositionsHeader.getText();
	}

	public void selectLocationDropDown(String country) {
		BrowserUtils.wait(4);
		Select select = new Select(filterByLocationDropDown);
		select.selectByVisibleText(country);

	}

	public void selectDepartmentDropDown(String department) {
		Select select = new Select(filterByDepartmentDropDown);
		select.selectByVisibleText(department);
	}

	public int getAllJobsListSize() {
		return allJobsList.size();
	}

	public List<String> getAllJobTitles() {
		List<String> jobTitles = new ArrayList<>();
		for (WebElement webElement : positionTitles) {
			jobTitles.add(webElement.getText());
		}
		return jobTitles;
	}

	public List<String> getAllJobDepartments() {
		List<String> departments = new ArrayList<>();
		for (WebElement webElement : positionDepartments) {
			departments.add(webElement.getText());
		}
		return departments;
	}

	public List<String> getAllJobLocations() {
		List<String> locations = new ArrayList<>();
		for (WebElement webElement : positionLocations) {
			locations.add(webElement.getText());
		}
		return locations;
	}

	public void clickViewRoleButton() {
		viewRoleButtons.get(0).click();
	}

}
