package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class SubClass_Subject {

	public SubClass_Subject(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Automation Testing')]")
	private WebElement course;
	
	public void clickOnAutomationTestingCourse(WebDriver driver)
	{
		course.click();
		FileUtilities.verifyTextMessage(driver, "//h3[contains(text(),'Automation Testing By TutorSanthosh')]", "Automation Testing By TutorSanthosh");
	}

}
