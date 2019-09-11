package com.atmecs.practo.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.practo.utils.ValidateTestResult;

public class RemoveFromCart extends AddToCart{
	
	//Remove CBC Test from the cart
	
	@Test(priority=3)
	public void yourcart() throws Exception{
		driver.findElement(By.cssSelector("#root-app > div > div > div:nth-child(2) > div > div.dg-wrapper.u-padb--dbl > div > div > div > div.c-group-details-wrapper > div > div > div.dg-three.dg-last > div > div > div.c-shopping-cart__lower-wrapper > div > div:nth-child(1) > div.o-listitem__wrap--primary.c-testitem__wrap--primary > div.o-listitem__secondary.c-testitem__secondary > div > i")).click();
	Thread.sleep(3000);
	}

	//Validation of total price after removing one sample test
	
	@Test(priority=4)
    public void hardAssertion(){
		String finalprice=driver.findElement(By.xpath("//span[text()='740']")).getText();
    	ValidateTestResult.validateData(finalprice,"₹ 740", "Final Price equals and test passed");
    	
}
}