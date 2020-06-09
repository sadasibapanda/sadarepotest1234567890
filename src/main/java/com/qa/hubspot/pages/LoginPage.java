package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.basepage.Base;

public class LoginPage extends Base {
  
	WebDriver driver;
	
	//Page objects with By locators
	By emailid=By.id("username");
	By passwd=By.id("password");
	By Login=By.id("loginBtn");
	By Signuplink=By.linkText("Sign up");
	By Facebooklink=By.xpath("//span[text()='Sign in with Google']");
	By SSOLink=By.xpath("//button[@id='ssoBtn']");
	
	//constructor of page class
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	//page Action/ page Methods
	
	public String getpagetitle() {
		
	String title=driver.getTitle();
	System.out.println("login page title is: "+ title);
	return title;
	}
	
	public boolean verifysignuplink() {
		
		return driver.findElement(Signuplink).isDisplayed();
		
	}
	
	public boolean verifyfacebboklink() {
		
		return driver.findElement(Facebooklink).isDisplayed();
	}
	
	public boolean verifySSO() {
		
		return driver.findElement(SSOLink).isDisplayed();
	}
	
	public Homepage Dologin(String username,String password) {
		
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(passwd).sendKeys(password);
		driver.findElement(Login).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Homepage(driver);
	}

}
