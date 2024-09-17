package com.opencart.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {

	public static WebDriver driver;
	
	public Registerpage(WebDriver d)
	{
		driver = d;
	}
	
	//======obj repository===========================
	
	private By firstname_textbox = By.xpath("//input[@name='firstname']");
	private By lastname_textbox = By.xpath("//input[@name='lastname']");
	private By email_textbox = By.xpath("//input[@name='email']");
	private By telephone_textbox = By.xpath("//input[@name='telephone']");
	private By password_textbox = By.xpath("//input[@name='password']");
	private By confirmpassword_textbox = By.xpath("//input[@name='confirm']");
	private By privacypolicy_radiobtn = By.xpath("//input[@type='checkbox']");
	private By clickOnContinueBtn = By.xpath("//input[@type='submit']");
	private By error_msg = By.xpath("//div[contains(@class,'alert-danger')]");
	
	
	//============actions method=======================
	
	public void enterFirstName(String firstname)
	{
		driver.findElement(firstname_textbox).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		driver.findElement(lastname_textbox).sendKeys(lastname);
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(email_textbox).sendKeys(email);
	}
	
	public void enterTelephone(String telephone)
	{
		driver.findElement(telephone_textbox).sendKeys(telephone);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(password_textbox).sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmpassword)
	{
		driver.findElement(confirmpassword_textbox).sendKeys(confirmpassword);
	}
	
	public void clickOnPrivacyPolicyBtn()
	{
		driver.findElement(privacypolicy_radiobtn).click();
	}
	
	public void clickOnContinueBtn()
	{
		driver.findElement(clickOnContinueBtn).click();
	}	
	
}
