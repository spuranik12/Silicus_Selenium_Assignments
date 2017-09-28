package com.orangeHrm.modules;

import org.openqa.selenium.By;

public class LoginIntoApplication 
{
	public void userLogin()
	{
		//user name
		BrowserOperations.driver.findElement(By.cssSelector("#txtUsername")).sendKeys("admin");
		
		//password
		BrowserOperations.driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin");
		
		//click on login
		BrowserOperations.driver.findElement(By.cssSelector("#btnLogin")).submit();
	}
	
	//*** Unit Testing ***
	public static void main(String[] args) {
		BrowserOperations.main(args);
		LoginIntoApplication obj1 = new LoginIntoApplication();
		obj1.userLogin();
	}
}
