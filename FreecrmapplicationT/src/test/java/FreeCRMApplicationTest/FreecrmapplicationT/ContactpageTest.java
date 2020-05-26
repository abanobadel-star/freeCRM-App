package FreeCRMApplicationTest.FreecrmapplicationT;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.pages.Contactpage;
import com.freecrm.pages.Homepage;
import com.freecrm.pages.Loginpage;
import com.relevantcodes.extentreports.LogStatus;

//import FreeCRMApplicationTest.TestUtil;
//import com.freecrmbase.Base;

public class ContactpageTest extends Base
{

	public ContactpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	Loginpage loginpage;
	Homepage homepage;
	Contactpage contactpage;
	
	 @Parameters({"browser"})
		@BeforeMethod
		 public void setup(String browser) throws IOException
		 {
			 initialzation(browser);
			 loginpage=new Loginpage(); 
			 homepage=loginpage.performloginpage();
//			    WebElement login= driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']"));
//			       login.click();
//			       WebElement username=driver.findElement(By.name("email"));
//			       username.sendKeys(pro.getProperty("username"));
//			       WebElement pass=driver.findElement(By.name("password"));
//			       pass.sendKeys(pro.getProperty("password"));
//			       WebElement log=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
//			       log.click();
		 }
	 
	 @Test(dataProvider="testdata")
	 public void addnewcontact(String fname,String lname,String company) throws IOException
	 {
		 logger=extent.startTest("addnewcontact");
		// WebElement cont=driver.findElement(By.xpath("//a[@href='/contacts']"));
		// cont.click();
		// Actions action =new Actions(driver);
		// action.moveToElement(cont).build().perform();
		// WebElement  newcontact=driver.findElement(By.xpath("//a[@href='/contacts/new']"));
		 //newcontact.click();
		contactpage= homepage.clickonnewcontact();
		contactpage.addnewcontact(fname, lname, company);
		
//		 WebElement firstname=driver.findElement(By.name("first_name"));
//		 firstname.sendKeys(fname);
//		 WebElement lastname=driver.findElement(By.name("last_name"));
//		 lastname.sendKeys(lname);
//		 WebElement compay=driver.findElement(By.xpath("//input[@class='search']"));
//		 compay.sendKeys(company);
//		WebElement save=driver.findElement(By.xpath("//i[@class='save icon']"));
//		save.click();
//		
		 
		 
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
	 @DataProvider
	 public Object[][] testdata() throws Exception
	 {
		 Object data[][]= TestUtil.getdatafromexel("contactname");
		 return data;
		 
		 
	 }
	 
	

}
