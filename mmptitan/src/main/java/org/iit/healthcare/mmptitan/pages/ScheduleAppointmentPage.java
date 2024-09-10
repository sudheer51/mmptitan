package org.iit.healthcare.mmptitan.pages;

import java.util.HashMap;
import java.util.List;

import org.iit.healthcare.mmptitan.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {

	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public HashMap<String, String> bookAppointment(String doctor,String sym,String duration,String specialization) 
	{
		HashMap<String,String> expectedHMap= new HashMap<String,String>();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.
				xpath("//p[contains(text(),'"+specialization+"')]/parent::div/preceding-sibling::h4[contains(text(),'"+doctor+"')]/ancestor::ul/following-sibling::button")).
		click();
		expectedHMap.put("doctor",doctor);

		//Switch to a frame
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();

		int durationValue= Integer.parseInt(duration);

		String futureDateArr = Utility.getfutureDate( durationValue,"YYYY/MMMM/d");

		expectedHMap.put("date",Utility.getfutureDate(durationValue,"dd/MM/YYYY"));

		String futureDateYear=futureDateArr.split("/")[0];
		String futureDateMonth=futureDateArr.split("/")[1];
		String futureDateDay =futureDateArr.split("/")[2];


		String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

		while(!(futureDateYear.equals(actualYear)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

		while(!(futureDateMonth.equals(actualMonth)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
		driver.findElement(By.linkText(futureDateDay)).click();

		Select timeSelect = new Select(driver.findElement(By.id("time")));
		List<WebElement> timeSelectWE = timeSelect.getOptions();
		timeSelectWE.get(1).click();
		expectedHMap.put("time",timeSelect.getFirstSelectedOption().getText());


		//click on continue
		driver.findElement(By.id("ChangeHeatName")).click();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("sym")).sendKeys(sym);
		expectedHMap.put("sym",sym);

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		System.out.println("Expected HashMap" + expectedHMap);
		return expectedHMap;
	}
}
