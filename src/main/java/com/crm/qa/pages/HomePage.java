package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//td[contains(text(),'User: Demo User')]")
	WebElement userNamelabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasksLink;
//Initialize page objects
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
		
		
	}
	
	public ContactsPage clickOnContactsLink() {
		
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		
		dealsLink.click();
		
		return new DealsPage();
	}
	
  public TasksPage clickOnTasksLink() {
	  tasksLink.click();
	  
	  return new TasksPage();
	  
  }
  
  public boolean userNameLabel() {
	  
	  return userNamelabel.isDisplayed();
	  
	
	  
  }
}


