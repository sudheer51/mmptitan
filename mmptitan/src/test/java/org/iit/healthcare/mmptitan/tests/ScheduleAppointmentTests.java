package org.iit.healthcare.mmptitan.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.iit.healthcare.mmptitan.BaseClass;
import org.iit.healthcare.mmptitan.pages.HomePage;
import org.iit.healthcare.mmptitan.pages.LoginPage;
import org.iit.healthcare.mmptitan.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends BaseClass{

	 

	@Parameters({"doctor","sym","duration","specialization"})
	@Test
	public void validateBookAppointment(String doctor,String sym,String duration,String specialization) throws InterruptedException, FileNotFoundException, IOException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		HomePage homePage = new HomePage(driver);
		homePage.navigateToAModule();
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap = sPage.bookAppointment(doctor,sym,duration,specialization);
		HashMap<String,String> actualHMap =homePage.fetchPatientPortalData();
		Assert.assertTrue(expectedHMap.equals(actualHMap));

	}
	 
	 
	 

}
