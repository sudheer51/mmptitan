package org.iit.healthcare.openmrs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageServiceTypesMValues {
	WebDriver driver ;
	@Test
	public void validateServiceTypes()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/index.htm");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();

		String serviceTypeArr[]= {"Dermatology","Urology"};
		SoftAssert sa = new SoftAssert();
		for(int i=0;i<serviceTypeArr.length;i++)
		{
			boolean result = fetchDurationValue(serviceTypeArr[i]);
			sa.assertTrue(result,"Result for ServiceType"+serviceTypeArr[i] );

		}

		sa.assertAll();

	}

	public boolean fetchDurationValue(String searchServiceType)
	{
		boolean result = false;
		String durationValue="";

		//Logic Starts
		List<WebElement> pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		System.out.println(pageList.size());// => 3 
		for(int i=0;i<pageList.size();i++)//->0,1,2
		{
			try {
				if(i!=0)
				{		 
					pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
					pageList.get(i).click();
					if(driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).isDisplayed())
					{
						System.out.println("ServiceType "+searchServiceType +"is available in the Page No: " + i+1);
						durationValue=driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).getText();
						result=true;
						break;
					}

				}
				else
				{
					if(driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).isDisplayed())
					{
						System.out.println("ServiceType "+searchServiceType +"is available in the Page No:  " + i+1);
						durationValue=driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).getText();
						result=true;
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("ServiceType "+searchServiceType +" not available in the Page No:" + (i+1));
			}
			 
		}
		return result;
	}
	 
	
}
