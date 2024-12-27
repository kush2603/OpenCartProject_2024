package com.opencart.testbase;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.opencart.pagelayer.Homepage;
import com.opencart.pagelayer.Loginpage;
import com.opencart.pagelayer.Registerpage;
import com.opencart.utility.CommonComp;
import com.opencart.utility.Excelutils;

public class Testbase{
	
	public static WebDriver driver;
	public static Logger logger;
	 
	public Homepage homepage_obj;
	public Registerpage registerpage;
	public Loginpage loginpage_obj;
    public Excelutils excel_obj;
	public CommonComp commoncomp;
	
	@BeforeTest
     public void start()
    {
        logger = Logger.getLogger("**********CartOpen framework***********"); //choose-----> org.apache.log4j.Logger
        PropertyConfigurator.configure("logfile.properties");
        
        logger.info("*****framework execution started*****");
    }
	
	@AfterTest
     public void end()
    {
    	 logger.info("*******framework execution finished*********");
    }
     
	@BeforeMethod
	public void setUp() throws IOException
	{
		String browser_name = "chrome";
		if(browser_name.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		logger.info("browser launched with url");
		
		homepage_obj = new Homepage(driver);
		registerpage = new Registerpage(driver);
		loginpage_obj = new Loginpage(driver);
	    excel_obj = new Excelutils();
		commoncomp = new CommonComp(driver);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("browser closed");
	}
}
