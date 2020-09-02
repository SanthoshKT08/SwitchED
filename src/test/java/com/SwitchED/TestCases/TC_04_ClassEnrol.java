package com.SwitchED.TestCases;

import org.testng.annotations.Test;

import com.SwitchED.Generics.Baseclass;
import com.SwitchED.PageObjects.ClassEnrol;
import com.SwitchED.PageObjects.ClassRooms;
import com.SwitchED.PageObjects.HomePage;
import com.SwitchED.PageObjects.RazorPay;
import com.SwitchED.PageObjects.SubClass_Subject;
import com.aventstack.extentreports.Status;

public class TC_04_ClassEnrol extends Baseclass {
	
	public static HomePage hp;
	public static SubClass_Subject sc;
	public static ClassRooms cr;
	public static ClassEnrol ce;
	public static RazorPay rp ;
	
	@Test(priority = 7)
	public void enrolClass() throws InterruptedException
	{
		test=reports.createTest("Home page -> Enroll class", "Validating enrol class");
	    hp = new HomePage(driver);
	    hp.clickOnClassRoom(driver);
	    test.log(Status.INFO, "Sytem should redirected to Classroom page");
	    cr = new ClassRooms(driver);
	    cr.clickOnCodingClass(driver);
	    test.log(Status.INFO, "Sytem should redirected to subclasses page");
	    sc = new SubClass_Subject(driver);
	    sc.clickOnAutomationTestingCourse(driver);
	    test.log(Status.INFO, "Sytem should redirected to enrol page");
	    ce = new ClassEnrol(driver);
	    ce.clickOnEnrol(driver);
	    test.log(Status.INFO, "System should redirected to Razorpay");
	    rp = new RazorPay(driver);
	    rp.clickOnPayNow();
	    rp.enterPhoneNumber(driver, "7904122045");
	    rp.enterEmailAddress(driver, "sa@gmail.com");
	    rp.clickOnProceed(driver);
	}

}
