package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.Base;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.LoginPage;

public class HomepageTest {
	
	
	Base basepage;
	Properties pro;
	WebDriver driver;
	LoginPage log;
	Homepage homepage;
	
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
}

@Test(priority=1)

public void verifyhomepagetitletest() {
	
	String homepagetitle = homepage.getHomepagetitle();
	System.out.println(homepagetitle);
	Assert.assertEquals(homepagetitle, "Account Setup | HubSpot");
}

@Test(priority=2)

public void verifyheaderpage() {
	
	Assert.assertTrue(homepage.verifyheader(),"Set up your HubSpot account");
}

@Test(priority=3)

public void verifyaccountnamehomepage() {
	
	String verifyaccountname = homepage.verifyaccountname();
	System.out.println(verifyaccountname);
	Assert.assertEquals(verifyaccountname, pro.getProperty("AccountName"));
}

@Test(priority=4)

public void verifyclickhomebutton() {
	
	String clikhombtn = homepage.Clikhombtn();
	System.out.println(clikhombtn);
	Assert.assertEquals(clikhombtn, "Service Dashboard");
}



@AfterMethod

public void TearDown() {
	
	driver.quit();
}

}
