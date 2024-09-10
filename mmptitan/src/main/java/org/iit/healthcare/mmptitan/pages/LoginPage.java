package org.iit.healthcare.mmptitan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	private By usernameID = By.id("username");
	private By passwordID = By.id("password");
	private By submitName= By.name("submit");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 
	public void login(String uname,String pword)
	{
		driver.findElement(usernameID).sendKeys(uname );
		driver.findElement(passwordID).sendKeys(pword);
		driver.findElement(submitName ).click();
	}

}
