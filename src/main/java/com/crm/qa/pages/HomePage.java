package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase 
{
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	//Initializing the Page Object
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();	
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		taskslink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactlink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();	
	}
	
	
	
	
	
}
