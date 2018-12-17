7package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	;
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
	}
	
	@Test
	public void validateTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test
	public void validateCRMLogoTest()
	{
		boolean flag=loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateLoginPageTest()
	{
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
