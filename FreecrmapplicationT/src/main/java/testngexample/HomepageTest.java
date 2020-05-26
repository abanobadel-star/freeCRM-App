package testngexample;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomepageTest 
{
	WebDriver driver;
	@Parameters ({"URL"})
	@BeforeMethod (groups= {"E2E","regression","sanity"})
	public void login( String URL)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement logintestbox=driver.findElement(By.name("username"));
		WebElement passwordTestbox=driver.findElement(By.name("password"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@value='login']"));
		
		logintestbox.sendKeys("hat2003");
		passwordTestbox.sendKeys("Test@123");
		loginbutton.click();
	}
	@Test(priority=5, groups ={"E2E","sanity"})
	public void ClickonContactsTest()
	{
		driver.switchTo().frame("mainpanel");
		WebElement contacts=driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		WebElement statuslabel=driver.findElement(By.xpath("//td[text()='Status']"));
		boolean actulresult=statuslabel.isDisplayed();
		Assert.assertTrue(actulresult);
		
		
	}
	@Test(priority=6, groups= {"regression"})
	public void ClickonDealsTest()
	{
		driver.switchTo().frame("mainpanel");
		WebElement deals=driver.findElement(By.xpath("//a[text()='Deals']"));
		deals.click();
		WebElement keywordlabel=driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actulresult=keywordlabel.isDisplayed();
		Assert.assertTrue(actulresult);
	}
	@Test(priority=7, groups= {"E2E"})
	public void ClickonTasksTest()
	{
		driver.switchTo().frame("mainpanel");
		WebElement tasks=driver.findElement(By.xpath("//a[text()='Tasks']"));
		tasks.click();
		WebElement keywordlabel=driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actulresult=keywordlabel.isDisplayed();
		Assert.assertTrue(actulresult);
		
	}
	
	@AfterMethod (groups= {"E2E","regression","sanity"})
	public void teardown()
	{
		driver.quit();
	}
	


}
