package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		contactsPage = new ContactsPage();
		loginPage=new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil=new TestUtil();
		testUtil.switchToFrame();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contactlabel is missing in the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactTest()
	{
		contactsPage.selectContactsByName("aaaa aa");
	}
	
	@Test(priority=3)
	public void selectmultipleContactTest()
	{
		contactsPage.selectContactsByName("aaaa aa");
		contactsPage.selectContactsByName("cccc cc");
	}
	
	@Test(priority=4)
	public void validatCreateNewContact()
	{
		homepage.clickOnContactsLink();
		contactsPage.createNewContact("Mr.", "Tom", "Peter" , "Google");
		
	}
	
	@AfterMethod
	public void tearOut() {
		driver.quit();
		
	}

}
