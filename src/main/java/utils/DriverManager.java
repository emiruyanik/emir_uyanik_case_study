package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * DriverManager is a utility class responsible for managing the WebDriver instance using
 * ThreadLocal to ensure thread safety in parallel executions.
 */
public class DriverManager {

	// Thread-safe WebDriver instance
	private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

	// Private constructor to prevent instantiation
	private DriverManager() {
		throw new UnsupportedOperationException("You cannot instantiate utils.DriverManager");
	}

	/**
	 * Initializes and returns the WebDriver instance. The browser type and base URL are
	 * read from the config file.
	 *
	 * Supported browsers: Chrome (default), Firefox, Edge.
	 * @return WebDriver instance (thread-safe)
	 */
	public static WebDriver getWebDriver() {
		String browserType = ConfigManager.getProperty("browser").toLowerCase();
		WebDriver driver = null;

		// Only initialize driver if not already created for this thread
		if (THREAD_LOCAL_DRIVER.get() == null) {
			switch (browserType) {
				case "firefox":
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.addArguments("--width=1920");
					firefoxOptions.addArguments("--height=1080");
					driver = new FirefoxDriver(firefoxOptions);
					break;

				case "edge":
					EdgeOptions edgeOptions = new EdgeOptions();
					edgeOptions.addArguments("--start-maximized");
					edgeOptions.addArguments("--ignore-certificate-error");
					driver = new EdgeDriver(edgeOptions);
					break;

				default: // Default to Chrome
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--ignore-certificate-error");
					driver = new ChromeDriver(chromeOptions);
					break;
			}

			// Navigate to base URL after driver creation
			driver.get(ConfigManager.getProperty("baseURL"));
			THREAD_LOCAL_DRIVER.set(driver);
		}

		return THREAD_LOCAL_DRIVER.get();
	}

	/**
	 * Closes and removes the WebDriver instance associated with the current thread.
	 * Ensures proper cleanup after test execution.
	 */
	public static void closeDriver() {
		WebDriver driver = THREAD_LOCAL_DRIVER.get();
		if (driver != null) {
			driver.quit(); // Close browser and end session
			THREAD_LOCAL_DRIVER.remove(); // Remove from ThreadLocal
		}
	}

}
