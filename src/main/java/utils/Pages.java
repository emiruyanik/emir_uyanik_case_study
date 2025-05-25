package utils;

import pages.*;

/**
 * Pages is a Page Object Manager class that instantiates and provides access to all page
 * object instances used across test classes.
 * <p>
 * This centralizes the page object creation and ensures that they are created only once
 * per test lifecycle.
 */
public class Pages {

	// Page object for the home page
	private HomePage homePage;

	// Page object for the career page
	private CareerPage careerPage;

	// Page object for the QA landing page
	private QualityAssurancePage qualityAssurancePage;

	// Page object for the job listings or open positions page
	private JobListingPage jobListingPage;

	// Page object for the application form page (job application form)
	private ApplicationFormPage applicationFormPage;

	/**
	 * Constructor initializes all page objects. Each page object is created once when
	 * Pages is instantiated.
	 */
	public Pages() {
		this.homePage = new HomePage();
		this.careerPage = new CareerPage();
		this.qualityAssurancePage = new QualityAssurancePage();
		this.jobListingPage = new JobListingPage();
		this.applicationFormPage = new ApplicationFormPage();
	}

	/**
	 * @return HomePage object representing the main landing page.
	 */
	public HomePage getHomePage() {
		return homePage;
	}

	/**
	 * @return CareerPage object representing the career information section.
	 */
	public CareerPage getCareerPage() {
		return careerPage;
	}

	/**
	 * @return QualityAssurancePage object representing the QA-specific job listing
	 * section.
	 */
	public QualityAssurancePage getQualityAssurancePage() {
		return qualityAssurancePage;
	}

	/**
	 * @return JobListingPage object representing the complete open positions listing.
	 */
	public JobListingPage getJobListingPage() {
		return jobListingPage;
	}

	/**
	 * @return ApplicationFormPage object representing the job application form section.
	 */
	public ApplicationFormPage getApplicationFormPage() {
		return applicationFormPage;
	}

}
