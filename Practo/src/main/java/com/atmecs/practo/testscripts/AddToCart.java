package com.atmecs.practo.testscripts;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.practo.constants.PageActions;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.testbase.InvokeBrowser;
import com.atmecs.practo.utils.ValidateTestResult;

public class AddToCart extends InvokeBrowser {

	@Test(priority=1)
	public void diagnostics() throws Exception {

		ReadPropertiesFile read = new ReadPropertiesFile();

		String diagnostics = read.readPropertiesFile("loc.btn.diagnostics.xpath");
		PageActions.ClickElement(driver, diagnostics);

		String selectcity = read.readPropertiesFile("loc.field.selectanycityorlocality.xpath");
		PageActions.ClickElement(driver, selectcity);
		Thread.sleep(3000);
		String searchtest = read.readPropertiesFile("loc.field.searchfortestsandprofiles.xpath");
		PageActions.ClickElement(driver, searchtest);
		Thread.sleep(3000);

//To select CBC Test

		driver.findElement(By.cssSelector("#omniSearch")).sendKeys("CBC Test");
		driver.findElement(By.cssSelector("#omniSearch")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

// Click on Add to Cart

		driver.findElement(By.cssSelector(
				"#root-app > div > div > div:nth-child(2) > div > div.dg-wrapper.u-padb--dbl > div > div > div > div.c-group-details-wrapper > div > div > div.dg-six > div > div.o-flex.u-br-rule.u-marginb--double > div.o-flex.u-width--full > div.o-flex-column.c-qc__wrapper.u-pad--std > div > div"))
				.click();
		Thread.sleep(3000);

//Remove previous search(CBC Test)

		driver.findElement(By.cssSelector(
				"#root-app > div > div > div:nth-child(2) > div > div.u-separator.u-bg--white > div > div > div > div.o-flex-order--3.u-pointer > i"))
				.click();

// To select Serium Lipase and Add to Cart

		driver.findElement(By.cssSelector("#omniSearch")).sendKeys("Serum Lipase");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#omniSearch")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(
				"#root-app > div > div > div:nth-child(2) > div > div.dg-wrapper.u-padb--dbl > div > div > div > div.c-group-details-wrapper > div > div > div.dg-six > div > div.o-flex.u-br-rule.u-marginb--double > div.o-flex.u-width--full > div.o-flex-column.c-qc__wrapper.u-pad--std > div > div"))
				.click();
		Thread.sleep(3000);

//To remove the last search(SeriumLipase)

		driver.findElement(By.cssSelector(
				"#root-app > div > div > div:nth-child(2) > div > div.u-separator.u-bg--white > div > div > div > div.o-flex-order--3.u-pointer > i"))
				.click();

// To select T3 T4 TSH test

		driver.findElement(By.cssSelector("#omniSearch")).sendKeys("T3 T4 TSH");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#omniSearch")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

// Click on Add to Cart

		driver.findElement(By.cssSelector(
				"#root-app > div > div > div:nth-child(2) > div > div.dg-wrapper.u-padb--dbl > div > div > div > div.c-group-details-wrapper > div > div > div.dg-six > div > div.o-flex.u-br-rule.u-marginb--double > div.o-flex.u-width--full > div.o-flex-column.c-qc__wrapper.u-pad--std > div > div"))
				.click();
		Thread.sleep(3000);
		
	}
		//Validatation of total price after adding test samples
		
		@Test(priority=2)
	    public void softAssertion(){
			String price=driver.findElement(By.xpath("//span[text()='1040']")).getText();
	    	ValidateTestResult.validateData(price,"₹ 1040", "Price equals and test passed");
	    	
		
		}

}
