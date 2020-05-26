package com.freecrm.testcases;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtil;

public class ContactPageTest  extends TestBase {
	public ContactPageTest() throws IOException {
		super();
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void login(String browser,Method method)
	{
		initalization(browser);
		//recorder=new ATUTestRecorder("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\video",method.getName(),false);
		//recorder.start();
		WebElement logintestbox=driver.findElement(By.name("username"));
		WebElement passwordTestbox=driver.findElement(By.name("password"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
		
		logintestbox.sendKeys(prop.getProperty("username"));
		passwordTestbox.sendKeys(prop.getProperty("password"));
		loginbutton.click();
	}
	@Test
	public void addcontact()
	{
		driver.switchTo().frame("mainpanel");
		WebElement contact=driver.findElement(By.xpath("//a[text()='contacts']"));
		Actions action= new Actions(driver);
		action.moveToElement(contact).build().perform();
		WebElement newcontact=driver.findElement(By.xpath("//a[text()='newcontact']"));
		newcontact.click();
		WebElement firstname=driver.findElement(By.id("firstname"));
		firstname.sendKeys("abanob");
		WebElement lastname=driver.findElement(By.id("lastname"));
		lastname.sendKeys("adel");
		WebElement company=driver.findElement(By.id("company"));
		company.sendKeys("iti");
		WebElement department=driver.findElement(By.id("department"));
		department.sendKeys("QA");
		WebElement save=driver.findElement(By.xpath("//input[@ value='save']"));
	    save.click();
	    
	}
	
	
	@AfterMethod 
	public void teardown()
	{
	//	recorder.stop(); //to stop recorder video
		driver.quit();
	}
	@DataProvider
	public Object[][] testdata() throws IOException
	{
		Object data[][]=TestUtil.getdatafromExcel("contactname");
		return data;
	 
	}
	

}
