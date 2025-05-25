package utils;

import pages.JobListingPage;
import pages.CareerPage;
import pages.HomePage;
import pages.QualityAssurancePage;

public class Pages {

	private HomePage homePage;

	private CareerPage careerPage;

	private QualityAssurancePage qaHomePage;

	private JobListingPage allOpenPositionsPage;

	public Pages() {
		this.homePage = new HomePage();
		this.careerPage = new CareerPage();
		this.qaHomePage = new QualityAssurancePage();
		this.allOpenPositionsPage = new JobListingPage();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public CareerPage getCareerPage() {
		return careerPage;
	}

	public QualityAssurancePage getQaHomePage() {
		return qaHomePage;
	}

	public JobListingPage getAllOpenPositionsPage() {
		return allOpenPositionsPage;
	}

}
