package com.freecrm.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.util.WebListener;

public class TestBase 
{
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebListener weblistener;
	// public static ATUTestRecorder recoder;
	 
	  public TestBase() throws IOException
	  {
		   prop=new Properties();
	       FileInputStream fis=new FileInputStream("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\src\\main\\java\\com\\freecrm\\config\\cinfig.properties");
	       prop.load(fis);
	       
	  }
	  
	  
	public void initalization(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println("hi");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		weblistener=new WebListener();
		e_driver.register(weblistener);
		driver=e_driver;
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
}
