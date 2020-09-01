package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class ThankYou_RegistrationPage {
	
	public ThankYou_RegistrationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Login.')]")
	private WebElement signInBtn;
	
	public void clickOnLoginInBtn(WebDriver driver)
	{
		FileUtilities.handleExplicitWait(driver, "//a[contains(text(),'Login.')]");
		
		signInBtn.click();
		
		FileUtilities.verifyTextMessage(driver, "//h3[contains(text(),'Sign into your account')]", "Sign into your account");
	}


}
