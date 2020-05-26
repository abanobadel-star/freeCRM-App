package com.freecrm.pages2;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class Contactpage  extends TestBase{
	
	public Contactpage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="department")
	WebElement department;
	
	@FindBy(xpath="//input[@ value='save']")
	WebElement save;
	
	public void addnewcontact(String fname,String lname,String companyname,String departmentname)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(companyname);
		department.sendKeys(departmentname);
		save.click();
		
	}
	
	
}
