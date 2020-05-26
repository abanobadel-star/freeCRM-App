package com.freecrm.pages2;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class Homepage extends TestBase {
	
	
	public Homepage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contacts;
	
	@FindBy( xpath="//td[text()='Status']")
	WebElement statuslabel;
	
	@FindBy( xpath="//a[text()='Deals']")
	WebElement deals;
	
	@FindBy( xpath="//td[text()='Keyword']")
	WebElement keywordlabeldeals;
	
	@FindBy( xpath="//td[text()='Keyword']")
	WebElement keywordlabeltask;
	
	@FindBy( xpath="//a[text()='Tasks']")
	WebElement tasks;
	
	@FindBy(xpath="//a[text()='newcontact']")
	WebElement newcontact;
	
	
	public String gettitle()
	{
		String actualresult=driver.getTitle();
		return actualresult;
	}
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}
	public void clickoncontact()
	{
		contacts.click();
		
	}
	public boolean iscontactstatusdisplayed()
	{
		boolean acutalresult=statuslabel.isDisplayed();
		return acutalresult;
	}
	public void clickondeals()
	{
		deals.click();
		
	}
	public  boolean isdealsisDisplayed()
	{
		boolean acutalresult=keywordlabeldeals.isDisplayed();
		return acutalresult;
	}
	public void clickontasks()
	{
		tasks.click();
	}
	public boolean istaskisDisplayed()
	{
		boolean acutalresult=keywordlabeldeals.isDisplayed();
		return acutalresult;
	}
	public Contactpage clickonnewcontact() throws IOException
	{
		Actions action= new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newcontact.click();
		return new Contactpage();
	}
	
	
	
}
