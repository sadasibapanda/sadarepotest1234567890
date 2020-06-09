package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.qa.hubspot.basepage.Base;
import com.qa.hubspot.pages.Contactspage;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.LoginPage;

public class Contactpagetest {

	Base basepage;
	Properties pro;
	WebDriver driver;
	LoginPage log;
	Homepage homepage;
	Contactspage contactpage;
	
	//BM-T-AF
@BeforeMethod

public void setup() {
	
	basepage=new Base();
    pro = basepage.init_properties();
    String browser=pro.getProperty("browser");
    driver= basepage.init_driver(browser);
    driver.get(pro.getProperty("url"));
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    log=new LoginPage(driver);
    //page chaining
   homepage= log.Dologin(pro.getProperty("username"), pro.getProperty("password"));
   contactpage=  homepage.goToContactsPage();
}
}
