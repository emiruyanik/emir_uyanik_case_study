package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {

	/**
	 * Scrolls down the page using the PAGE_DOWN key once. Then waits for 1 second.
	 */
	public static void scrollDownWithPageDown() {
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
		wait(1);
	}

	/**
	 * Scrolls up the page using the PAGE_UP key once. Then waits for 1 second.
	 */
	public static void scrollUpWithPageUp() {
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.keyDown(Keys.PAGE_UP).release().build().perform();
		wait(1);
	}

	/**
	 * Waits for the specified time (in seconds).
	 * @param timeout Time to wait in seconds (double)
	 */
	public static void wait(double timeout) {
		try {
			Thread.sleep((long) timeout * 1000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Waits for the specified time (in seconds). Overloaded method for integer input.
	 * @param timeout Time to wait in seconds (int)
	 */
	public static void wait(int timeout) {
		try {
			Thread.sleep(timeout * 1000L);
		}
		catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Scrolls down the page using the PAGE_DOWN key multiple times.
	 * @param times Number of times to press PAGE_DOWN key
	 */
	public static void scrollDownWithPageDown(int times) {
		Actions actions = new Actions(DriverManager.getWebDriver());
		for (int i = 0; i < times; i++) {
			actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
		}
		BrowserUtils.wait(1);
	}

}
