package com.freecrm.pages2;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class Loginpage extends TestBase {
	
	public Loginpage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront..net/img/free.crm.jpg']")
	WebElement logo;
	
	@FindBy(name="username")
	WebElement logintestbox;
	
	@FindBy(name="password")
	WebElement passwordTestbox;
	
	@FindBy(xpath="//input[@value='login']")
	WebElement loginbutton;
	
	public String gettitle()
	{
		String actualresutl=driver.getTitle();
		return actualresutl;
		
	}
	
	public String getURL()
	{
		String actualreuslt=driver.getCurrentUrl();
		return actualreuslt;
	}
	public boolean logoisDisplayed() {
		boolean actualresult=logo.isDisplayed();
		return actualresult;
	}
	public Homepage performlogin () throws IOException
	{
		logintestbox.sendKeys(prop.getProperty("username"));
		passwordTestbox.sendKeys(prop.getProperty("password"));
		loginbutton.click();
		return new Homepage();
	}
	
	

}
