package com.opencart.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.testbase.Testbase;

public class Homepage extends Testbase{

	public Homepage(WebDriver d)
	{
		driver = d;
	}
	
	//====obj repo=======
	
	private By myaccount_link = By.xpath("//span[text()='My Account']");
	private By register_link = By.xpath("//a[text()='Register']");
	private By login_link = By.xpath("//a[contains(text(),'Login')]");
	
	
	//=====actions method=====================
	public void clickOnMyAccount()
	{
		driver.findElement(myaccount_link).click();
	}
	
	public void clickOnRegisterLink()
	{
		driver.findElement(register_link).click();
	}
	
	public void clickOnLoginLink()
	{
		driver.findElement(login_link).click();
	}
	
}
