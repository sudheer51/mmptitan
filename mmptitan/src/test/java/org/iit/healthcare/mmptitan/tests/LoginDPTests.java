package org.iit.healthcare.mmptitan.tests;

import java.io.IOException;

import org.iit.healthcare.mmptitan.Utility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDPTests {
	@DataProvider(name = "mmpdata")
	public String[][] createData1() throws IOException
	{
	
		return Utility.readXLSX("mmpdata.xlsx","data");
	}
	@Test(dataProvider="mmpdata")
	public void login(String uname,String pword)
	{
		System.out.println("username::" + uname);
		System.out.println("password::" + pword);
	}
	 
}

