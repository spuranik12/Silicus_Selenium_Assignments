package com.orangeHrm.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserOperations 
{
	public static WebDriver driver;
	
	@BeforeTest
	public void startBrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
	}
	@Test 
	public void launchURL()
	{
		driver.get("http://opensource.demo.orangehrmlive.com/");
		System.out.println("Current URL: "+ driver.getCurrentUrl());
	}
	
	//***Unit Testing***
	public static void main(String[] args) {
		BrowserOperations obj1 = new BrowserOperations();
		obj1.startBrowser();
		obj1.launchURL();
		//obj1.closeBrowser();
	}
}
