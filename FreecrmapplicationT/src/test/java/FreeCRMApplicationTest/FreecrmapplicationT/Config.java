package FreeCRMApplicationTest.FreecrmapplicationT;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

//import com.aventstack.extentreports.ExtentReports;

public class Config extends Base {

	public Config() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeSuite
	public void start()
	{
		extent= new ExtentReports("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\TestReport",true);
		extent.addSystemInfo("OS", "windows");
		extent.addSystemInfo("owner", "abanob");
		extent.addSystemInfo("test name", "Free crm application");
		extent.addSystemInfo("language", "java");
		extent.addSystemInfo("framework dedign ", " page object");
		
	}
	
	@AfterSuite
	public void end()
	{
		extent.flush();
	}

}
