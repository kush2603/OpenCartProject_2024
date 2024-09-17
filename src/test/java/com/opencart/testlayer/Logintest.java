package com.opencart.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencart.testbase.Testbase;


public class Logintest extends Testbase{
	
	@Test
	public void verifyLoginTestWithValidDetails() throws InterruptedException, IOException
	{
	//	CommonComp commoncomp = new CommonComp(driver);
		homepage_obj.clickOnMyAccount();
		Thread.sleep(2000);
		homepage_obj.clickOnLoginLink();
		Thread.sleep(2000);
		logger.info("on login page");	
		loginpage_obj.enterEmailAddress(excel_obj.readData("LoginData", 1, 1));
		Thread.sleep(2000);
		loginpage_obj.enterPassword(excel_obj.readData("LoginData", 1, 2));
		Thread.sleep(2000);
		loginpage_obj.clickOnLoginBtn();
		
		logger.info("login details entered");
		
		String actual_result = driver.getTitle();
		String expected_result = "My Account";
		System.out.println(actual_result);
		Assert.assertEquals(actual_result, expected_result);
		
	}
	
	@Test
	public void verifyLoginTestWithInValidDetails() throws InterruptedException
	{
		String expected_result = "Warning: No match for E-Mail Address and/or Password.";
	
		homepage_obj.clickOnMyAccount();
		homepage_obj.clickOnLoginLink();
		logger.info("on login page");
		Thread.sleep(2000);
		loginpage_obj.enterEmailAddress("davidjason@gmail.com");
		Thread.sleep(2000);
		loginpage_obj.enterPassword("david");
		Thread.sleep(2000);
		loginpage_obj.clickOnLoginBtn();
		logger.info("login details entered");
		
		String actual_result = commoncomp.getErrorMessage();
		Assert.assertEquals(actual_result, expected_result);
		
	}

}
