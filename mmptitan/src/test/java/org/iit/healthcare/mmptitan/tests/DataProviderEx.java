package org.iit.healthcare.mmptitan.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {

	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", 36 ,12},
	   { "Anne", 37,12},
	   { "Cedric", 36 ,12},
	   { "Anne", 37,12}
	 };
	}

	//This test method declares that its data should be supplied by the Data Provider
	//named "test1"
	@Test(dataProvider = "test1")
	public void verifyData1(String n1, Integer n2) {
	 System.out.println(n1 + " " + n2);
	}
}
