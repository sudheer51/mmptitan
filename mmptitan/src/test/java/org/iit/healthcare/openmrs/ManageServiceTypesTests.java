package org.iit.healthcare.openmrs;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageServiceTypesTests {

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
		
		//Logic Starts
		List<WebElement> pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		System.out.println(pageList.size());// => 3 

		HashMap<String,Integer> serviceTypeHMap = new HashMap<String,Integer>();
		for(int i=0;i<pageList.size();i++)//->0,1,2
		{
			if(i!=0)
			{		pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
					pageList.get(i).click();
					List<WebElement> serviceTypeList = driver.findElements(By.xpath("//tbody//tr/td[1]"));
					List<WebElement> durationList = driver.findElements(By.xpath("//tbody//tr/td[2]"));
					for(int j=0;j<serviceTypeList.size();j++)
					{
					
						serviceTypeHMap.put(serviceTypeList.get(j).getText(),Integer.parseInt(durationList.get(j).getText()));
					}
			}
			else
			{
				List<WebElement> serviceTypeList = driver.findElements(By.xpath("//tbody//tr/td[1]"));
				List<WebElement> durationList = driver.findElements(By.xpath("//tbody//tr/td[2]"));
				for(int j=0;j<serviceTypeList.size();j++)
				{
				
					serviceTypeHMap.put(serviceTypeList.get(j).getText(),Integer.parseInt(durationList.get(j).getText()));
				}
			}


		}
		System.out.println(serviceTypeHMap);

	}

}
