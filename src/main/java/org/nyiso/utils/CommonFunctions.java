package org.nyiso.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.nyiso.tests.MortgageCalculator;

public class CommonFunctions {
	private static Logger Log = Logger.getLogger(MortgageCalculator.class.getName());

	// Get instance of chrome browser
	public WebDriver getChromeDriver() {
		Log.info("initiate Chrome driver");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	// Wait for the element
	public void waitForElement(WebDriver driver, final WebElement element) {
		Log.info("Wait for WebElement");
		try {
			// Wait for page to load
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (NoSuchElementException e) {
			Log.error(" Wait for element failed : NoSuchElementException");
			e.printStackTrace();
		} catch (TimeoutException te) {
			Log.error(" Wait for element failed : TimeoutException");
			te.printStackTrace();
		}

	}

	// Click Element
	public void click(WebDriver driver, final WebElement element) {
		Log.info("Click on WebElement ");
		try {
			new CommonFunctions().waitForElement(driver, element);
			if (element.isEnabled()) {
				element.click();
			}
		} catch (WebDriverException e) {
			Log.error(" Click element failed  : WebDriverException");
			e.printStackTrace();
		}

	}

	// Set Text to the Text box
	public String setText(WebDriver driver, WebElement element, String text) {
		Log.info("Set text to  WebElement ");
		try {
			new CommonFunctions().waitForElement(driver, element);
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (ElementNotVisibleException e) {
			Log.error("Element not found to SetText ::ElementNotVisibleException");
			e.printStackTrace();
		}
		return text;
	}

	// Get Text from the element
	public String getText(WebDriver driver, WebElement element) {
		Log.info("Get text of WebElement");
		String text = null;
		try {
			new CommonFunctions().waitForElement(driver, element);
			text = element.getText().trim();
		} catch (ElementNotVisibleException e) {			
			Log.error("Element text not visible to GetText :ElementNotVisibleException");
			e.printStackTrace();
		}
		return text;

	}

	// Capture screenshot
	public void captureScreenshot(WebDriver driver, String methodName) throws IOException {
		Log.info("captureScreenshot");
		try {

			// Check driver is not null
			if (driver != null) {
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Get user directory
				String dir = System.getProperty("user.dir") + "/screenshots/";
				// Get System time
				String captureTime = getCurrentTime();
				// Capture screenshot with method name and time
				FileUtils.copyFile(source, new File(dir + methodName + "_" + captureTime + ".png")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} catch (WebDriverException e) {
			Log.error("Exception while taking screenshot : WebDriverException");
			e.printStackTrace();
		}

	}

	public static String getCurrentTime() {
		Log.info("Get current time");
		// Get Current date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		// Format date
		String dateFormatted = dateFormat.format(date).toString();
		dateFormatted = dateFormatted.replace("-", "_"); //$NON-NLS-1$ //$NON-NLS-2$
		dateFormatted = dateFormatted.replace(" ", "_"); //$NON-NLS-1$ //$NON-NLS-2$
		dateFormatted = dateFormatted.replace(":", "_"); //$NON-NLS-1$ //$NON-NLS-2$
		// return
		return dateFormatted;
	}

}
