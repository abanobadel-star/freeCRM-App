package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FreeCRMApplicationTest.FreecrmapplicationT.Base;

public class Loginpage extends Base {
	
	public Loginpage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[@href='https://ui.freecrm.com']")
	WebElement login;
	
	@FindBy (name="email")
	WebElement username;
	
	@FindBy (name="password")
	WebElement pass;
	
	@FindBy (xpath="//div[@class='ui fluid large blue submit button']")
	WebElement log;
	@FindBy (xpath="//span[@class='user-display']")
	WebElement cont;
	
	public String geturl()
	{
		String actualresult=driver.getCurrentUrl();
		return actualresult;
	}
	public Homepage performloginpage() throws IOException
	{
		login.click();
		 username.sendKeys(pro.getProperty("username"));
		 pass.sendKeys(pro.getProperty("password"));
		 log.click();
		 return  new Homepage();
	}
	
	
	

}
