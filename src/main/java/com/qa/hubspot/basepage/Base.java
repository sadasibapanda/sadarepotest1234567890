package com.qa.hubspot.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equals("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}
		
		else if(browserName.equals("Firefox")) {
			
        	WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
        
		else if(browserName.equals("IE")) {
        	WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
        
        else {
        	
        	System.out.println("please enter correct browser Name");
        }
        
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();

        return driver;
		
	}
	
	public Properties init_properties() {
		
		 prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\HP\\eclipse-workspace_2ndNov\\DemoBatchPomSeries\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		
		     try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("config file is not found");
		}
		
		return prop;
	}
	
	
	
	
	

}
