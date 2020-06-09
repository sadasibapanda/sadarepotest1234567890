package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.Base;

public class Contactspage extends Base {

	WebDriver driver;
	
	By CreatecontactButton=By.xpath("//span[text()='Create contact']");
	By Createcontactformbutton=By.xpath("//li//span[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstname=By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
	
	public Contactspage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String getcontactpagetitle() {
		
		return driver.getTitle();
	}
	
	
}
