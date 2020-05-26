package testngexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class LoginpageTest {
	WebDriver driver;
	@Parameters ({"URL"})
	@BeforeMethod (groups= {"E2E","regression","sanity"})
	public void setup(String URL)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		
	}
	@AfterMethod (groups= {"E2E","regression","sanity"})
	public void Teardown()
	{
		driver.quit();
	}

	@Test(priority=1, groups= {"E2E"})
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
	

	}
	@Test(priority=2, groups= {"E2E"})
	public void urlcheck()
	{
		String expectedreuslt="https://freecrm.com/";
		String actualreuslt=driver.getCurrentUrl();
		System.out.println(actualreuslt);
		Assert.assertEquals(expectedreuslt, actualreuslt);

	}
	@Test (priority=3,groups= {"E2E"})
	public void logoTest()
	{ 
		WebElement logo=driver.findElement(By.xpath("//img[@src='https://d19rqa8v8yb76c.cloudfront..net/img/free.crm.jpg']"));
		boolean actualresult=logo.isDisplayed();
		System.out.println(actualresult);
	    Assert.assertTrue(actualresult);

	}
	@Test(priority=4,groups= {"E2E","regression","sanity"},dataProvider="Mydata")
	public void login(String username, String password)
	{
		WebElement logintestbox=driver.findElement(By.name("username"));
		WebElement passwordTestbox=driver.findElement(By.name("password"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
		
		logintestbox.sendKeys(username);
		passwordTestbox.sendKeys(password);
		loginbutton.click();
		 String expectedresult="CRMPRO";
		 String actualreuslt=driver.getTitle();
		 Assert.assertEquals(expectedresult, actualreuslt);
				


	}
	@DataProvider
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
	}
}
