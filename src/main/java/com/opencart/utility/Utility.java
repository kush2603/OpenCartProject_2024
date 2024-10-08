package com.opencart.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.opencart.testbase.Testbase;

public class Utility extends Testbase{
	
	public static void getScreenshotMethod(String filename)
	{
		String path = "C:\\Users\\Sandeep Kushawaha\\eclipse-workspace\\CartOpen\\screenshot\\";
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path + filename + ".png");
			FileHandler.copy(src, des);
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToIframeByIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public static void switchToIframeByIdOrName(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public static void switchToParentPage()
	{
		driver.switchTo().parentFrame();
	}
	
	public static void selectOptionFromDropdown(WebElement element , String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	public static void cancelAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void mouseHoverOnElement(WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public static void dragAndDropOfElement(WebElement src, WebElement des)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).build().perform();
	}
	
	public static void switchToWindow()
	{
		Set<String> all_ids = driver.getWindowHandles();
		ArrayList<String> ids = new ArrayList<>(all_ids);
		driver.switchTo().window(ids.get(1));
	}
	public static void switchToParentWindow()
	{
		String parent_id = driver.getWindowHandle();
		driver.switchTo().window(parent_id);
	}
	
}
