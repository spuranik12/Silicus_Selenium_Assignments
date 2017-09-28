package com.orangeHrm.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddVacancies 
{
	public static WebElement element;
	
	public void openRecruitment()
	{
		BrowserOperations.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on Recruitment link
		BrowserOperations.driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule>b")).click();
	}
	
	public void openVacancies()
	{
		BrowserOperations.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on vacancies link 
		BrowserOperations.driver.findElement(By.cssSelector("#menu_recruitment_viewJobVacancy")).click();
		
		//Verify vacancies tab
		String tabName = BrowserOperations.driver.findElement(By.xpath("//h1[.='Vacancies']")).getText();
		System.out.println("Current Tab: " + tabName); 
		
		//click on Add button to create job vacancy
		BrowserOperations.driver.findElement(By.cssSelector("#btnAdd")).click();
	}
	
	public void addJobVacancy() 
	{
		BrowserOperations.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//select job title
		element = BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_jobTitle")); 
		Select selByVal = new Select(element); 
		selByVal.selectByValue("9");
		
		//select vacancy name
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_name")).sendKeys("Assistant CEO");
		
		//select hiring manager
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_hiringManager")).sendKeys("Linda Anderson");
		
		//enter number of positions
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_noOfPositions")).sendKeys("3");
		
		//enter description
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_description")).sendKeys("12+ years");
		
		//uncheck RSS Feed
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_publishedInFeed")).click();
		
		//click on save
		BrowserOperations.driver.findElement(By.cssSelector("#btnSave")).click();
		
		//verify edit button
		boolean verifyEdtBtn = BrowserOperations.driver.findElement(By.xpath("//input[@value='Edit']")).isDisplayed();
		System.out.println("Edit button is present: " + verifyEdtBtn);
		
		//click on back button
		BrowserOperations.driver.findElement(By.cssSelector("#btnBack")).click();
	}
	
	
	// *** Unit Testing ***
	public static void main(String[] args) {
		LoginIntoApplication.main(args);
		AddVacancies obj1 = new AddVacancies();
		obj1.openRecruitment();
		obj1.openVacancies();
		obj1.addJobVacancy();
	}
}
