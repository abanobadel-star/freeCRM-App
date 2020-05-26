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
import com.freecrm.pages2.Contactpage;
import com.freecrm.pages2.Homepage;
import com.freecrm.pages2.Loginpage;
import com.freecrm.util.TestUtil;

public class ContactPageTest  extends TestBase {

	public ContactPageTest() throws IOException {
		super();
	}
	Loginpage loginpage;
	Homepage homepage;
	Contactpage contactpage;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void login(String browser,Method method) throws IOException
	{
		initalization(browser);
		loginpage=new Loginpage();
		//recorder=new ATUTestRecorder("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\video",method.getName(),false);
		//recorder.start();
//		WebElement logintestbox=driver.findElement(By.name("username"));
//		WebElement passwordTestbox=driver.findElement(By.name("password"));
//		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
//		logintestbox.sendKeys(prop.getProperty("username"));
//		passwordTestbox.sendKeys(prop.getProperty("password"));
//		loginbutton.click();
		homepage=loginpage.performlogin();
	}
	@Test
	public void addcontact(String fname,String lname,String companyname,String departmentname) throws IOException
	{
		homepage.switchtoframe();
		contactpage=homepage.clickonnewcontact();
		contactpage.addnewcontact(fname, lname, companyname, departmentname);
		
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
