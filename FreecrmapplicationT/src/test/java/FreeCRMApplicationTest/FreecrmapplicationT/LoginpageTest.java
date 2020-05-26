package FreeCRMApplicationTest.FreecrmapplicationT;

//import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.beust.jcommander.Parameter;
import com.freecrm.pages.Homepage;
import com.freecrm.pages.Loginpage;
import com.relevantcodes.extentreports.LogStatus;

//import com.freecrm.util.TestUtil;
//import FreeCRMApplicationTest.FreeCRMApplicationTest.TestUtil;
import FreeCRMApplicationTest.FreecrmapplicationT.TestUtil;
//import com.freecrmbase.Base;
//import FreeCRMApplicationTest.FreeCRMApplicationTest.Base;
import FreeCRMApplicationTest.FreecrmapplicationT.Base;

public class LoginpageTest extends Base {
	
	
	public LoginpageTest() throws IOException {
		super();
		
	}
	
	Loginpage loginpage;
	Homepage homepage;
	@Parameters({"browser"})
	@BeforeMethod
	public void setup(String browser) throws IOException
	{
		initialzation(browser);
		loginpage =new Loginpage();
	}
	
	@AfterMethod
	public void teardown(Method method ,ITestResult result) throws IOException
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
	@Test(priority=5)
	public void checkurl() 
	{
		logger=extent.startTest("checkurl");
		SoftAssert softassert =new SoftAssert();
		String actualresult="https://freecrm.com/";
		//String expectedresult=driver.getCurrentUrl();
		String expectedresult=loginpage.geturl();
		
		//Assert.assertEquals(actualresult, expectedresult);//hard assert
		softassert.assertEquals(actualresult, expectedresult);
		System.out.println("iam in the end");
		
		softassert.assertAll();
		//File srcFile = ((TakeScreenshot)driver).getScreeenshotAs(OutputTpye.FILE);
		
		
		
	}
	@Test (priority=6)
	public void login() throws IOException 
	{
		logger=extent.startTest("login") ;
		   // WebElement login= driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']"));
		      // login.click();
		     //  WebElement username=driver.findElement(By.name("email"));
		     //  username.sendKeys(pro.getProperty("username"));
		     //  WebElement pass=driver.findElement(By.name("password"));
		      // pass.sendKeys(pro.getProperty("password"));
		     //  WebElement log=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		     //  log.click();
		    homepage= loginpage.performloginpage();
		    
		      // WebElement cont=driver.findElement(By.xpath("//span[@class='user-display']"));
		         //cont.isDisplayed();
				// boolean actualresult=cont.isDisplayed();
		    boolean actualresult=homepage.contactdisplayed();
				 Assert.assertTrue(actualresult);
			
				
				 
	}
	/*@DataProvider
	public Object[][] mydata()
	{
		Object[][]  data= new Object[4][2];
		data[0][0]="abanobadel394@gmail.com";
		data[0][1]="19102013";
		data[1][0]="abanobadel394@gmail.com";
		data[1][1]="14256866";
		data[2][0]="abanobadel@gmail.com";
		data[2][1]="19102013";
		data[3][0]="abanobadel@gmail.com";
		data[3][1]="142536";
		  return data ;
		
	}*/
	
	
}
	
