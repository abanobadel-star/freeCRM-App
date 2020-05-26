package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FreeCRMApplicationTest.FreecrmapplicationT.Base;

public class Homepage extends Base {
	public Homepage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='/contacts']")
	WebElement cont;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contact;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement deal;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement deals;
	
	@FindBy (xpath="//div[@class='ui header item mb5 light-black']")
	WebElement task;
	
	@FindBy (xpath="//a[@href='/tasks']")
	WebElement tasks;
	 
	@FindBy (xpath="//span[@class='user-display']")
	WebElement name;
	
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newcontact;
	
	public Contactpage clickonnewcontact() throws IOException
	{
		cont.click();
		newcontact.click();
		return new Contactpage();
	}
			
	public boolean contactdisplayed()
	{
		return cont.isDisplayed();
	}
	
	
	public  void clickoncontact()
	{
		cont.click();
	}
	public boolean contactstatusdisplayed()
	{
		boolean iscontactdispalyed=contact.isDisplayed();
		return iscontactdispalyed;
	}
	public  void clickondeal()
	{
		deal.click();
	}
	public boolean dealstatusdisplayed()
	{
		boolean isdealsdispalyed=deals.isDisplayed();
		return isdealsdispalyed;
	}
	public  void clickontask()
	{
		task.click();
	}
	
	public boolean taskstatusdisplayed()
	{
		boolean istasksdispalyed=tasks.isDisplayed();
		return istasksdispalyed;
	}
	
	public boolean namestatusdisplayed()
	{
		boolean isnamedispalyed=name.isDisplayed();
		return isnamedispalyed;
	}
	
	
	
	
}
