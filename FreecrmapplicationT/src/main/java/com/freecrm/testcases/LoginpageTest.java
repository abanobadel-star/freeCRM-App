package com.freecrm.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
import com.freecrm.base.TestBase;

public class LoginpageTest extends TestBase {

	public LoginpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Parameters({"browser"})
	@BeforeMethod 
	public void setup(String browser,Method method)
	{
		initalization(browser);
		//recorder=new ATUTestRecorder("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\video",method.getName(),false);
		//recorder.start();
	}
	@AfterMethod 
	public void Teardown()
	{
		//recorder.stop();
		driver.quit();
	}

	@Test(priority=1)
	public void titleTest()  
	{
		String actualresutl=driver.getTitle();
		String  expectedresult="Free CRM #1 cloud software for any business large or small";
		System.out.println(actualresutl);
		Assert.assertEquals(expectedresult, actualresutl);//hard assertion
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualresutl, expectedresult);
		System.out.println("i love selemium");
		softassert.assertAll();
		//File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcFile, new File("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\Screenshot\\titleTest.png"));
		
	

	}
	@Test(priority=2)
	public void urlcheck()
	{
		String expectedreuslt="https://freecrm.com/";
		String actualreuslt=driver.getCurrentUrl();
		System.out.println(actualreuslt);
		AssertJUnit.assertEquals(expectedreuslt, actualreuslt);

	}
	@Test (priority=3)
	public void logoTest()
	{ 
		WebElement logo=driver.findElement(By.xpath("//img[@src='https://d19rqa8v8yb76c.cloudfront..net/img/free.crm.jpg']"));
		boolean actualresult=logo.isDisplayed();
		System.out.println(actualresult);
	    AssertJUnit.assertTrue(actualresult);

	}
	@Test(priority=4)
	public void login(String username, String password)
	{
		WebElement logintestbox=driver.findElement(By.name("username"));
		WebElement passwordTestbox=driver.findElement(By.name("password"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
		
		logintestbox.sendKeys(prop.getProperty("username"));
		passwordTestbox.sendKeys(prop.getProperty("password"));
		loginbutton.click();
		 String expectedresult="CRMPRO";
		 String actualreuslt=driver.getTitle();
		 AssertJUnit.assertEquals(expectedresult, actualreuslt);
				


	}
	/*@DataProvider
	public Object[][] Mydata()
	{
		Object[][] data= new Object[4][2];
		data[0][0]="hat123";
		data[0][1]="Teat@123";
		data[1][0]="hat123";
		data[1][1]="test";
		data[2][0]="hat";
		data[2][1]="Test@123";
		data[3][0]="hat22";
		data[3][1]="Teat22";
		return data;
	}*/
}
