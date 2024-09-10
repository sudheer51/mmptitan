package org.iit.healthcare.mmptitan.tests;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SanityTestsCustomMethods {
	WebDriver driver;
	@Test
	public void validateAllMenus()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		HashMap<String,String> hMap = new HashMap<String,String>();
		hMap.put("HOME", "Patient Portal");
//		hMap.put("Profile", "Personal Details");
//		hMap.put("Schedule Appointment", "Current Appointments");
//			
		checkMenu(hMap);

		
	}
	public void checkMenu(HashMap<String,String> hMap)
	{
		 
		    Set<String> keys = hMap.keySet();
		    for(String menuName:keys)
		    {
		    	try {
		    		String expected = hMap.get(menuName);
		    		driver.findElement(By.xpath("//span[contains(text(),'"+menuName+"')]")).click();
		    		String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		    		if(actual.equals(expected))
		    		{
		    			System.out.println("Checks for"+ menuName+" is completed");
		    		}
		    		
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("Not able to find the"+ menuName);
		    	}
		    }
			 
		 
		 
	}

}
