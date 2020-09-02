package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class HomePage {
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[@class='d-none d-sm-inline-block'][contains(text(),'Sign Up')]")
	private WebElement signUpbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Classrooms')]")
	private WebElement classroomsBtn;
	
	public void clickOnSignUpBtn(WebDriver driver)
	{
		signUpbtn.click();
		
		FileUtilities.verifyTitlePage(driver, "Welcome");
	}
	
	public void clickOnClassRoom(WebDriver driver)
	{
		classroomsBtn.click();
		FileUtilities.verifyTextMessage(driver, "//h2[contains(text(),'Classrooms')]", "Classrooms");
	}
	
}
