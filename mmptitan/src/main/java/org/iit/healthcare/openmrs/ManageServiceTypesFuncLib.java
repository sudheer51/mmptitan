package org.iit.healthcare.openmrs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageServiceTypesFuncLib {

	WebDriver driver;
	//add()
	ManageServiceTypesFuncLib(WebDriver driver)
	{
		this.driver = driver;
	}
	public void editServiceType(String serviceType,String duration)
	{
		
	}
	public void deleteServiceType(String serviceType)
	{
		
	}
	public void addServiceType(String serviceType,String duration)
	{
		driver.findElement(By.xpath("//div[@id='manageAppointmentsTypeTitle']/following-sibling::button")).click();
		WebElement nameWE = driver.findElement(By.id("name-field"));
		nameWE.clear();
		nameWE.sendKeys(serviceType);
		driver.findElement(By.id("duration-field")).sendKeys(duration);
		driver.findElement(By.id("save-button")).click();
		
	}
	public boolean searchServiceType(String searchServiceType)
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
