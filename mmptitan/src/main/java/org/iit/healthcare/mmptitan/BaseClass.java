package org.iit.healthcare.mmptitan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	protected Properties prop;
	@BeforeClass
	public void instantiateDriver() throws FileNotFoundException, IOException
	{
		ProjectConfiguration projConfig = new ProjectConfiguration();
		prop =projConfig.readPropertyFile("config//mmp_global.properties");
		String browserName= prop.getProperty("browsername");
		String environment = prop.getProperty("environment");//dev
		if(environment.equals("qa"))
		{
			prop =projConfig.readPropertyFile("config//mmp_qa.properties");
		}
		else if(environment.equals("dev"))
		{
			prop=projConfig.readPropertyFile("config//mmp_dev.properties");
		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("patient_url"));

	}

}
