package com.SwitchED.TestCases;

import org.testng.annotations.Test;

import com.SwitchED.Generics.Baseclass;
import com.SwitchED.Generics.FileUtilities;
import com.aventstack.extentreports.Status;

public class TC_01_Homepage extends Baseclass {
	
	@Test(priority = 1)
	public void ValidatingTitleOfTheHomePage()
	{
		test=reports.createTest("HomePage - Validating title Of the HomePage", "Validating title Of the HomePage");
		FileUtilities.verifyTitlePage(driver, "SwitchED");
		test.log(Status.INFO, "System should naviate to Home Page");
	}
	
}
