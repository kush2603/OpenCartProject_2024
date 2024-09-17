package com.opencart.testlayer;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.opencart.testbase.Testbase;


public class RegisterTest extends Testbase{

	@Test
	
	public void validateRegisteringAccountByProvidingValidDetails()
	{
		String expected_result = "Your Account Has Been Created!";
		homepage_obj.clickOnMyAccount();
		homepage_obj.clickOnRegisterLink();
		
		registerpage.enterFirstName("david");
		registerpage.enterLastName("jaosn");
		registerpage.enterEmail("davidjason@gmail.com");
		registerpage.enterTelephone("456987568");
		registerpage.enterPassword("davidjason");
		registerpage.enterConfirmPassword("davidjason");
		registerpage.clickOnPrivacyPolicyBtn();
		registerpage.clickOnContinueBtn();
        logger.info("signup details entered");

		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		Assert.assertEquals(expected_result , actual_result);
				
	}
	
	@Test
	public void validateRegisteringAccountByProvidingExistingAccountDetails()
	{
		String expected_result = "Warning: E-Mail Address is already registered!";
		
		homepage_obj.clickOnMyAccount();
		homepage_obj.clickOnRegisterLink();
		logger.info("on register page");
		registerpage.enterFirstName("sam");
		registerpage.enterLastName("nobel");
		registerpage.enterEmail("sam123@gmail.com");
		registerpage.enterTelephone("456987568");
		registerpage.enterPassword("samnobel");
		registerpage.enterConfirmPassword("samnobel");
		registerpage.clickOnPrivacyPolicyBtn();
		registerpage.clickOnContinueBtn();
		logger.info("acount details entered");
		
		String actual_result = commoncomp.getErrorMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(expected_result , actual_result);
				
		
	}
	
	
}
