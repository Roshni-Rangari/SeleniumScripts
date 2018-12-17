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

public class HomePageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest()
	{
		super();	
	}
	
	//test case should be separated -- independent with each other
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil=new TestUtil();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
