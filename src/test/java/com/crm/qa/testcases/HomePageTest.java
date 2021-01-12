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

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		
		super();
		
	}
	@BeforeMethod
	public void SetUp() {

		Initialization();

		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest() {
		
		
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO" , "Home Page title not matched");
	}

	@Test(priority=2)
  public void verifyUserNameTest() {
		
		
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.userNameLabel());
	}
	
	@Test(priority=3)
	
	public void clickOnContactsLinkTest() {
	testUtil.switchToFrame();
    contactsPage = homepage.clickOnContactsLink();
		
	}
	@AfterMethod
	public void tearDwon() {
		
		driver.quit();
	}
}
