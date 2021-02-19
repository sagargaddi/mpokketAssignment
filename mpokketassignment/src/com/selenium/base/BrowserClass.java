package com.selenium.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BrowserClass {
	
	public static WebDriver driver = null;
	
	
	
	
	public static void launchBrowser() throws Exception
	{		
		String browser  = "https://www.amazon.in";
		
		System.out.println(browser);
		
		if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./utilities/geckodriver.exe");		
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./utilities/chromedriver.exe");			
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			new DesiredCapabilities();
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();		
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents", false);
			
			System.setProperty("webdriver.ie.driver", "./utilities/IEDriverServer.exe");
			driver = new InternetExplorerDriver(caps);
		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	

	public static void closeBrowser()
	{
		driver.quit();
	}
}


