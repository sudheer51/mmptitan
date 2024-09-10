package org.iit.healthcare.mmptitan.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[1]") 
	WebElement dateXpath;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[2]") 
	WebElement timeXpath;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[3]") 
	WebElement symXpath;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[4]") 
	WebElement doctorXpath;
	
	
	@FindBy(xpath="//span[contains(text(),'Schedule Appointment ')]")
	WebElement moduleXPath;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void navigateToAModule()
	{
		moduleXPath.click();

	}
	public HashMap<String, String> fetchPatientPortalData()
	{
		//10/01/2024 date- 	10Amtime	Cold and Cough sym	Bethdoctor
		HashMap<String,String> actualHMap= new HashMap<String,String>();
		actualHMap.put("date",  dateXpath.getText());  
		actualHMap.put("time", timeXpath.getText());  
		actualHMap.put("sym", symXpath.getText());   
		actualHMap.put("doctor", doctorXpath.getText());  
		return actualHMap;
	}
}
