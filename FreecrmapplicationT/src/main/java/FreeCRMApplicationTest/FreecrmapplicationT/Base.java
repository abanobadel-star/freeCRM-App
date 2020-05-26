package FreeCRMApplicationTest.FreecrmapplicationT;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;

//import FreeCRMApplicationTest.FreeCRMApplicationTest.Webdriverlistener;
import FreeCRMApplicationTest.FreecrmapplicationT.Webdriverlistener;

public class Base {
	
	public static WebDriver driver;
	public static Properties pro;
	public static EventFiringWebDriver e_driver;
	public static Webdriverlistener weblistener;
	
	public static ExtentReports extent;
	public static ExtentTest  logger;
	
	public Base() throws IOException
	{
		 pro =new Properties();
		FileInputStream file=new FileInputStream("F:\\ITI software testing\\testing\\selenium work\\selenium_work\\src\\com\\freecrm\\confg\\confg.properties");
		pro.load(file);
	}
	
	public static void initialzation(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\Downloads\\chromedriver.exe");
			    driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
				{
			 System.setProperty("webdriver.gecko.driver", "F:\\ITI software testing\\testing\\selenium\\program\\geckodriver.exe");
			    driver = new FirefoxDriver();
				}
		
		  
		    e_driver=new  EventFiringWebDriver(driver);
		    weblistener =new Webdriverlistener();
		    e_driver.register(weblistener);
		    driver=e_driver;
		    driver.get(pro.getProperty("URL"));
		    //driver.get("https://freecrm.com");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
