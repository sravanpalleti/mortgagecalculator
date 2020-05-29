package org.nyiso.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.nyiso.helpers.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MortgageCalculator extends BaseTest {

	private static Logger Log = Logger.getLogger(MortgageCalculator.class.getName());
	String expectedCostOfMortgage, expectedmonthlyPayments;
	
	/*********************
	 * DESCRIPTION OF TEST CLASS : Calculating monthly cost of mortgage amount by providing different combination of test data  values 
	 * 							   from properties file and asserting values to 'COST OF MORTGAGE'and 'MONTHLY PAYMENTS'.
	 * 
	 * Screenshot: Screenshots are captured and saved to screenshots folder in workspace for final result
	 * 
	 ********************/
	
	@Test
	public void TC1_calculateMortgageWithIntegerValues() throws InterruptedException, IOException {
		Log.info("TestCase 1 : TC1_calculateMortgageWithIntegerValues");
		commonfunctions().setText(driver, monthlyCost().mortgageAmount_TxtBx(driver), appProps.getProperty("MTA"));
		commonfunctions().setText(driver, monthlyCost().interestRate_TxtBx(driver), appProps.getProperty("IR"));
		commonfunctions().click(driver, monthlyCost().mortgagePeriod_LstBx(driver));
		commonfunctions().click(driver, monthlyCost().mortgagePeriod_LstBxValues((driver), appProps.getProperty("MP")));
		commonfunctions().captureScreenshot(driver, "Test scenario1");
		expectedCostOfMortgage = commonfunctions().getText(driver, monthlyCost().totalCostMortgage_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("ActualCostOfMortgage"), expectedCostOfMortgage,"Total cost of mortgage");
		expectedmonthlyPayments = commonfunctions().getText(driver, monthlyCost().monthlyPayments_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("ActualMonthlyPayment"), expectedmonthlyPayments,"Monthly payments");
	}

	@Test
	public void TC2_calculateMortgageWithDoubleValues() throws InterruptedException, IOException {
		Log.info("TestCase 2 : TC2_calculateMortgageWithDoubleValues");
		commonfunctions().setText(driver, monthlyCost().mortgageAmount_TxtBx(driver), appProps.getProperty("MTAd"));
		commonfunctions().setText(driver, monthlyCost().interestRate_TxtBx(driver), appProps.getProperty("IRd"));
		commonfunctions().click(driver, monthlyCost().mortgagePeriod_LstBx(driver));
		commonfunctions().click(driver,monthlyCost().mortgagePeriod_LstBxValues((driver), appProps.getProperty("MPd")));
		commonfunctions().captureScreenshot(driver, "Test scenario2");
		expectedCostOfMortgage = commonfunctions().getText(driver, monthlyCost().totalCostMortgage_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("ActualCostOfMortgaged"), expectedCostOfMortgage,"Total cost of mortgage");
		expectedmonthlyPayments = commonfunctions().getText(driver, monthlyCost().monthlyPayments_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("ActualMonthlyPaymentd"), expectedmonthlyPayments,"Monthly payments");
	}

	@Test()
	public void TC3_calculateMortgageWithZeroMortgageAmount() throws InterruptedException, IOException {
		Log.info("TestCase 3 : TC3_calculateMortgageWithZeroMortgageAmount");
		commonfunctions().setText(driver, monthlyCost().mortgageAmount_TxtBx(driver), appProps.getProperty("MTA3"));
		commonfunctions().setText(driver, monthlyCost().interestRate_TxtBx(driver), appProps.getProperty("IR3"));
		commonfunctions().click(driver, monthlyCost().mortgagePeriod_LstBx(driver));
		commonfunctions().click(driver,monthlyCost().mortgagePeriod_LstBxValues((driver), appProps.getProperty("MP3")));
		commonfunctions().captureScreenshot(driver, "Test scenario3");
		expectedCostOfMortgage = commonfunctions().getText(driver, monthlyCost().totalCostMortgage_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("DPTotalMortgage"), expectedCostOfMortgage,"Total cost of mortgage");
		expectedmonthlyPayments = commonfunctions().getText(driver, monthlyCost().monthlyPayments_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("DPMonthlyPayments"), expectedmonthlyPayments, "Monthly payments");
	}

	@Test()
	public void TC4_calculateMortgageWithZeroInterestRate() throws InterruptedException, IOException {
		Log.info("TestCase 4 : TC4_calculateMortgageWithZeroInterestRate");
		commonfunctions().setText(driver, monthlyCost().mortgageAmount_TxtBx(driver), appProps.getProperty("MTA4"));
		commonfunctions().setText(driver, monthlyCost().interestRate_TxtBx(driver), appProps.getProperty("IR4"));
		commonfunctions().click(driver, monthlyCost().mortgagePeriod_LstBx(driver));
		commonfunctions().click(driver,monthlyCost().mortgagePeriod_LstBxValues((driver), appProps.getProperty("MP4")));
		commonfunctions().captureScreenshot(driver, "Test scenario4");
		expectedCostOfMortgage = commonfunctions().getText(driver, monthlyCost().totalCostMortgage_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("DPTotalMortgage4"), expectedCostOfMortgage,"Total cost of mortgage");
		expectedmonthlyPayments = commonfunctions().getText(driver, monthlyCost().monthlyPayments_LblTxt(driver));
		softAssert.assertEquals(appProps.getProperty("DPMonthlyPayments4"), expectedmonthlyPayments,"Monthly payments");
	}

	@BeforeMethod
	public void GotoMortgageCalculator() {
		commonfunctions().setText(driver, googlePage_Ele().search_TxtBx(driver), appProps.getProperty("googleSearch"));
		googlePage_Ele().search_TxtBx(driver).sendKeys(Keys.ENTER);
	}
	

}