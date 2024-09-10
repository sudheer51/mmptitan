package org.iit.healthcare.mmptitan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SanityTests {
	
	@Test
	public void validateAllMenus()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		SoftAssert sa = new SoftAssert();
		
		if(driver.findElement(By.xpath("//span[contains(text(),'HOME')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(text(),'HOME')]")).click();
			String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
			String expected= "Patient Portal";
			sa.assertEquals(actual, expected);
			System.out.println("#############################Completed the checks for HOME Menu####################################");
		}

		if(driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
			String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
			String expected= "Personal Details";
			sa.assertEquals(actual, expected);
		}
		if(driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment ')]")).click();
			String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
			String expected= "Current Appointments";
			sa.assertEquals(actual, expected);
		}
		
		sa.assertAll();
		
		
		
	}

}
