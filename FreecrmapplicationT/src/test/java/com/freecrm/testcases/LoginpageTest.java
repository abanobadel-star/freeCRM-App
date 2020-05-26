package com.freecrm.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
 
import com.freecrm.base.TestBase;
import com.freecrm.pages2.Homepage;
import com.freecrm.pages2.Loginpage;

public class LoginpageTest extends TestBase {

	public LoginpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Loginpage loginpage;
	Homepage homepage;
	@Parameters({"browser"})
	@BeforeMethod 
	public void setup(String browser,Method method) throws IOException
	{
		initalization(browser);
		loginpage=new Loginpage();
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
		String actualresutl=loginpage.gettitle();
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
		String actualreuslt=loginpage.getURL();
		System.out.println(actualreuslt);
		AssertJUnit.assertEquals(expectedreuslt, actualreuslt);

	}
	@Test (priority=3)
	public void logoTest()
	{ 
		
		boolean actualresult=loginpage.logoisDisplayed();
		System.out.println(actualresult);
	    AssertJUnit.assertTrue(actualresult);

	}
	@Test(priority=4)
	public void login(String username, String password) throws IOException
	{
//		WebElement logintestbox=driver.findElement(By.name("username"));
//		WebElement passwordTestbox=driver.findElement(By.name("password"));
//		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
//		
//		logintestbox.sendKeys(prop.getProperty("username"));
//		passwordTestbox.sendKeys(prop.getProperty("password"));
//		loginbutton.click();
		homepage=loginpage.performlogin();
		
		 String expectedresult="CRMPRO";
		 String actualreuslt=homepage.gettitle();
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
