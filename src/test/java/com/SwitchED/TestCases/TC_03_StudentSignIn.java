package com.SwitchED.TestCases;

import org.testng.annotations.Test;

import com.SwitchED.Generics.Baseclass;
import com.SwitchED.PageObjects.SignIn;
import com.aventstack.extentreports.Status;

public class TC_03_StudentSignIn extends Baseclass {

	public static SignIn si;
	public static TC_01_Homepage t1;
	
	@Test(priority = 6)
	public void SignInFunctionality() throws InterruptedException
	{
		test=reports.createTest("Sign In -> HOmepage", "Validating the Sign in functionality");
		si = new SignIn(driver);
		si.enterEmailAdress("ktsanthosh08@gmail.com");
		si.enterPassword("123456");
		si.clickOnLoginBtn();
	    t1 = new TC_01_Homepage();
		t1.ValidatingTitleOfTheHomePage();
		test.log(Status.INFO, "On Success, Student login into SwitchED");
	}

}
