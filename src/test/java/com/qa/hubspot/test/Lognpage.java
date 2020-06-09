package com.qa.hubspot.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.Base;
import com.qa.hubspot.pages.LoginPage;

public class Lognpage  {

	Base basepage;
	Properties pro;
	WebDriver driver;
	LoginPage log;
	
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
}

@Test(priority=1)

public void verifyLoginpagetitle() throws InterruptedException {
	Thread.sleep(9000);
	String getpagetitle = log.getpagetitle();
	Assert.assertEquals(getpagetitle, "HubSpot Login");
}

@Test(priority=2)

public void VerifySignupLink() throws InterruptedException {
	Thread.sleep(10000);
Assert.assertTrue(log.verifysignuplink(),"Signup link is not displayed");
}

@Test(priority=3)

public void verifyFacebooklink() {
	
	Assert.assertTrue(log.verifyfacebboklink(), "Facebook link is not displayed");
}

@Test(priority=4)

public void verifySSOlinkinloginpage() {
	
	Assert.assertTrue(log.verifySSO(), "SSO link is not displayed");
}

@Test(priority=5)

public void logintest() throws InterruptedException {
	Thread.sleep(10000);
	log.Dologin(pro.getProperty("username"), pro.getProperty("password"));
	Thread.sleep(10000);
}


@AfterMethod

public void TearDown() {
	
	driver.quit();
}
	
	
	
	
	
	
	
	
	
}
