package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.Base;

public class Homepage extends Base{

	
	WebDriver driver;
	

	By header=By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	By clickbutton=By.xpath("//a[@id='account-menu']");
	By Accountname=By.xpath("//div[text()='sadasiba panda']");
	By Homebtn=By.xpath("(//*[@id=\"hs-nav-v4--logo\"])[1]");
	By homeheader=By.xpath("//h1[text()='Service Dashboard']");
	By mainContacts=By.id("nav-primary-contacts-branch");
	By SecondaryContact=By.id("nav-secondary-contacts");
	
	
	
	public Homepage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String getHomepagetitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyheader() {
		
		return driver.findElement(header).isDisplayed();
	}
	
	public String Clikhombtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(Homebtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(homeheader).getText();
		
		
	}
	
	
	
	public String verifyaccountname() {
		
		driver.findElement(clickbutton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return driver.findElement(Accountname).getText();
		
	}
	
	public void clickoncontact() {
		
		driver.findElement(mainContacts).click();
		
		driver.findElement(SecondaryContact).click();
		
	}
	
	public Contactspage goToContactsPage() {
		clickoncontact();
		return new Contactspage(driver);
	}
}
