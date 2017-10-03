package com.orangeHrm.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AddVacancies 
{
	public static WebElement element;
	
	@BeforeTest
	public void openRecruitment()
	{
		BrowserOperations.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on Recruitment link
		BrowserOperations.driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule>b")).click();
	}
	
	@Test
	public void openVacancies() throws InterruptedException
	{
		BrowserOperations.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on vacancies link 
		BrowserOperations.driver.findElement(By.cssSelector("#menu_recruitment_viewJobVacancy")).click();
		
		//Verify vacancies tab
		String tabName = BrowserOperations.driver.findElement(By.xpath("//h1[.='Vacancies']")).getText();
		System.out.println("Current Tab: " + tabName); 
		
		//click on Add button to create job vacancy
		BrowserOperations.driver.findElement(By.cssSelector("#btnAdd")).click();
		
		//Create new Job vacancy
		BrowserOperations.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//select job title
		element = BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_jobTitle")); 
		Select selByVal = new Select(element); 
		selByVal.selectByIndex(1);
		
		//select vacancy name
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_name")).sendKeys("Assistant CEO");
		
		//select hiring manager
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_hiringManager")).sendKeys("Linda Anderson");
		
		//enter number of positions
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_noOfPositions")).sendKeys("3");
		
		//enter description
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_description")).sendKeys("Description Added");
		
		//uncheck RSS Feed
		BrowserOperations.driver.findElement(By.cssSelector("#addJobVacancy_publishedInFeed")).click();
		
		//click on save
		BrowserOperations.driver.findElement(By.cssSelector("#btnSave")).click();
		
		//verify edit button
		String verifyEdtBtn = BrowserOperations.driver.findElement(By.xpath("//input[@value='Edit']")).getAttribute("value");
		
		if(verifyEdtBtn.contains("Edit"))
			System.out.println("Edit button is present.");
		else
			System.out.println("Edit button is not present.");
		
		//click on back button
		Thread.sleep(5000);
		BrowserOperations.driver.findElement(By.cssSelector("#btnBack")).click();
		
		//verify created job vacancy
		String verifyJobVacancy = BrowserOperations.driver.findElement(By.xpath("//a[.='Assistant CEO']")).getText();
		
		if(verifyJobVacancy.contains("Assistant CEO"))
			System.out.println("Job vacancy created successfully for 'Assistant CEO' position.");
		else
			System.out.println("Job vacancy is not created."); 
	}
	
	@AfterTest
	public void closeBrowser()
	{
		BrowserOperations.driver.quit();
	}
	
	// *** Unit Testing ***
	public static void main(String[] args) throws InterruptedException {
		LoginIntoApplication.main(args);
		AddVacancies obj1 = new AddVacancies();
		obj1.openRecruitment();
		obj1.openVacancies();
	}
}
