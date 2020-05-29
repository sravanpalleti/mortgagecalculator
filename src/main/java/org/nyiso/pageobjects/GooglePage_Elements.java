package org.nyiso.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage_Elements {
	private static Logger Log = Logger.getLogger(GooglePage_Elements.class.getName());
	

	public WebElement search_TxtBx(WebDriver driver) {
		Log.info(" Page elements of Google page");
		return driver.findElement(By.name("q"));
	}
	

}
