package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FreeCRMApplicationTest.FreecrmapplicationT.Base;

public class Contactpage extends Base {
	public Contactpage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	 
	@FindBy(xpath="//input[@class='search']")
	WebElement compay;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement save;
	
	public void addnewcontact(String fname,String lname,String company)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		compay.sendKeys(company);
		save.click();
	}
		
	
	
	

}
