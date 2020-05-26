package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages2.Homepage;
import com.freecrm.pages2.Loginpage;

public class HomepageTest extends TestBase
{
	

	public HomepageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	Loginpage loginpage;
	Homepage homepage;
	@Parameters({"browser"}) //parameter to use browser chrome or firefox
	@BeforeMethod
	public void login(String browser,Method method) throws IOException
	{
		initalization(browser);	
		loginpage=new Loginpage();
		//recorder=new ATUTestRecorder("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\video",method.getName(),false);
		 //to recoder videos
		//recorder.start(); //to start recorder video
		
//		WebElement logintestbox=driver.findElement(By.name("username"));
//		WebElement passwordTestbox=driver.findElement(By.name("password"));
//		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
//		
//		logintestbox.sendKeys(prop.getProperty("username"));
//		passwordTestbox.sendKeys(prop.getProperty("password"));
//		loginbutton.click();
		homepage=loginpage.performlogin();
	}
	@Test(priority=5)
	public void ClickonContactsTest()
	{
		homepage.switchtoframe();
		homepage.clickoncontact();
		boolean actulresult=homepage.iscontactstatusdisplayed();
		Assert.assertTrue(actulresult);
		
		
	}
	@Test(priority=6)
	public void ClickonDealsTest()
	{
		homepage.switchtoframe();
		homepage.clickondeals();
		boolean actulresult=homepage.isdealsisDisplayed();
		Assert.assertTrue(actulresult);
	}
	@Test(priority=7)
	public void ClickonTasksTest()
	{
		homepage.switchtoframe();
		homepage.clickontasks();
		boolean actulresult=homepage.istaskisDisplayed();
		Assert.assertTrue(actulresult);
		
	}
	
	@AfterMethod 
	public void teardown()
	{
	//	recorder.stop(); //to stop recorder video
		driver.quit();
	}
	


}
