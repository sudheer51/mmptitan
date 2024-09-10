package org.iit.healthcare.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddServiceTypeTests {
	
	WebDriver driver ;
	@Test
	public void validateAddServiceType()
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

		ManageServiceTypesFuncLib funcLib = new ManageServiceTypesFuncLib(driver);
		funcLib.addServiceType("Cardiology", "30");
		boolean result = funcLib.searchServiceType("Cardiology");
		Assert.assertTrue(result);
	}

}
