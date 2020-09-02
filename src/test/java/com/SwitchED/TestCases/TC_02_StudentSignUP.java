package com.SwitchED.TestCases;
import java.util.Random;

import org.testng.annotations.Test;
import com.SwitchED.Generics.Baseclass;
import com.SwitchED.PageObjects.HomePage;
import com.SwitchED.PageObjects.SignIn;
import com.SwitchED.PageObjects.SignUpPage;
import com.SwitchED.PageObjects.ThankYou_RegistrationPage;
import com.aventstack.extentreports.Status;

public class TC_02_StudentSignUP extends Baseclass 
{	
	public static HomePage hp;
	public static SignUpPage su;
	public static SignIn si ;
	@Test(priority = 2)
	public void validatingSignUpPage()
	{
		test=reports.createTest("SignUp", "Validating title of the SignUpPage");
		hp = new HomePage(driver);
		hp.clickOnSignUpBtn(driver);
		test.log(Status.INFO, "System should navigate to Sign UP Page");
	}

	@Test(priority = 3)
	public void SignUpPage_validatingTermsAndCondition() 
	{
		test=reports.createTest("Sign UP -> Terms and Condition page", "Validating the text");
		su = new SignUpPage(driver);
		su.clickOnTermsAndCondition(driver);
		test.log(Status.INFO, "System should naviate to Terms and Comdition Page");
		hp = new HomePage(driver);
		hp.clickOnSignUpBtn(driver);
	}
	
	@Test(priority = 4)
	public void validatingSignInLink()
	{
		test=reports.createTest("Sign Up -> Sign In link", "Validating the Sign in link");
		su = new SignUpPage(driver);
		su.clickOnLoginHereLink(driver);
		test.log(Status.INFO, "System should redirected to sign in page.");
		si = new SignIn(driver);
		si.clickOnRegisterLink(driver);
	}

	@Test(priority = 5)
	public void validatingSignUpFunctionality()
	{
		test=reports.createTest("SignUp - > Create an account", "Create an student Account");
		su = new SignUpPage(driver);
		su.selectStudioRadioBtn();
		su.enterTheFirstName("code");
		
		su.enterTheLastName("wave"); 
		Random rand = new Random(); //instance of random class
		int upperbound = 250000;
		//generate random values from 0-24000
		int random = rand.nextInt(upperbound);
		
		su.enterEmailAdress("Sa", random, "@gmail.com");
		su.enterPassword("123456");
		su.clickOnCheckList();
		su.clickOnRegister();
		su.verifyRegisterThankYouPage(driver);
		test.log(Status.INFO, "Successfully, Account has been created. User In Thank You Registraion Page");
		ThankYou_RegistrationPage tkr = new ThankYou_RegistrationPage(driver);
		tkr.clickOnLoginInBtn(driver);
		test.log(Status.INFO, "System should naviate to Sign In Page");
	}
}
