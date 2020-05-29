package org.nyiso.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MonthlyCostPage_Elements {
	private static Logger Log = Logger.getLogger(MonthlyCostPage_Elements.class.getName());
	
	public WebElement mortgageAmount_TxtBx(WebDriver driver) {
			Log.info("MonthlyCostPage elements : mortgageAmount_TxtBx ");
		return driver.findElement(By.xpath("//label[text()='Mortgage amount']/following-sibling::input"));}
	public WebElement interestRate_TxtBx(WebDriver driver) {
		Log.info("MonthlyCostPage elements : interestRate_TxtBx ");
		return driver.findElement(By.xpath("//label[text()='Interest rate (%)']/following-sibling::input"));}
	public WebElement mortgagePeriod_LstBx(WebDriver driver) {
		Log.info("MonthlyCostPage elements : mortgagePeriod_LstBx ");
		return driver.findElement(By.xpath("//div[@role='listbox']"));}
	public WebElement mortgagePeriod_LstBxValues(WebDriver driver, String value) {
		Log.info("MonthlyCostPage elements : mortgagePeriod_LstBxValues ");
		return driver.findElement(By.xpath("//*[@id=':"+value+"']/div"));}		
	public WebElement totalCostMortgage_LblTxt(WebDriver driver) {
		Log.info("MonthlyCostPage elements : totalCostMortgage_LblTxt ");
		return driver.findElement(By.xpath("//label[text()='Total cost of mortgage']/following-sibling::div[1]"));}
	public WebElement monthlyPayments_LblTxt(WebDriver driver) {
		Log.info("MonthlyCostPage elements : monthlyPayments_LblTxt ");
		return driver.findElement(By.xpath("//label[text()='Total cost of mortgage']/following-sibling::div[2]//div"));}

}
