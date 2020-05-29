package org.nyiso.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.nyiso.pageobjects.GooglePage_Elements;
import org.nyiso.pageobjects.MonthlyCostPage_Elements;
import org.nyiso.utils.CommonFunctions;
import org.nyiso.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	private static Logger Log = Logger.getLogger(BaseTest.class.getName());

	public WebDriver driver;
	public String rootPath = System.getProperty("user.dir");
	public Properties appProps = new Properties();
	public SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public void setupBrowser() throws FileNotFoundException, IOException {
		Log.info("Before Class Annotation");
		appProps.load(new FileInputStream(rootPath + "/resources/Testdata.properties"));
		driver = commonfunctions().getChromeDriver();
		baseTest().setDriver(driver);
		driver.get(appProps.getProperty("url"));
	}

	@AfterClass
	public void Teardown() {
		Log.info("After Class Annotation");
		softAssert.assertAll();
		if (driver != null) {
			for (String eachWindowHandle : driver.getWindowHandles()) {
				// Close all browser windows initiated by WebDriver
				driver.switchTo().window(eachWindowHandle).close();
			}
		}
	}

	@BeforeSuite
	public void intializeSetUp() throws FileNotFoundException, IOException {
		PropertyConfigurator.configure(rootPath + "/resources/log4j2.properties");
	}

	public WebDriver getDriver() {
		Log.info("Get webdriver");
		return driver;
	}

	public void setDriver(WebDriver driver) {
		Log.info("Set webdriver");
		this.driver = driver;
	}

	public CommonFunctions commonfunctions() {
		Log.info("Initialize Commonfunction class");
		CommonFunctions obj = new CommonFunctions();
		return obj;
	}

	public BaseTest baseTest() {
		Log.info("Initialize BaseTest Class");
		BaseTest obj = new BaseTest();
		return obj;
	}

	public GooglePage_Elements googlePage_Ele() {
		Log.info("Initialize GooglePage Elements class");
		GooglePage_Elements obj = new GooglePage_Elements();
		return obj;
	}

	public MonthlyCostPage_Elements monthlyCost() {
		Log.info("Initialize MonthlyCostPageElements class");
		MonthlyCostPage_Elements obj = new MonthlyCostPage_Elements();
		return obj;
	}

}
