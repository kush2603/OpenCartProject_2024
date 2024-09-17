package com.opencart.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.testbase.Testbase;

public class Loginpage extends Testbase {
	
	public Loginpage(WebDriver d)
	{
		driver = d;
	}

	//========obj repository==============
	private By emailaddress_textbox = By.xpath("//input[@id='input-email']");
	private By password_tetxbox = By.xpath("//input[@id='input-password']");
	private By loginBtn = By.xpath("//input[@class='btn btn-primary']");	
	
	//--------actions method------===========
	public void enterEmailAddress(String emailaddress)
	{
		driver.findElement(emailaddress_textbox).sendKeys(emailaddress);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(password_tetxbox).sendKeys(password);
	}
	
	public void clickOnLoginBtn()
	{
		driver.findElement(loginBtn).click();
	}
}
