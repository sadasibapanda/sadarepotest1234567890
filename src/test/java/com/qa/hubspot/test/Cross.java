package com.qa.hubspot.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cross {
 @Test(invocationCount=2)
 @Parameters("Browser")
 public void test1(String browser) {
	 
	 if (browser.equalsIgnoreCase("chrome")) {
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();	
		 driver.get("https://www.facebook.com");
	 }
	 
	 else if(browser.equalsIgnoreCase("FF")) {
		 
     	WebDriverManager.firefoxdriver().setup();
     	WebDriver driver=new FirefoxDriver();
   	    driver.get("https://www.facebook.com");
	 }
	 
	 else {
		 
		 System.out.println("There is an error launching the browser");
	 }
 }
}
