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

public class HomepageTest extends TestBase
{
	

	public HomepageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Parameters({"browser"}) //parameter to use browser chrome or firefox
	@BeforeMethod
	public void login(String browser,Method method)
	{
		initalization(browser);		
		//recorder=new ATUTestRecorder("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\video",method.getName(),false);
		 //to recoder videos
		//recorder.start(); //to start recorder video
		
		WebElement logintestbox=driver.findElement(By.name("username"));
		WebElement passwordTestbox=driver.findElement(By.name("password"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
		
		logintestbox.sendKeys(prop.getProperty("username"));
		passwordTestbox.sendKeys(prop.getProperty("password"));
		loginbutton.click();
	}
	@Test(priority=5)
	public void ClickonContactsTest()
	{
		driver.switchTo().frame("mainpanel");
		WebElement contacts=driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		WebElement statuslabel=driver.findElement(By.xpath("//td[text()='Status']"));
		boolean actulresult=statuslabel.isDisplayed();
		Assert.assertTrue(actulresult);
		
		
	}
	@Test(priority=6)
	public void ClickonDealsTest()
	{
		driver.switchTo().frame("mainpanel");
		WebElement deals=driver.findElement(By.xpath("//a[text()='Deals']"));
		deals.click();
		WebElement keywordlabel=driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actulresult=keywordlabel.isDisplayed();
		Assert.assertTrue(actulresult);
	}
	@Test(priority=7)
	public void ClickonTasksTest()
	{
		driver.switchTo().frame("mainpanel");
		WebElement tasks=driver.findElement(By.xpath("//a[text()='Tasks']"));
		tasks.click();
		WebElement keywordlabel=driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actulresult=keywordlabel.isDisplayed();
		Assert.assertTrue(actulresult);
		
	}
	
	@AfterMethod 
	public void teardown()
	{
	//	recorder.stop(); //to stop recorder video
		driver.quit();
	}
	


}
