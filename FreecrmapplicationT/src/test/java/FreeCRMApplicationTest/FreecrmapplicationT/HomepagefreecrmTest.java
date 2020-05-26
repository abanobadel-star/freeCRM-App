package FreeCRMApplicationTest.FreecrmapplicationT;

import java.io.IOException;
import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.pages.Homepage;
import com.freecrm.pages.Loginpage;
import com.relevantcodes.extentreports.LogStatus;

//import com.freecrm.util.TestUtil;
//import FreeCRMApplicationTest.FreeCRMApplicationTest.TestUtil;
//import FreeCRMApplicationTest.FreeCRMApplicationTest.Base;
//import com.freecrmbase.Base;
import FreeCRMApplicationTest.FreecrmapplicationT.TestUtil;
import FreeCRMApplicationTest.FreecrmapplicationT.Base;


public class HomepagefreecrmTest extends Base {
	
	
	 public HomepagefreecrmTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	 Loginpage loginpage;
	 Homepage homepage;
	 @Parameters({"browser"})
	@BeforeMethod
	 public void setup(String browser) throws IOException
	 {
		 initialzation(browser);
		 loginpage=new Loginpage();
//		    WebElement login= driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']"));
//		       login.click();
//		       WebElement username=driver.findElement(By.name("email"));
//		       username.sendKeys(pro.getProperty("username"));
//		       WebElement pass=driver.findElement(By.name("password"));
//		       pass.sendKeys(pro.getProperty("password"));
//		       WebElement log=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
//		       log.click();
		homepage= loginpage.performloginpage();
	 }
	 @AfterMethod
	 public void teardown(Method method,ITestResult result) throws IOException
	 {
		 TestUtil.takepicture(method.getName());
		 if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 logger.log(LogStatus.PASS, "test pass");
		 }
		 else if(result.getStatus()==ITestResult.FAILURE)
		 {
			 logger.log(LogStatus.FAIL, "test fail");
		 }
		 else
		 {
			 logger.log(LogStatus.SKIP, "test skip");
		 }
		 
		 driver.quit();
		 
	 }
	 @Test(priority=1)
	 public void contacts()
	 {
		 logger=extent.startTest("contacts");
		// WebElement cont=driver.findElement(By.xpath("//a[@href='/contacts']"));
		// cont.click();
		 homepage.clickoncontact();
		// WebElement contact=driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']"));
		// boolean actualresult=contact.isDisplayed();
		 boolean actualresult=homepage.contactdisplayed();
	
		 Assert.assertTrue(actualresult);
		
	 }
	 @Test(priority=2)
	 public void deals() 
	 {
		 logger=extent.startTest("deals");
		// WebElement deal=driver.findElement(By.xpath("//a[@href='/deals']"));
		 //deal.click();
		 homepage.clickondeal();
		 //WebElement deals=driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']"));
		 boolean actualresult=homepage.dealstatusdisplayed();
		 Assert.assertTrue(actualresult);
		
		  
	 }
	 @Test(priority=3)
	 public void tasks()
	 {
		 logger=extent.startTest("tasks");
	 // WebElement task=driver.findElement(By.xpath("//a[@href='/tasks']"));
		// task.click();
		 homepage.clickontask();
		// WebElement tasks=driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']"));
		// boolean actualresult=tasks.isDisplayed();
		 boolean actualresult=homepage.taskstatusdisplayed();
		 Assert.assertTrue(actualresult);
	
	 }
	 @Test(priority=4)
	 public void namedisplay() 
	 {
		 logger=extent.startTest("namedisplay");
		// WebElement name=driver.findElement(By.xpath("//span[@class='user-display']"));
		// name.isDisplayed();
		// boolean actualresult=name.isDisplayed();
		 boolean actualresult=homepage.namestatusdisplayed();
		 Assert.assertTrue(actualresult);
		
		  
	 }
	 
	 

}
