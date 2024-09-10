package org.iit.healthcare.openmrs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageServiceTypesSpecificValue {

	@Test
	public void validateServiceTypes()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/index.htm");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
		String searchServiceType="ABC";
		String durationValue="";
		//Logic Starts
		List<WebElement> pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		System.out.println(pageList.size());// => 3 
		boolean result = false;
		for(int i=0;i<pageList.size();i++)//->0,1,2
		{
			try {
				if(i!=0)
				{		 
					pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
					pageList.get(i).click();
					if(driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).isDisplayed())
					{
						durationValue=driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).getText();
						result=true;
						break;
					}

				}
				else
				{
					if(driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).isDisplayed())
					{
						durationValue=driver.findElement(By.xpath("//td[text()='"+searchServiceType+"']/following-sibling::td[1]")).getText();
						result=true;
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("ServiceType "+searchServiceType +" not available in the Page No:" + i+1);
			}


		}
		System.out.println("Duration value for the "+searchServiceType+"  is :::: "+ durationValue);
		Assert.assertTrue(result);
	}

}
