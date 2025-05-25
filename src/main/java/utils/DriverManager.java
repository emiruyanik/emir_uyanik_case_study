package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

	private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

	private DriverManager() {
		throw new UnsupportedOperationException("You cannot instantiate utils.DriverManager");
	}

	public static WebDriver getWebDriver() {
		String browserType = ConfigManager.getProperty("browser").toLowerCase();
		WebDriver driver = null;

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

				default:
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--ignore-certificate-error");
					driver = new ChromeDriver(chromeOptions);
					break;
			}

			driver.get(ConfigManager.getProperty("baseURL"));
			THREAD_LOCAL_DRIVER.set(driver);
		}

		return THREAD_LOCAL_DRIVER.get();
	}

	public static void closeDriver() {
		WebDriver driver = THREAD_LOCAL_DRIVER.get();
		if (driver != null) {
			driver.quit();
			THREAD_LOCAL_DRIVER.remove();
		}
	}

}
